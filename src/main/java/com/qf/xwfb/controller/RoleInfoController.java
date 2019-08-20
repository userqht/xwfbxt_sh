package com.qf.xwfb.controller;

import com.qf.xwfb.dto.SysUserRoleDTO;
import com.qf.xwfb.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleInfoController {
    @Autowired
    RoleInfoService roleInfoService;

    /**
     * 根据sys_role中间表来给用户分配角色
     * @param sysUserRoleDTO
     * @return
     */
    @RequestMapping("addUserRole")
    public Object addUserRole(SysUserRoleDTO sysUserRoleDTO){
        return this.roleInfoService.addUserRole(sysUserRoleDTO);
    }
}
