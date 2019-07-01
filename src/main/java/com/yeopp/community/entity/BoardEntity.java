package com.yeopp.community.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_board")
public class BoardEntity {

    @Id
    @GeneratedValue
    private Integer boardId;

    private String title;

    private String boardContent;

    private String boardWriter;

    private Integer views;

    private Integer recommended;

    private Date createDt;

    private Date updateDt;

    @OneToMany(targetEntity = CommentEntity.class, mappedBy = "boardEntity")
    private List<CommentEntity> commentEntityList;

}
