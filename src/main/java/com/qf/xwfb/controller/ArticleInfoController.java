package com.qf.xwfb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.xwfb.pojo.ArticleInfo;
import com.qf.xwfb.pojo.UserInfo;
import com.qf.xwfb.service.ArticleInfoService;
import com.qf.xwfb.vo.ArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleInfoController {
    @Autowired
    ArticleInfoService articleInfoService;

    /**
     *根据文章id来改变文章的status(通过审核或者不通过)
     * @param articleInfo
     * @return
     */
    @RequestMapping("admin/updateArticleStatus")
    public Object updateArticleStatus(@RequestBody ArticleInfo articleInfo){
        return this.articleInfoService.updateArticleStatus(articleInfo);

    }

    /**
     * 获取所有需要审核的文章信息
     * @return
     */
    @RequestMapping("admin/getAllArticleInfo")
    public Object getAllArticleInfo(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum){
        int pageSize=2;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请的文章信息
        List<ArticleInfoVO> allArticleInfoVO = articleInfoService.getAllArticleInfo();
        //将获取的ArticleInfo信息封装到PageInfo中
        PageInfo<ArticleInfoVO> ArticleInfoPageInfo = new PageInfo<ArticleInfoVO>(allArticleInfoVO);
        return ArticleInfoPageInfo;
    };

    /**
     * 根据文章id获取详细信息
     * @param articleId
     * @return
     */
    @RequestMapping("admin/getArticleInfoById")
    public Object getArticleInfoById(@RequestParam int articleId){
        return articleInfoService.getArticleInfoById(articleId);
    }
}
