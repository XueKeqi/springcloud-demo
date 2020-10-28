package com.jk.controller;

import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import com.jk.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(SysUser user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsercode(), user.getPassword());
        try {
            // 不抛异常代表登录成功
            subject.login(upt);
            return "登录成功";
        } catch (UnknownAccountException uae) {
            return "账号不存在";
        } catch (IncorrectCredentialsException ice) {
            return "密码错误";
        } catch (AuthenticationException ae) {
            return "登录失败，网络错误";
        }
    }

    @RequestMapping("/queryTree")
    @ResponseBody
    public List<Tree> queryTree() {
        System.out.println("登录成功");
        //查询当前用户所属的权限树
        SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
        return userService.selectTreeList(user.getId());
    }

    @RequestMapping("/queryUser")
    @RequiresPermissions("user:query")
    public String queryUser() {
        return "userList";
    }










    @RequestMapping("/list")
    @ResponseBody
    public List<UserEntity> list(String userName) {
        UserEntity user = new UserEntity();
        if(StringUtil.isNotEmpty(userName)) {
            user.setUserName(userName);
        }
        return userService.list(user);
    }

}
