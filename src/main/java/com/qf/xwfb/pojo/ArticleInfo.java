package com.qf.xwfb.pojo;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ArticleInfo {

    Integer articleId;
    Integer userId;
    Integer typeId;
    String articleName;
    String mainTitle;
    String subTitle;
    String content;
    Integer status;
    Timestamp creatTime;
    Timestamp updateTime;

}
