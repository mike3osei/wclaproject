package com.example.wclaproject.ui.standings.item;

public class StandingModel {

    private String name;
    private String rank;

    public StandingModel(String getName, String getRank) {
        this.name = getName;
        this.rank = getRank;
    }

    public String getName() {
        return name;
    }

    public String getRank() { return rank; }

    public void setName(String getName) {
        this.name = getName;
    }

    public void setRank(String getRank) {
        this.rank = getRank;
    }

}
