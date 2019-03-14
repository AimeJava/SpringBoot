package com.tina.restaurant.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class ShiroTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("tina", "123456");
        simpleAccountRealm.addAccount("tom", "123456", "user");
    }

    @Test
    public void authenticationTest() {
        //创建主体
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //
        UsernamePasswordToken tina = new UsernamePasswordToken("tom", "123456");
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.login(tina);
        //判断认证
        System.out.println("登陆是否成功" + subject.isAuthenticated());
        //认证权限
        subject.checkRoles("user");


    }

}
