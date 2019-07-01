package com.yeopp.community.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_comment")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Integer commentId;

    @Column(nullable = false)
    private String commentWriter;

    @Column(nullable = false)
    private String commentContent;

    @CreationTimestamp
    private Date createDt;

    @UpdateTimestamp
    private Date updateDt;

    @JoinColumn(name = "board_id")
    @ManyToOne(targetEntity = BoardEntity.class)
    private BoardEntity boardEntity;
}
