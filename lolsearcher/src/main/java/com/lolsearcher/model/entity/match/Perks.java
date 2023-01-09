package com.lolsearcher.model.entity.match;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Perks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long summaryMemberId; /* Foreign Key */
    private Integer perkStatsId; /* Foreign Key */
    private short mainPerkStyle;
    private short subPerkStyle;
    private short mainPerk1;
    private short mainPerk1Var1;
    private short mainPerk1Var2;
    private short mainPerk1Var3;

    private short mainPerk2;
    private short mainPerk2Var1;
    private short mainPerk2Var2;
    private short mainPerk2Var3;

    private short mainPerk3;
    private short mainPerk3Var1;
    private short mainPerk3Var2;
    private short mainPerk3Var3;

    private short mainPerk4;
    private short mainPerk4Var1;
    private short mainPerk4Var2;
    private short mainPerk4Var3;

    private short subPerk1;
    private short subPerk1Var1;
    private short subPerk1Var2;
    private short subPerk1Var3;

    private short subPerk2;
    private short subPerk2Var1;
    private short subPerk2Var2;
    private short subPerk2Var3;

    @ManyToOne
    @JoinColumn(name = "perk_stats_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PerkStats perkStats;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "summary_member_id", referencedColumnName = "id")
    private SummaryMember summaryMember;

    public void setSummaryMember(SummaryMember summaryMember) throws IllegalAccessException {

        if(summaryMember.getPerks() != null){
            throw new IllegalAccessException("이미 연관관계 설정이 된 SummaryMember 객체입니다.");
        }
        this.summaryMember = summaryMember;
        summaryMember.setPerks(this);
    }

    public void setPerkStats(PerkStats perkStats) throws IllegalAccessException {

        if(this.perkStats != null){
            throw new IllegalAccessException("이미 PerkStats 값이 설정되었습니다.");
        }
        this.perkStats = perkStats;
    }
}
