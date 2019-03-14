package com.tina.restaurant.shiro;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyVetoException;

public class JdbcRealmTest {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    @Before
    public void dataSource() throws PropertyVetoException {

        dataSource.setDriverClass("org.mariadb.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/shiro");
        dataSource.setUser("vip");
        dataSource.setPassword("vip");


    }

    @Test
    public void jdbcRealmTest() throws PropertyVetoException {
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
//        realm.setAuthenticationQuery("select password from users where name = ?");

        //引入主体
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(realm);
        //进行认证
        UsernamePasswordToken tina = new UsernamePasswordToken("tina", "123");
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.login(tina);
        //判断认证
        System.out.println("登陆是否成功" + subject.isAuthenticated());

    }
}