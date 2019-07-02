package com.yeopp.community.vo;

import com.yeopp.community.entity.BoardEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BoardVo implements Serializable {

    private Integer boardId;

    private String title;

    private String boardContent;

    private String boardWriter;

    private Integer views;

    private Integer recommended;

    @DateTimeFormat(pattern = "yy-mm-dd")
    private Date createDt;

    @DateTimeFormat(pattern = "yy-mm-dd")
    private Date updateDt;
}
