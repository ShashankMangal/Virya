package com.scammer101.Virya.Models;

public class DailyYogaModel
{
    private int finished, inProgress, timeSpent;

    public DailyYogaModel() {
    }

    public DailyYogaModel(int finished, int inProgress, int timeSpent) {
        this.finished = finished;
        this.inProgress = inProgress;
        this.timeSpent = timeSpent;
    }

    public int getFinished() {
        return finished;
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
