package com.example.wclaproject.ui.standings.item;

public class StandingModel {

    private String team;
    private String wins;
    private String losses;
    private String ties;

    public StandingModel(String team, String wins, String losses, String ties) {
        this.team = team;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public String getRecord() {
        return wins + "-" + losses + "-" + ties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getTies() {
        return ties;
    }

    public void setTies(String ties) {
        this.ties = ties;
    }
}
