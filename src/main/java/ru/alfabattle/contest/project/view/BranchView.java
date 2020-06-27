package ru.alfabattle.contest.project.view;

import ru.alfabattle.contest.project.entity.Branch;

public class BranchView {
    private Long id;

    private String title;

    private String address;

    private Double lon;

    private Double lat;

    public BranchView() {
    }

    public BranchView(Branch branch) {
        id = branch.getId();
        title = branch.getTitle();
        address = branch.getAddress();
        lon = branch.getLon();
        lat = branch.getLat();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
