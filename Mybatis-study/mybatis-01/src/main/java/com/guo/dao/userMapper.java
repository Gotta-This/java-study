package com.guo.dao;

import com.guo.pojo.user;

import java.util.List;
import java.util.Map;

public interface userMapper {
    //查询全部用户
    List<user> selectUser();
    //根据id查询用户
    user getUserById(int id);
    //新增一个用户
    int addUser(user user);
    //修改用户
    int updateUser(user user);
    //删除一个用户
    void deleteUser(int id);

    //map操作
    //增
    public void addMap(Map<String,Object> map);
}

