package com.example.wclaproject.database.constant;

public abstract class SQLCommand
{
    public static String fetchAllTeams = "SELECT * FROM TEAM";

    // Quincy
    public static String fetchStandings = "SELECT * FROM RECORD";

    public static String fetchRegionStandings(String region){
        return "SELECT * FROM REGION_RECORD WHERE REGION=='" + region + "'";
    }

    /*
    // Mikel
    public static String fetchStandings = "SELECT * FROM LeagueStandings";

    public static String fetchRegionStandings(String region){
        return "SELECT * FROM RegionalStandings WHERE REGION=='" + region + "'";
    }
    */


    /* Stats */
    public static String fetchMostChamps = "SELECT * FROM MOST_CHAMPIONSHIPS";
    public static String fetchHighScore = "SELECT * FROM HIGH_SCORING";
    public static String fetchHomeAdvantage = "SELECT * FROM HOME_ADVANTAGE";
    public static String fetchHistoryChamps = "SELECT * FROM CHAMPIONS";
    public static String fetchPopularStadiums = "SELECT * FROM POPULAR_STADIUMS";
    public static String fetchExperiencedCoaches = "SELECT * FROM EXPERIENCED_COACHES";
    public static String fetchRosterCount = "SELECT * FROM ROSTER_COUNT";

    //public static String fetchTeamStatsTot = "SELECT * FROM TeamStatsTOT";
    //public static String fetchTeamStatsAvg = "SELECT * FROM TeamStatsAVG";

    //public static String fetchEfficientCoaches = "SELECT * FROM EFFICIENT_COACHES";
    //public static String fetchWinningCoaches = "SELECT * FROM WINNING_COACHES";

    /* Dynamic last */

    public static String fetchRoster(String team){
        return "SELECT P_LAST AS LNAME, P_FIRST AS FNAME, P_POS AS POSITION, P_NUM AS NUM FROM PLAYER, TEAM WHERE PLAYER.P_TID=TEAM.T_ID AND TEAM.T_ID=='" + team + "' ORDER BY P_LAST, P_FIRST;";
    }

    public static String fetchSchedule(String team){
        return "SELECT GAME_DATE, HOME, TEAM.T_NAME AS AWAY FROM (SELECT GAME_DATE, TEAM.T_NAME AS HOME, AWAY FROM (SELECT G_DATE AS GAME_DATE, G_HTEAM AS HOME, G_ATEAM AS AWAY FROM GAME WHERE (GAME.G_ATEAM='"+ team +"' OR GAME.G_HTEAM='"+ team +"')), TEAM WHERE TEAM.T_ID=HOME), TEAM WHERE TEAM.T_ID=AWAY ORDER BY GAME_DATE";
    }

    public static String fetchTeamStats(String team){
        return "SELECT BS_GOALS AS GOALS, BS_SHOTS AS SHOTS, BS_SAVES AS SAVES, BS_PEN_MINS AS PEN_MINS FROM BOXSCORE WHERE BS_TID='"+ team +"' AND (GOALS NOT NULL AND SHOTS NOT NULL AND SAVES NOT NULL AND PEN_MINS NOT NULL)";
    }

    public static String QUERY_3 = "";

    public static String QUERY_4 = "";

    public static String QUERY_5 = "";

    public static String QUERY_6 = "";

    public static String QUERY_7 = "";
}
