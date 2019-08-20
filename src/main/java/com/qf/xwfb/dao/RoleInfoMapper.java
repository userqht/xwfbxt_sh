package com.qf.xwfb.dao;

import com.qf.xwfb.dto.SysUserRoleDTO;

public interface RoleInfoMapper {

    //根据sys_role中间表来给用户分配角色
    public int addUserRole(SysUserRoleDTO sysUserRoleDTO);
}
