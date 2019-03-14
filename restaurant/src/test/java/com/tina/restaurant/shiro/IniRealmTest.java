package com.tina.restaurant.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class IniRealmTest {

    @Test
    public void authenticationTest() {


        IniRealm iniRealm = new IniRealm("classpath:com/tina/restaurant/shiro/user.ini");

        //引入主体
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        //进行认证
        UsernamePasswordToken tina = new UsernamePasswordToken("jack", "123");
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.login(tina);
        //判断认证
        System.out.println("登陆是否成功" + subject.isAuthenticated());
        //认证权限
        //subject.checkRoles("user");
        subject.checkPermission("user:delete");


    }
}
