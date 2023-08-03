package com.link.dao;

import com.link.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询
    //新增、修改 动态sql
    List<User> select(Map map);
    int insert(List<String> list1);

    int update(Map map);


}
