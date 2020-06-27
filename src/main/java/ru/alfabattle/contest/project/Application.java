package ru.alfabattle.contest.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alfabattle.contest.project.entity.Branch;
import ru.alfabattle.contest.project.repository.BranchesRepository;
import ru.alfabattle.contest.project.utils.Coords;
import ru.alfabattle.contest.project.view.BranchView;
import ru.alfabattle.contest.project.view.BranchWithDistanceView;
import ru.alfabattle.contest.project.view.StatusView;

import java.util.Comparator;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Application {
    @Autowired
    private BranchesRepository branchesRepository;

    @RequestMapping("/branches/{id}")
    public ResponseEntity<Object> getBranch(@PathVariable("id") Long id) {
        Optional<Branch> branch = branchesRepository.findById(id);
        return branch
                .<ResponseEntity<Object>>map(value -> ResponseEntity.ok(new BranchView(value)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StatusView("branch not found")));
    }

    @RequestMapping(value = "/branches")
    public ResponseEntity<BranchWithDistanceView> getBranches(@RequestParam("lon") Double lon,
                                                              @RequestParam("lat") Double lat) {
        Coords coords = new Coords(lat, lon);
        BranchWithDistanceView result = branchesRepository.findAll().stream()
                .map(b -> Pair.of(b, new Coords(b.getLat(), b.getLon()).distanceToInMeters(coords)))
                .min(Comparator.comparing(Pair::getSecond))
                .map(p -> new BranchWithDistanceView(p.getFirst(), Math.round(p.getSecond())))
                .get();

        return ResponseEntity.ok(result);
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
