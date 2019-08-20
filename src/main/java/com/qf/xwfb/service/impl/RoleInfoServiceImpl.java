package com.qf.xwfb.service.impl;

import com.qf.xwfb.dao.RoleInfoMapper;
import com.qf.xwfb.dto.SysUserRoleDTO;
import com.qf.xwfb.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    RoleInfoMapper roleInfoMapper;

    //根据sys_role中间表来给用户分配角色
    public boolean addUserRole(SysUserRoleDTO sysUserRoleDTO) {
        return this.roleInfoMapper.addUserRole(sysUserRoleDTO)>0;
    }
}
