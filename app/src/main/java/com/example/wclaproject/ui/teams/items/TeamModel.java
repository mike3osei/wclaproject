package com.example.wclaproject.ui.teams.items;

public class TeamModel   {

    private String team_name;
    private String team_short_name;

    public TeamModel(String get_team_name, String get_team_short_name) {
        this.team_name = get_team_name;
        this.team_short_name = get_team_short_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getTeam_short_name() { return team_short_name; }

    public void setTeam_short_name(String short_name) {
        this.team_short_name = short_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

}
