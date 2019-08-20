package com.qf.xwfb.service.impl;

import com.qf.xwfb.dao.ArticleInfoMapper;
import com.qf.xwfb.pojo.ArticleInfo;
import com.qf.xwfb.service.ArticleInfoService;
import com.qf.xwfb.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {
    @Autowired
    ArticleInfoMapper articleInfoMapper;

    //根据文章id来改变文章的status(通过审核或者不通过)
    public boolean updateArticleStatus(ArticleInfo articleInfo) {
        return this.articleInfoMapper.updateArticleStatus(articleInfo)>0;
    }

    //获取所有文章信息
    public List<ArticleInfoVO> getAllArticleInfo() {
        return this.articleInfoMapper.getAllArticleInfo();
    }

    //根据文章id获取详细信息
    public ArticleInfoVO getArticleInfoById(int id) {
        return this.articleInfoMapper.getArticleInfoById(id);
    }
}
