package com.link.test;

import com.link.dao.UserDao;
import com.link.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //insert(userDao);
        update(userDao);
        select(userDao);
        sqlSession.commit();
    }
    public static void select(UserDao userDao) {
        Map<String, Object> map = new HashMap<>();
        map.put("u_id",3);
        map.put("nameLike","王%");
        List<User> userList = userDao.select(map);
        for (User user : userList) {
            System.out.println(user);
        }

    }
    public static void insert(UserDao userDao) {
        List<String> userList = new ArrayList<>();
        userList.add("8");
        userList.add("小刘");
        userList.add("女");
        userList.add("add8");
        System.out.println(userList);
        int num = userDao.insert(userList);
        if (num>0){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
    }

    public static void update(UserDao userDao){
        Map<String,Object> map = new HashMap<>();
        map.put("u_id",5);
        map.put("address","address5");
        int update = userDao.update(map);
        if (update>0){
            System.out.println("success");
        }else {
            System.out.println("false");
        }
    }

}
