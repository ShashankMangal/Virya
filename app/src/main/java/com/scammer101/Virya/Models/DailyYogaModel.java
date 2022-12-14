package com.scammer101.Virya.Models;

public class DailyYogaModel
{
    private int finished, inProgress, timeSpent;
    private String date;

    public DailyYogaModel() {
    }

    public DailyYogaModel(int finished, int inProgress, int timeSpent, String date) {
        this.finished = finished;
        this.inProgress = inProgress;
        this.timeSpent = timeSpent;
        this.date = date;
    }

    public int getFinished() {
        return finished;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getInProgress() {
        return inProgress;
    }

    public void setInProgress(int inProgress) {
        this.inProgress = inProgress;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
}
