package com.tina.restaurant.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tina.restaurant.entity.Admin;
import com.tina.restaurant.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-container.xml"})
public class MainTest {

    @Autowired
    private AdminServiceImpl adminService;

    public List<Admin> listAdmin() throws IOException {

        Jedis jedis = new Jedis();
        String key = "listAdmin";

        ObjectMapper om = new ObjectMapper();

        if (jedis.exists(key)) {
            return
                    om.readValue(jedis.get(key), new TypeReference<List<Admin>>() {
                    });
        }

        List<Admin> news = adminService.selectAll();
        jedis.set(key, om.writeValueAsString(news));
        return news;

    }

    @Test
    public void show() throws IOException {
        List<Admin> admins = listAdmin();

    }

    @Test
    public void serialize() throws IOException {
        Admin admin = adminService.selectByPrimaryKey(1);

     //   System.out.println(admin);
        FileOutputStream fos = new FileOutputStream(new File("d:/news.class"));

        ObjectOutputStream stream = new ObjectOutputStream(fos);
        stream.writeObject(admin);

        stream.close();

    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        //找到文件并输入
        FileInputStream is = new FileInputStream(new File("d:/news.class"));
        //反序列化
        ObjectInputStream oi = new ObjectInputStream(is);
        Object o = oi.readObject();

        System.out.println(o);
    }

    @Test
    public void serornotserialize() throws Exception {
        Jedis jedis = new Jedis();
        List<Admin> admins = adminService.selectAll();
        ByteArrayOutputStream bro = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bro);

        oos.writeObject(admins);

        jedis.set("demo-01".getBytes(), bro.toByteArray());

        oos.close();

        ByteArrayInputStream bri = new ByteArrayInputStream(jedis.get("demo-01".getBytes()));
        ObjectInputStream ois = new ObjectInputStream(bri);
        Object o1 = ois.readObject();
        System.out.println(o1);
        ois.close();
    }
}
