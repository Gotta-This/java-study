package com.guo.dao;

import com.guo.pojo.user;
import com.guo.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class daoTest {
    @Test
    public void selectUser() {
        //第一步：获取SqlSession对象
        SqlSession session = mybatisUtils.getSqlSession();

        //执行sql
        //方法一:
        //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
        //方法二:
        userMapper mapper = session.getMapper(userMapper.class);
        List<user> users = mapper.selectUser();

        for (user user: users){
            System.out.println(user);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void getUserById(){
        //第一步：获取SqlSession对象
        SqlSession session = mybatisUtils.getSqlSession();

        userMapper mapper = session.getMapper(userMapper.class);

        user user = mapper.getUserById(1);

        System.out.println(user);

        //关闭SqlSession
        session.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        //第一步：获取SqlSession对象
        SqlSession session = mybatisUtils.getSqlSession();

        userMapper mapper = session.getMapper(userMapper.class);

        int res = mapper.addUser(new user(8,"gpf","asdsad"));

        if(res > 0){
            System.out.println("插入成功");
        }

        //提交
        session.commit();

        //关闭SqlSession
        session.close();
    }

    @Test
    public void updateUser(){
        //第一步：获取SqlSession对象
        SqlSession session = mybatisUtils.getSqlSession();

        userMapper mapper = session.getMapper(userMapper.class);

        int res = mapper.updateUser(new user(8,"guopengfei","21312312"));

        if(res > 0){
            System.out.println("修改成功");
        }

        //提交
        session.commit();

        //关闭SqlSession
        session.close();
    }

    @Test
    public void deleteUser(){
        //第一步：获取SqlSession对象
        SqlSession session = mybatisUtils.getSqlSession();

        userMapper mapper = session.getMapper(userMapper.class);

        mapper.deleteUser(8);

        //提交
        session.commit();

        //关闭SqlSession
        session.close();
    }
}
