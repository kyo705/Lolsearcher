package com.lolsearcher.model.riot.league;

import lombok.Data;

@Data
public class LeagueEntryDto {
    String leagueId;
    String summonerId;
    String summonerName;
    String queueType;
    String tier;
    String rank;
    int leaguePoints;
    int wins;
    int losses;
    boolean hotStreak;
    boolean veteran;
    boolean freshBlood;
    boolean inactive;
}
