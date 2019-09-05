package com.zyx.ssm.service;


import com.zyx.ssm.domain.Permission;
import com.zyx.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll(int page,int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOthersPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
