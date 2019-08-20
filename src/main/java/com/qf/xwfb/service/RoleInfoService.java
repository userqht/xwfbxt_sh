package com.qf.xwfb.service;

import com.qf.xwfb.dto.SysUserRoleDTO;

public interface RoleInfoService {

    //根据sys_role中间表来给用户分配角色
    public boolean addUserRole(SysUserRoleDTO sysUserRoleDTO);
}
