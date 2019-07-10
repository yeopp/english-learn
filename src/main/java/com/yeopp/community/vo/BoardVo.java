package com.yeopp.community.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
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
