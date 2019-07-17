package com.yeopp.community.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tbl_recommendation")
public class RecommendationEntity {

    @Id
    @GeneratedValue
    private Integer recommendationId;

    @JoinColumn(name = "board_id")
    @ManyToOne(targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;

    @Column(length = 35, nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer recommendationNm;
}
