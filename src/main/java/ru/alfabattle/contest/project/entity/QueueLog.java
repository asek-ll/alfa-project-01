package ru.alfabattle.contest.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="queue_log")
public class QueueLog {
    @Id
    private Long id;

    @Column(name = "branches_id")
    private Long branchesId;

    @Column
    private LocalDate data;

    @Column(name = "start_time_of_wait")
    private LocalTime startTimeOfWait;

    @Column(name = "end_time_of_wait")
    private LocalTime endTimeOfWait;

    @Column(name = "end_time_of_service")
    private LocalTime endTimeOfService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchesId() {
        return branchesId;
    }

    public void setBranchesId(Long branchesId) {
        this.branchesId = branchesId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getStartTimeOfWait() {
        return startTimeOfWait;
    }

    public void setStartTimeOfWait(LocalTime startTimeOfWait) {
        this.startTimeOfWait = startTimeOfWait;
    }

    public LocalTime getEndTimeOfWait() {
        return endTimeOfWait;
    }

    public void setEndTimeOfWait(LocalTime endTimeOfWait) {
        this.endTimeOfWait = endTimeOfWait;
    }

    public LocalTime getEndTimeOfService() {
        return endTimeOfService;
    }

    public void setEndTimeOfService(LocalTime endTimeOfService) {
        this.endTimeOfService = endTimeOfService;
    }
}
