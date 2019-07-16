package com.yeopp.community.vo;

import lombok.Data;

@Data
public class BoardRequestVo {

    private String boardId;

    private String title;

    private String boardContent;

    private String boardWriter;

    private String views;

    private String recommended;

    private String createDt;

    private String updateDt;
}
