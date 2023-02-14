package com.lolsearcher.model.entity.rank;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "ranks", indexes = {@Index(columnList = "summonerId, seasonId, queueType", unique = true)})
public class Rank {

	@Id
	private Long id;
	private String summonerId;
	private int seasonId;
	private String queueType;
	private String leagueId;
	private String tier; /* GOLD, SLIVER, BRONZE ... */
	private String rank; /* I, II, III ... */
	private int leaguePoints;
	private int wins;
	private int losses;

}

