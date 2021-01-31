package com.guo.springboot;

import com.guo.springboot.pojo.Dog;
import com.guo.springboot.pojo.Person;
import com.guo.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

}

@SpringBootTest
class ValueAnnotationsTests {

    @Autowired //将狗狗自动注入进来
    Dog dog;

    @Test
    public void contextLoads() {
        System.out.println(dog); //打印看下狗狗对象
    }

}

@SpringBootTest
class YamlInjectionTests {
    @Autowired
    Person person; //将person自动注入进来
    @Test
    public void contextLoads() {
        System.out.println(person); //打印person信息
    }
}

@SpringBootTest
class PropertiesInjectionTest {
    @Autowired
    User user;
    @Test
    public void contextLoads() {
        System.out.println(user);
    }
}