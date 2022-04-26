package com.example.wclaproject.ui.teams.items;

public class TeamModel   {
    private String team_id;
    private String team_name;
    private String team_city;
    private String team_state;
    private String team_region;
    private String team_year_est;
    private String team_email;
    private String team_stid;

    public TeamModel(String get_id, String get_name, String get_city, String get_state, String get_region, String get_year, String get_email, String get_stid) {
        this.team_id = get_id;
        this.team_name = get_name;
        this.team_city = get_city;
        this.team_state = get_state;
        this.team_region = get_region;
        this.team_year_est = get_year;
        this.team_email = get_email;
        this.team_stid = get_stid;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_city() {
        return team_city;
    }

    public void setTeam_city(String team_city) {
        this.team_city = team_city;
    }

    public String getTeam_state() {
        return team_state;
    }

    public void setTeam_state(String team_state) {
        this.team_state = team_state;
    }

    public String getTeam_region() {
        return team_region;
    }

    public void setTeam_region(String team_region) {
        this.team_region = team_region;
    }

    public String getTeam_year_est() {
        return team_year_est;
    }

    public void setTeam_year_est(String team_year_est) {
        this.team_year_est = team_year_est;
    }

    public String getTeam_email() {
        return team_email;
    }

    public void setTeam_email(String team_email) {
        this.team_email = team_email;
    }

    public String getTeam_stid() {
        return team_stid;
    }

    public void setTeam_stid(String team_stid) {
        this.team_stid = team_stid;
    }
}
