package com.yeopp.community.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tbl_views")
public class ViewsEntity {

    @Id
    @GeneratedValue
    private Integer viewsId;

    @JoinColumn(name = "board_id")
    @ManyToOne(targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;

    @Column(length = 35, nullable = false)
    private String userId;
}
