package com.zyx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.zyx.ssm.domain.Permission;
import com.zyx.ssm.domain.Role;
import com.zyx.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色管理层
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private ModelAndView mv;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "1") Integer size) throws Exception {
        List<Role> roles = roleService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(roles);
        mv.addObject(pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do?page=1&size=4";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> permissions= roleService.findOthersPermissions(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds) throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);

        return "redirect:findAll.do?page=1&size=4";
    }
}
