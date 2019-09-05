package com.zyx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.zyx.ssm.dao.IUserDao;
import com.zyx.ssm.domain.Role;
import com.zyx.ssm.domain.UserInfo;
import com.zyx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询所有用户
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return userDao.findAll();
    }

    /**
     * 保存用户
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密处理
//        userInfo.setPassWord(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassWord()));
        userInfo.setPassWord(bCryptPasswordEncoder.encode(userInfo.getPassWord()));
        userDao.save(userInfo);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 根据userId查询其它角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findOthersRole(String userId) throws Exception {
        return userDao.findOthersRole(userId);
    }

    /**
     * 通过id给用户添加角色
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for(String roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     *
     * 登录查询
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUserName(), userInfo.getPassWord(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
