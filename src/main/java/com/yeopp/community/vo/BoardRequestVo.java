package com.yeopp.community.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoardRequestVo implements Serializable {

    private String boardId;

    private String title;

    private String boardContent;

    private String boardWriter;

    private String views;

    private String recommended;

    private String createDt;

    private String updateDt;
}
