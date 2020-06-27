package ru.alfabattle.contest.project.view;

import ru.alfabattle.contest.project.entity.Branch;

public class BranchWithDistanceView extends BranchView {
    private Long distance;

    public BranchWithDistanceView() {
    }

    public BranchWithDistanceView(Branch branch, Long distance) {
        super(branch);
        this.distance = distance;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}
