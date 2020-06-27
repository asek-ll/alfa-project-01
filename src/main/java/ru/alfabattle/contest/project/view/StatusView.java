package ru.alfabattle.contest.project.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusView {
    private final String status;

    public StatusView(@JsonProperty("status") String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
