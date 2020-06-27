package ru.alfabattle.contest.project.entity;

import javax.persistence.*;

@Entity
@Table(name="branches")
public class Branch {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String address;

    @Column
    private Double lon;

    @Column
    private Double lat;

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


