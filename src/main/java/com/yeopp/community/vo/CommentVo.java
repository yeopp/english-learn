package com.yeopp.community.vo;

import lombok.Data;

@Data
public class CommentVo {

    private Integer boardId;

    private String comment;

    private String userName;
}
