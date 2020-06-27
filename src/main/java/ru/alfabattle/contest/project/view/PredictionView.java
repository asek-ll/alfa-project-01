package ru.alfabattle.contest.project.view;

import ru.alfabattle.contest.project.entity.Branch;

public class PredictionView extends BranchView{
    private int dayOfWeek;
    private int hourOfDay;
    private long predicting;

    public PredictionView() {
    }

    public PredictionView(Branch branch, int dayOfWeek, int hourOfDay, long predicting) {
        super(branch);
        this.dayOfWeek = dayOfWeek;
        this.hourOfDay = hourOfDay;
        this.predicting = predicting;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    public long getPredicting() {
        return predicting;
    }

    public void setPredicting(int predicting) {
        this.predicting = predicting;
    }
}
