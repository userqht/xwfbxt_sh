package com.qf.xwfb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.xwfb.dto.EditorApplyDTO;
import com.qf.xwfb.pojo.ArticleInfo;
import com.qf.xwfb.pojo.UserInfo;
import com.qf.xwfb.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class EditorController {
    @Autowired
    EditorService editorService;

    /**
     * 将申请成为编辑的个人信息添加(更新)到userInfo表中
     * @param editorApplyDTO
     * @return
     */
    @RequestMapping("applyEditor")
    public Object applyEditor(@RequestBody EditorApplyDTO editorApplyDTO){
        System.out.println(editorApplyDTO);
        return editorService.applyEditor(editorApplyDTO);
    }


    /**
     * 获取所有申请成为编辑的用户信息
     * @return
     */
//    @RequestMapping("admin/getAllEditorApply")
//    public Object getAllEditorApply(){
//        return this.editorService.getAllEditorApply();
//    }


    /**
     * 根据用户id来删除没通过编辑审核的人员信息(数据库中数据不删除)
     * @param userId
     * @return
     */
    @RequestMapping("admin/deleteApply")
    public Object deleteApply(@RequestParam int userId){
        return this.editorService.deleteApply(userId);
    }


    /**
     * 将通过编辑审核的信息更新到数据库中(改变userInfo表中status来实现)
     * @param userId
     * @return
     */
    @RequestMapping("admin/addEditor")
    public Object addEditor(@RequestParam int userId){
        return this.editorService.addEditor(userId);
    }


    /**
     * 通过id来找到申请成为编辑的用户的详细信息
     * @param userId
     * @return
     */
    @RequestMapping("admin/getEditorApplyById")
    public Object getEditorApplyById(@RequestParam int userId){
        return this.editorService.getEditorApplyById(userId);
    }


    //分页显示列表
    @RequestMapping("admin/page")
    public Object showlist(@RequestParam(required = true,defaultValue = "1",value = "pageNum") int pageNum) {
        int pageSize=4;//每页显示记录数
        //初始化pageHelper对象
        PageHelper.startPage(pageNum, pageSize);
        //获取所有申请成为编辑的用户信息
        List<UserInfo> allEditorApply = editorService.getAllEditorApply();

        //将获取的userInfo信息封装到PageInfo中
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<UserInfo>(allEditorApply);
        return userInfoPageInfo;
    }

}
