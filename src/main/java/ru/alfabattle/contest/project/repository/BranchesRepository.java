package ru.alfabattle.contest.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alfabattle.contest.project.entity.Branch;

import java.util.Optional;

public interface BranchesRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findById(Long id);

}
