package com.yeopp.community.entity;

import com.yeopp.community.type.YesNoType;
import com.yeopp.community.vo.BoardVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_board")
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue
    private Integer boardId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String boardContent;

    @Column(nullable = false)
    private String boardWriter;

    @ColumnDefault(value = "'0'")
    private Integer views;

    @ColumnDefault(value = "'0'")
    private Integer recommended;

    @Enumerated(value = EnumType.STRING)
    @ColumnDefault(value = "'N'")
    @Column(columnDefinition = "enum('Y', 'N')")
    private YesNoType deleteAt;

    @CreationTimestamp
    private Date createDt;

    @UpdateTimestamp
    private Date updateDt;

    @OneToMany(targetEntity = CommentEntity.class, mappedBy = "boardEntity")
    private List<CommentEntity> commentEntityList;

    public BoardEntity(BoardVo vo) {
        this.title = vo.getTitle();
        this.boardContent = vo.getBoardContent();
        this.boardWriter = vo.getBoardWriter();
    }

    //TODO... 오늘 작성한 글이면 시간까지, 오늘이 아니면 날짜까지
    public boolean isToday() {
        boolean flag = false;

        Date today = new Date();
        Date createDate = createDt;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String result = format.format(today);
        String result2 = format2.format(today);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.SECOND,-1);

        try {
            Date beforeToday = format.parse(result);
            Date afterToday = format2.parse(result2);

            if(createDate.getTime() > beforeToday.getTime()
                    && createDate.getTime() < afterToday.getTime()){
                flag = true;
            }

            return flag;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
