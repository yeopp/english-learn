package com.yeopp.community.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "tbl_comment")
public class CommentEntity implements Serializable {

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

    @Setter
    @Getter
    public static class SetCommentVo{
        private String commentWriter;
        private String commentContent;
        private Date createDt;
    }

    public SetCommentVo getCommentSimple(){
        SetCommentVo setCommentVo = new SetCommentVo();
        setCommentVo.setCommentContent(commentContent);
        setCommentVo.setCommentWriter(commentWriter);
        setCommentVo.setCreateDt(createDt);
        return setCommentVo;
    }
}
