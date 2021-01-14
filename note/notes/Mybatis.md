# Mybatis 跟着老师的笔记

环境要求：

- JDK1.8
- MySQL5.7
  - 5.7是一个很经典的版本，要么就8.0要么就5.7
- maven 3.6.1/3.6.0

回顾：

- JDBC
- Mysql
- Java基础（封装继承）
- Maven
- Junit

SSM框架：有配置文件的，最好的方式就是看官网

## 1、简介

### 1.1、什么是Mybatis

- MyBatis 是一款优秀的**持久层框架**
- MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集的过程
- MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 实体类 【Plain Old Java Objects,普通的 Java对象】映射成数据库中的记录。
- MyBatis 本是apache的一个开源项目ibatis, 2010年这个项目由apache 迁移到了google code，并且改名为MyBatis 。
- 2013年11月迁移到**Github** .
- Mybatis官方文档 : http://www.mybatis.org/mybatis-3/zh/index.html
- GitHub : https://github.com/mybatis/mybatis-3

### 1.2、持久化

数据持久化

- 持久化就是将程序的数据在持久状态和瞬时状态转化的过程
- 内存：**断电即失**
- 数据库(jdbc)，io文件持久化
- 生活：冷藏、罐头

**为什么需要持久化？**

- 有一些对象，不能让他丢掉
- 内存太贵了

> 持久化

**持久化是将程序数据在持久状态和瞬时状态间转换的机制。**

- 即把数据（如内存中的对象）保存到可永久保存的存储设备中（如磁盘）。持久化的主要应用是将内存中的对象存储在数据库中，或者存储在磁盘文件中、XML数据文件中等等。
- JDBC就是一种持久化机制。文件IO也是一种持久化机制。
- 在生活中 : 将鲜肉冷藏，吃的时候再解冻的方法也是。将水果做成罐头的方法也是。

**为什么需要持久化服务呢？那是由于内存本身的缺陷引起的**

- 内存断电后数据会丢失，但有一些对象是无论如何都不能丢失的，比如银行账号等，遗憾的是，人们还无法保证内存永不掉电。
- 内存过于昂贵，与硬盘、光盘等外存相比，内存的价格要高2~3个数量级，而且维持成本也高，至少需要一直供电吧。所以即使对象不需要永久保存，也会因为内存的容量限制不能一直呆在内存中，需要持久化来缓存到外存。

### 1.3、持久层

Dao层、Service层、Controller层....

- 完成持久化工作的代码块
- 层界限十分明显

> 持久层

**什么是持久层？**

- 完成持久化工作的代码块 .  ---->  dao层 【DAO (Data Access Object)  数据访问对象】
- 大多数情况下特别是企业级应用，数据持久化往往也就意味着将内存中的数据保存到磁盘上加以固化，而持久化的实现过程则大多通过各种**关系数据库**来完成。
- 不过这里有一个字需要特别强调，也就是所谓的“层”。对于应用系统而言，数据持久功能大多是必不可少的组成部分。也就是说，我们的系统中，已经天然的具备了“持久层”概念？也许是，但也许实际情况并非如此。之所以要独立出一个“持久层”的概念,而不是“持久模块”，“持久单元”，也就意味着，我们的系统架构中，应该有一个相对独立的逻辑层面，专注于数据持久化逻辑的实现.
- 与系统其他部分相对而言，这个层面应该具有一个较为清晰和严格的逻辑边界。【说白了就是用来操作数据库存在的！】

### 1.4、为什么需要Mybatis？

- 帮助程序猿将数据存入到数据库中

- 方便
- 传统的JDBC代码太复杂了。简化、框架。自动化
- 不用Mybatis也可以。那为什么用：更容易上手。
- **技术没有高低之分**

> 为什么需要Mybatis

- Mybatis就是帮助程序猿将数据存入数据库中 , 和从数据库中取数据 .

- 传统的jdbc操作 , 有很多重复代码块 .比如 : 数据取出时的封装 , 数据库的建立连接等等... , 通过框架可以减少重复代码,提高开发效率 .

- MyBatis 是一个半自动化的**ORM框架 (Object Relationship Mapping) -->对象关系映射**

- 所有的事情，不用Mybatis依旧可以做到，只是用了它，所有实现会更加简单！**技术没有高低之分，只有使用这个技术的人有高低之别**

- MyBatis的优点

- - 简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个sql映射文件就可以了，易于学习，易于使用，通过文档和源代码，可以比较完全的掌握它的设计思路和实现。
  - 灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。sql写在xml里，便于统一管理和优化。通过sql语句可以满足操作数据库的所有需求。
  - 解除sql与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql和代码的分离，提高了可维护性。
  - 提供xml标签，支持编写动态sql。
  - .......

- 最重要的一点，使用的人多！公司需要！



## 2、第一个MyBatis程序

**思路流程：搭建环境-->导入Mybatis--->编写代码--->测试**

### 2.1、搭建环境

> 代码演示

#### 2.1.1、搭建实验数据库

```sql
CREATE DATABASE mybatis;

USE mybatis;

DROP TABLE IF EXISTS user;

CREATE TABLE USER(
id INT(20) NOT NULL,
name VARCHAR(30) DEFAULT NULL,
pwd VARCHAR(30) DEFAULT NULL,
PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT charset = UTF8;

insert  into `user`(`id`,`name`,`pwd`) values (1,'狂神','123456'),(2,'张三','abcdef'),(3,'李四','987654');
```

### 2.1.2、新建项目(maven)

1. 新建一个普通的maven项目
2. 删除src目录(把项目作为一个父项目)
3. 导入maven依赖
4. 导入MyBatis相关 jar 包

   > Maven仓库：https://mvnrepository.com/
   >
   > Maven搜索：https://search.maven.org/

    ```xml
    <!--    mysql驱动    -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <!--    Mybatis    -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <!--    Junit    -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    ```

#### 2.1.3、创建一个模块（New Module）

这样做等于说是建立了一个子项目，而这个子项目拥有父项目所拥有的所有依赖

- name：mybatis-01
- next-next-finish

#### 2.1.3.1、编写MyBatis核心配置文件

- 查看帮助文档

  官方文档说要求这个名字要叫mybatis-config.xml，这个名字可以随意取，但是我们惯性就叫它为mybatis-config.xml

  在src/main/resource中建立一个mybatis-config.xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

**下面是这个XML的解释**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
       PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- configuration/配置 -->
<configuration>
   <!-- environments/环境 里面可以有很多个environment default指向你当前使用的环境 -->
   <environments default="development">
       <!-- 每一个environment都使用id作为唯一标识符 -->
       <environment id="development">
           <!-- transactionManager/事务管理 这里说明的是这个environment所使用的事务管理方式 这里是JDBC -->
           <transactionManager type="JDBC"/>
           <!-- dataSource/数据源 顾名思义就是所连接的数据库 每一个environment都有一个数据源 -->
           <dataSource type="POOLED">
               <!-- driver/驱动 所连接的sql使用的驱动 -->
               <property name="driver" value="com.mysql.jdbc.Driver"/>
               <!-- url/链接 &amp;是转义符号，这里不能直接使用& 后面指的是
					useSSL/使用安全连接
					useUnicode/使用eUnicode编码
					characterEncoding/设置编码格式
					还有其他的配置可在官网文档上看见
				-->
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
       
       <environment id="test">
           <transactionManager type="JDBC"/>
           <dataSource type="POOLED">
               <property name="driver" value="com.mysql.jdbc.Driver"/>
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
       
   </environments>
    
   <mappers>
       <mapper resource="com/kuang/dao/userMapper.xml"/>
   </mappers>
</configuration>
```

#### 2.1.3.2、编写MyBatis工具类

- 查看帮助文档

```java
package com.guo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class mybatisUtils {
    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis的第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    //获取SqlSession连接
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
```

#### 2.1.3.3、创建实体类

- 创建pojo包
- 把数据库中的字段写出来
- 构造,有参,无参
- set/get
- toString()

```java
package com.guo.pojo;

public class user {
    
    //实体类
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

    //构造,有参,无参
    //set/get
    //toString()

    public user() {
    }

    public user(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
```

#### 2.1.3.4、编写Mapper接口类

以后的dao都叫Mapper

```java
package com.guo.dao;

import com.guo.pojo.user;

import java.util.List;

public interface userMapper {
    List<user> selectUser();
}
```

#### 2.1.3.5、编写Mapper.xml配置文件

- **namespace 十分重要，不能写错！**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 绑定一个对应的dao/Mapper接口 -->
<mapper namespace="com.guo.dao.userMapper">
    <select id="selectUser" resultType="com.guo.pojo.user">
  select * from mybatis.user
 </select>
</mapper>
```

#### 2.1.3.6、编写测试类

- Junit 包测试

```java
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
}
```

#### 2.1.4、运行测试，成功的查询出来的我们的数据，ok！

## 3、问题说明

> 问题说明

**可能出现问题：**

1. 配置文件没有注册
2. 绑定接口错误
3. 方法名不对
4. 返回类型不对
5. Maven导出资源问题

### 3.1、Maven静态资源过滤问题

Maven由于他的约定大于配置，我们之后可能会遇到我们写的配置文件，无法被导出或者生效的问题，解决方案：

把以下代码放到Maven的pom.xml里面，为了防止子项目不生效，就把父项目子项目都放一遍

build是在project里的

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```

### 3.2、卡在downloading maven plugins

原因是Maven自带镜像加载比较缓慢，可以换成阿里镜像

```xml
<!-- 阿里云公共仓库
  <mirror>
    <id>aliyunmaven</id>
    <mirrorOf>*</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
  </mirror> -->

<!-- 阿里云仓库 -->
<mirror>
    <id>alimaven</id>
    <mirrorOf>central</mirrorOf>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
</mirror>

<!-- 中央仓库1 -->
<mirror>
    <id>repo1</id>
    <mirrorOf>central</mirrorOf>
    <name>Human Readable Name for this Mirror.</name>
    <url>http://repo1.maven.org/maven2/</url>
</mirror>

<!-- 中央仓库2 -->
<mirror>
    <id>repo2</id>
    <mirrorOf>central</mirrorOf>
    <name>Human Readable Name for this Mirror.</name>
    <url>http://repo2.maven.org/maven2/</url>
</mirror>
```

**注意更改仓库地址后要重新下载依赖和刷新Maven** 

* 在maven的Dependencies上右键，Download Sources
* 窗口的右上角有刷新Maven按钮

### 3.3、报错

#### 3.3.1、org.apache.ibatis.binding.BindingException

**这个错误一定要记住，以后经常会遇到的**

**org.apache.ibatis.binding.BindingException: Type interface com.guo.dao.userMapper is not known to the MapperRegistry.**

简单的翻译：com.guo.dao.userMapper类型的接口对于MapperRegistry来说是未知的

**MapperRegistry是什么？**

- 是因为我们的Mapper.xml没有在Mybatis-Config.xml文件中注册
- 每一个Mapper.xml都需要在Mybatis核心配置文件中注册

#### 3.3.2、org.apache.ibatis.exceptions.PersistenceException

Error building SqlSession.

The error may exist in com.guo.mapper.userMapper.xml

Cause: org.apache.ibatis.builder.BuilderException: Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource com.guo.mapper.userMapper.xml

这个问题原因是，在build之后的输出文件夹里没有这个文件，这个是Maven静态资源过滤的问题

当把userMapper.xml直接复制到输出文件夹里的时候，再跑一遍就会成功

但每次不可能都复制一下

解决方案见：Maven静态资源过滤问题

#### 3.3.3、Could not find resource com.xxx.dao.userMapper.xml

在mybatis-config.xml 中定义了userMapper.xml的路径：

```xml
<mappers>
    <mapper resource="com.guo.dao.userMapper.xml"/>
</mappers>
```

映射配置文件有这样一项注意事项：映射配置文件位置要和映射器位置一样，如：映射器在com.mycode.dao里，那么配置文件就应该在resources的com/mycode/dao目录下。上面的案例结构上映射配置文件位置并没有错，只是在创建resources的`com/mycode/dao`目录后，idea显示的是`com.mycode.dao`。

所以正确的userMapper.xml配置为：

```xml
<mappers>
    <mapper resource="com/guo/dao/userMapper.xml"/>
</mappers>
```

## 4、CURD

### 4.1、userMapper.xml --> namespace

namespace中的包名要和Dao/Mapper接口的包名一致

### 4.2、select

选择，查询语句；

- id：就是对应的namespace中的方法名；
- resultType : Sql语句执行的返回值；
- parameterType : 参数类型；

- 1. 编写接口

     ```java
     public interface UserMapper {
         //查询所有用户
         public List<User> getUserList();
         //插入用户
         public void addUser(User user);
     }
     123456
     ```

  2. 编写对应的mapper中的sql语句

     ```xml
     <insert id="addUser" parameterType="com.kuang.pojo.User">
         insert into user (id,name,password) values (#{id}, #{name}, #{password})
     </insert>
     123
     ```

  3. 测试

     ```java
     @Test
     public void test2() {
         SqlSession sqlSession = MybatisUtils.getSqlSession();
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         User user  = new User(3,"黑子","666");
         mapper.addUser(user);
         //增删改一定要提交事务
         sqlSession.commit();
     
         //关闭sqlSession
         sqlSession.close();
     }
     123456789101112
     ```

     **注意：增删改查一定要提交事务：**

     ```java
     sqlSession.commit();
     1
     ```

### 4.3、 Insert

### 4.4、update

### 4.5、Delete

### 4.6、万能Map

假设，我们的实体类，或者数据库中的表，字段或者参数过多，我们应该考虑使用Map!

1. UserMapper接口

```java
//用万能Map插入用户
public void addUser2(Map<String,Object> map);
12
```

1. UserMapper.xml

```xml
<!--对象中的属性可以直接取出来 传递map的key-->
<insert id="addUser2" parameterType="map">
    insert into user (id,name,password) values (#{userid},#{username},#{userpassword})
</insert>
1234
```

1. 测试

```java
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("username","王虎");
        map.put("userpassword",789);
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
1234567891011121314
```

> Map传递参数，直接在sql中取出key即可！ 【parameter=“map”】
>
> 对象传递参数，直接在sql中取出对象的属性即可！ 【parameter=“Object”】
>
> 只有一个基本类型参数的情况下，可以直接在sql中取到
>
> 多个参数用Map , **或者注解！**

### 4.7、模糊查询

模糊查询这么写？

1. Java代码执行的时候，传递通配符% %

   ```java
   List<User> userList = mapper.getUserLike("%李%");
   1
   ```

2. 在sql拼接中使用通配符

   ```xml
   select * from user where name like "%"#{value}"%"
   ```

## 5、配置解析

### 5.1、核心配置文件

- mybatis-config.xml

- Mybatis的配置文件包含了会深深影响MyBatis行为的设置和属性信息。

  ```xml
  configuration（配置）
      properties（属性）
      settings（设置）
      typeAliases（类型别名）
      typeHandlers（类型处理器）
      objectFactory（对象工厂）
      plugins（插件）
      environments（环境配置）
      	environment（环境变量）
      		transactionManager（事务管理器）
      		dataSource（数据源）
      databaseIdProvider（数据库厂商标识）
      mappers（映射器）
  12345678910111213
  ```

### 5.2、 环境配置 environments

MyBatis 可以配置成适应多种环境

**不过要记住：尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境**

学会使用配置多套运行环境！

MyBatis默认的事务管理器就是JDBC ，连接池：POOLED

### 5.3、属性 properties

我们可以通过properties属性来实现引用配置文件

这些属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。【db.poperties】

1. 编写一个配置文件

   db.properties

   ```properties
   driver=com.mysql.cj.jdbc.Driver
   url=jdbc:mysql://localhost:3306/mybatis?userSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
   username=root
   password=root
   1234
   ```

2. 在核心配置文件中引入

   ```xml
   <!--引用外部配置文件-->
   <properties resource="db.properties">
       <property name="username" value="root"/>
       <property name="password" value="root"/>
   </properties>
   12345
   ```

   - 可以直接引入外部文件
   - 可以在其中增加一些属性配置
   - 如果两个文件有同一个字段，优先使用外部配置文件的

### 5.4、类型别名 typeAliases

- 类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置.

- 意在降低冗余的全限定类名书写。

  ```xml
  <!--可以给实体类起别名-->
  <typeAliases>
      <typeAlias type="com.kuang.pojo.User" alias="User"/>
  </typeAliases>
  1234
  ```

  也可以指定一个包，每一个在包 `domain.blog` 中的 Java Bean，在没有注解的情况下，会使用 Bean 的首字母小写的非限定类名来作为它的别名。 比如 `domain.blog.Author` 的别名为 `author`,；若有注解，则别名为其注解值。见下面的例子：

  ```xml
  <typeAliases>
      <package name="com.kuang.pojo"/>
  </typeAliases>
  123
  ```

  > 在实体类比较少的时候，使用第一种方式。
  >
  > 如果实体类十分多，建议用第二种扫描包的方式。
  >
  > 第一种可以DIY别名，第二种不行，如果非要改，需要在实体上增加注解。

  ```java
  @Alias("author")
  public class Author {
      ...
  }
  ```

### 5.5、设置 Settings

这是 MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020062316474822.png)

### 5.6、其他配置

- [typeHandlers（类型处理器）](https://mybatis.org/mybatis-3/zh/configuration.html#typeHandlers)
- [objectFactory（对象工厂）](https://mybatis.org/mybatis-3/zh/configuration.html#objectFactory)
- plugins 插件
  - mybatis-generator-core
  - mybatis-plus
  - 通用mapper

### 5.7、映射器 mappers

MapperRegistry：注册绑定我们的Mapper文件；

方式一：【推荐使用】

```xml
<!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
<mappers>
    <mapper resource="com/kuang/dao/UserMapper.xml"/>
</mappers>
1234
```

方式二：使用class文件绑定注册

```xml
<!--每一个Mapper.xml都需要在MyBatis核心配置文件中注册-->
<mappers>
    <mapper class="com.kuang.dao.UserMapper"/>
</mappers>
1234
```

**注意点：**

- 接口和他的Mapper配置文件必须同名
- 接口和他的Mapper配置文件必须在同一个包下

方式三：使用包扫描进行注入

```xml
<mappers>
    <package name="com.kuang.dao"/>
</mappers>
```

### 5.8、作用域和生命周期

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164809990.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

声明周期和作用域是至关重要的，因为错误的使用会导致非常严重的**并发问题**。

**SqlSessionFactoryBuilder:**

- 一旦创建了SqlSessionFactory，就不再需要它了
- 局部变量

**SqlSessionFactory:**

- 说白了就可以想象为：数据库连接池
- SqlSessionFactory一旦被创建就应该在应用的运行期间一直存在，**没有任何理由丢弃它或重新创建一个实例。**
- 因此SqlSessionFactory的最佳作用域是应用作用域（ApplocationContext）。
- 最简单的就是使用**单例模式**或静态单例模式。

**SqlSession：**

- 连接到连接池的一个请求
- SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。
- 用完之后需要赶紧关闭，否则资源被占用！

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164833872.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

## 6、解决属性名和字段名不一致的问题

### 6.1、问题

数据库中的字段

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164845962.png)

新建一个项目，拷贝之前的，测试实体类字段不一致的情况

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164853569.png)

测试出现问题
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164901861.png)

```xml
// select * from user where id = #{id}
// 类型处理器
// select id,name,pwd from user where id = #{id}
123
```

解决方法：

- 起别名

```xml
<select id="getUserById" resultType="com.kuang.pojo.User">
    select id,name,pwd as password from USER where id = #{id}
</select>
```

### 6.2、resultMap

结果集映射

> id name pwd
>
> id name password

```xml
<!--结果集映射-->
<resultMap id="UserMap" type="User">
    <!--column数据库中的字段，property实体类中的属性-->
    <result column="id" property="id"></result>
    <result column="name" property="name"></result>
    <result column="pwd" property="password"></result>
</resultMap>

<select id="getUserList" resultMap="UserMap">
    select * from USER
</select>
1234567891011
```

- `resultMap` 元素是 MyBatis 中最重要最强大的元素。
- ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。
- `ResultMap` 的优秀之处——你完全可以不用显式地配置它们。
- 如果这个世界总是这么简单就好了。

## 7、日志

### 7.1、日志工厂

如果一个数据库操作，出现了异常，我们需要排错，日志就是最好的助手！

曾经：sout、debug

现在：日志工厂

![img](https://img-blog.csdnimg.cn/20200623164920502.png)

- SLF4J
- LOG4J 【掌握】
- LOG4J2
- JDK_LOGGING
- COMMONS_LOGGING
- STDOUT_LOGGING 【掌握】
- NO_LOGGING

在MyBatis中具体使用哪一个日志实现，在设置中设定

**STDOUT_LOGGING**

```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
123
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020062316493391.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

### 7.2、Log4j

什么是Log4j？

- Log4j是[Apache](https://baike.baidu.com/item/Apache/8512995)的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是[控制台](https://baike.baidu.com/item/控制台/2438626)、文件、[GUI](https://baike.baidu.com/item/GUI)组件；
- 我们也可以控制每一条日志的输出格式；
- 通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程；
- 最令人感兴趣的就是，这些可以通过一个[配置文件](https://baike.baidu.com/item/配置文件/286550)来灵活地进行配置，而不需要修改应用的代码。

1. 先导入log4j的包

   ```xml
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   12345
   ```

2. log4j.properties

   ```xml
   #将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
   log4j.rootLogger=DEBUG,console,file
   
   #控制台输出的相关设置
   log4j.appender.console = org.apache.log4j.ConsoleAppender
   log4j.appender.console.Target = System.out
   log4j.appender.console.Threshold=DEBUG
   log4j.appender.console.layout = org.apache.log4j.PatternLayout
   log4j.appender.console.layout.ConversionPattern=[%c]-%m%n
   #文件输出的相关设置
   log4j.appender.file = org.apache.log4j.RollingFileAppender
   log4j.appender.file.File=./log/rzp.log
   log4j.appender.file.MaxFileSize=10mb
   log4j.appender.file.Threshold=DEBUG
   log4j.appender.file.layout=org.apache.log4j.PatternLayout
   log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n
   #日志输出级别
   log4j.logger.org.mybatis=DEBUG
   log4j.logger.java.sql=DEBUG
   log4j.logger.java.sql.Statement=DEBUG
   log4j.logger.java.sql.ResultSet=DEBUG
   log4j.logger.java.sq1.PreparedStatement=DEBUG
   12345678910111213141516171819202122
   ```

3. 配置settings为log4j实现

4. 测试运行

**Log4j简单使用**

1. 在要使用Log4j的类中，导入包 import org.apache.log4j.Logger;

2. 日志对象，参数为当前类的class对象

   ```java
   Logger logger = Logger.getLogger(UserDaoTest.class);
   1
   ```

3. 日志级别

   ```java
   logger.info("info: 测试log4j");
   logger.debug("debug: 测试log4j");
   logger.error("error:测试log4j");
   123
   ```

   1. info
   2. debug
   3. error

## 8、分页

**思考：为什么分页？**

- 减少数据的处理量

### 8.1、**使用Limit分页**

```sql
SELECT * from user limit startIndex,pageSize 
1
```

**使用MyBatis实现分页，核心SQL**

1. 接口

   ```java
   //分页
   List<User> getUserByLimit(Map<String,Integer> map);
   12
   ```

2. Mapper.xml

   ```xml
   <!--分页查询-->
   <select id="getUserByLimit" parameterType="map" resultMap="UserMap">
       select * from user limit #{startIndex},#{pageSize}
   </select>
   1234
   ```

3. 测试

   ```java
       @Test
       public void getUserByLimit(){
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           HashMap<String, Integer> map = new HashMap<String, Integer>();
           map.put("startIndex",1);
           map.put("pageSize",2);
           List<User> list = mapper.getUserByLimit(map);
           for (User user : list) {
               System.out.println(user);
           }
       }
   123456789101112
   ```

### 8.2、RowBounds分页

不再使用SQL实现分页

1. 接口

   ```xml
   //分页2
   List<User> getUserByRowBounds();
   12
   ```

2. mapper.xml

   ```xml
   <!--分页查询2-->
   <select id="getUserByRowBounds">
       select * from user limit #{startIndex},#{pageSize}
   </select>
   1234
   ```

3. 测试

   ```java
       public void getUserByRowBounds(){
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           //RowBounds实现
           RowBounds rowBounds = new RowBounds(1, 2);
           //通过Java代码层面实现分页
           List<User> userList = sqlSession.selectList("com.kaung.dao.UserMapper.getUserByRowBounds", null, rowBounds);
           for (User user : userList) {
               System.out.println(user);
           }
           sqlSession.close();
       }
   1234567891011
   ```

### 8.3、分页插件

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623164958936.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

## 9、使用注解开发

### 9.1、面向接口开发

**三个面向区别**

- 面向对象是指，我们考虑问题时，以对象为单位，考虑它的属性和方法；
- 面向过程是指，我们考虑问题时，以一个具体的流程（事务过程）为单位，考虑它的实现；
- 接口设计与非接口设计是针对复用技术而言的，与面向对象（过程）不是一个问题，更多的体现就是对系统整体的架构；

### 9.2、使用注解开发

1. 注解在接口上实现

   ```java
   @Select("select * from user")
   List<User> getUsers();
   12
   ```

2. 需要在核心配置文件中绑定接口

   ```xml
   <mappers>
       <mapper class="com.kuang.dao.UserMapper"/>
   </mappers>
   123
   ```

3. 测试

本质：反射机制实现

底层：动态代理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165014965.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

**MyBatis详细执行流程**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165030775.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70#pic_center)

### 9.3、注解CURD

```java
//方法存在多个参数，所有的参数前面必须加上@Param("id")注解
@Delete("delete from user where id = ${uid}")
int deleteUser(@Param("uid") int id);
123
```

**关于@Param( )注解**

- 基本类型的参数或者String类型，需要加上
- 引用类型不需要加
- 如果只有一个基本类型的话，可以忽略，但是建议大家都加上
- 我们在SQL中引用的就是我们这里的@Param()中设定的属性名

**#{} 和 ${}**

## 10、Lombok

Lombok项目是一个Java库，它会自动插入编辑器和构建工具中，Lombok提供了一组有用的注释，用来消除Java类中的大量样板代码。仅五个字符(@Data)就可以替换数百行代码从而产生干净，简洁且易于维护的Java类。

使用步骤：

1. 在IDEA中安装Lombok插件

2. 在项目中导入lombok的jar包

   ```xml
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.10</version>
       <scope>provided</scope>
   </dependency>
   123456
   ```

3. 在程序上加注解

```java
@Getter and @Setter
@FieldNameConstants
@ToString
@EqualsAndHashCode
@AllArgsConstructor, @RequiredArgsConstructor and @NoArgsConstructor
@Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j, @CommonsLog, @JBossLog, @Flogger, @CustomLog
@Data
@Builder
@SuperBuilder
@Singular
@Delegate
@Value
@Accessors
@Wither
@With
@SneakyThrows
@val
1234567891011121314151617
```

说明：

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
12345678
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165052167.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

## 11、多对一处理

> 多个学生一个老师；

```sql
alter table student ADD CONSTRAINT fk_tid foreign key (tid) references teacher(id)
1
```

### **11.1、测试环境搭建**

1. 导入lombok
2. 新建实体类Teacher,Student
3. 建立Mapper接口
4. 建立Mapper.xml文件
5. 在核心配置文件中绑定注册我们的Mapper接口或者文件 【方式很多，随心选】
6. 测试查询是否能够成功

### 11.2、按照查询嵌套处理

```xml
<!--
     思路：
        1. 查询所有的学生信息
        2. 根据查询出来的学生的tid寻找特定的老师 (子查询)
    -->
<select id="getStudent" resultMap="StudentTeacher">
    select * from student
</select>
<resultMap id="StudentTeacher" type="student">
    <result property="id" column="id"/>
    <result property="name" column="name"/>
    <!--复杂的属性，我们需要单独出来 对象：association 集合：collection-->
    <collection property="teacher" column="tid" javaType="teacher" select="getTeacher"/>
</resultMap>
<select id="getTeacher" resultType="teacher">
    select * from teacher where id = #{id}
</select>
1234567891011121314151617
```

### 11.3、按照结果嵌套处理

```xml
    <!--按照结果进行查询-->
    <select id="getStudent2" resultMap="StudentTeacher2">
        select s.id sid , s.name sname, t.name tname
        from student s,teacher t
        where s.tid=t.id
    </select>
    <!--结果封装，将查询出来的列封装到对象属性中-->
    <resultMap id="StudentTeacher2" type="student">
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <association property="teacher" javaType="teacher">
            <result property="name" column="tname"></result>
        </association>
    </resultMap>
1234567891011121314
```

回顾Mysql多对一查询方式:

- 子查询 （按照查询嵌套）
- 联表查询 （按照结果嵌套）

## 12、一对多处理

> 一个老师多个学生；
>
> 对于老师而言，就是一对多的关系；

### 12.1、环境搭建

**实体类**

```java
@Data
public class Student {
    private int id;
    private String name;
    private int tid;
}
123456
@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师拥有多个学生
    private List<Student> students;
}
12345678
```

### 12.2、**按照结果嵌套嵌套处理**

```xml
<!--按结果嵌套查询-->
<select id="getTeacher" resultMap="StudentTeacher">
    SELECT s.id sid, s.name sname,t.name tname,t.id tid FROM student s, teacher t
    WHERE s.tid = t.id AND tid = #{tid}
</select>
<resultMap id="StudentTeacher" type="Teacher">
    <result property="id" column="tid"/>
    <result property="name" column="tname"/>
    <!--复杂的属性，我们需要单独处理 对象：association 集合：collection
    javaType=""指定属性的类型！
    集合中的泛型信息，我们使用ofType获取
    -->
    <collection property="students" ofType="Student">
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <result property="tid" column="tid"/>
    </collection>
</resultMap>
123456789101112131415161718
```

### 小结

1. 关联 - association 【多对一】
2. 集合 - collection 【一对多】
3. javaType & ofType
   1. JavaType用来指定实体类中的类型
   2. ofType用来指定映射到List或者集合中的pojo类型，泛型中的约束类型

 **注意点：**

- 保证SQL的可读性，尽量保证通俗易懂
- 注意一对多和多对一，属性名和字段的问题
- 如果问题不好排查错误，可以使用日志，建议使用Log4j

面试高频

- Mysql引擎
- InnoDB底层原理
- 索引
- 索引优化

## 13、动态SQL

**什么是动态SQL：动态SQL就是根据不同的条件生成不同的SQL语句**

**所谓的动态SQL，本质上还是SQL语句，只是我们可以在SQL层面，去执行一个逻辑代码**

------

> 动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

### 搭建环境

```sql
CREATE TABLE `mybatis`.`blog`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `title` varchar(30) NOT NULL COMMENT '博客标题',
  `author` varchar(30) NOT NULL COMMENT '博客作者',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `views` int(30) NOT NULL COMMENT '浏览量',
  PRIMARY KEY (`id`)
)
12345678
```

创建一个基础工程

1. 导包

2. 编写配置文件

3. 编写实体类

   ```java
   @Data
   public class Blog {
       private int id;
       private String title;
       private String author;
   
       private Date createTime;// 属性名和字段名不一致
       private int views;
   }
   123456789
   ```

4. 编写实体类对应Mapper接口和Mapper.xml文件

### IF

```xml
<select id="queryBlogIF" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title!=null">
            and title = #{title}
        </if>
        <if test="author!=null">
            and author = #{author}
        </if>
    </where>
</select>
1234567891011
```

### choose (when, otherwise)

### trim、where、set

### SQL片段

有的时候，我们可能会将一些功能的部分抽取出来，方便服用！

1. 使用SQL标签抽取公共部分可

   ```xml
   <sql id="if-title-author">
       <if test="title!=null">
           title = #{title}
       </if>
       <if test="author!=null">
           and author = #{author}
       </if>
   </sql>
   12345678
   ```

2. 在需要使用的地方使用Include标签引用即可

   ```xml
   <select id="queryBlogIF" parameterType="map" resultType="blog">
       select * from blog
       <where>
           <include refid="if-title-author"></include>
       </where>
   </select>
   123456
   ```

注意事项：

- 最好基于单标来定义SQL片段
- 不要存在where标签

**动态SQL就是在拼接SQL语句，我们只要保证SQL的正确性，按照SQL的格式，去排列组合就可以了**

建议：

- 先在Mysql中写出完整的SQL，再对应的去修改成我们的动态SQL实现通用即可

## 14、缓存

### 14.1、简介

> 查询 ： 连接数据库，耗资源
>
>  一次查询的结果，给他暂存一个可以直接取到的地方 --> 内存：缓存
>
> 我们再次查询的相同数据的时候，直接走缓存，不走数据库了

1. 什么是缓存[Cache]？
   - 存在内存中的临时数据
   - 将用户经常查询的数据放在缓存（内存）中，用户去查询数据就不用从磁盘上（关系型数据库文件）查询，从缓存中查询，从而提高查询效率，解决了高并发系统的性能问题
2. 为什么使用缓存？
   - 减少和数据库的交互次数，减少系统开销，提高系统效率
3. 什么样的数据可以使用缓存？
   - 经常查询并且不经常改变的数据 【可以使用缓存】

### 14.2、MyBatis缓存

- MyBatis包含一个非常强大的查询缓存特性，它可以非常方便的定制和配置缓存，缓存可以极大的提高查询效率。

- MyBatis系统中默认定义了两级缓存：

  一级缓存

  和

  二级缓存

  - 默认情况下，只有一级缓存开启（SqlSession级别的缓存，也称为本地缓存）
  - 二级缓存需要手动开启和配置，他是基于namespace级别的缓存。
  - 为了提高可扩展性，MyBatis定义了缓存接口Cache。我们可以通过实现Cache接口来定义二级缓存。

### 14.3、一级缓存

- 一级缓存也叫本地缓存：SqlSession
  - 与数据库同一次会话期间查询到的数据会放在本地缓存中
  - 以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库

测试步骤：

1. 开启日志

2. 测试在一个Session中查询两次记录

   ```java
       @Test
       public void test1() {
           SqlSession sqlSession = MybatisUtils.getSqlSession();
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           User user = mapper.getUserById(1);
           System.out.println(user);
   
           System.out.println("=====================================");
   
           User user2 =  mapper.getUserById(1);
           System.out.println(user2 == user);
       }
   123456789101112
   ```

3. 查看日志输出

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165129955.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70)

**缓存失效的情况：**

1. 查询不同的东西

2. 增删改操作，可能会改变原来的数据，所以必定会刷新缓存

3. 查询不同的Mapper.xml

4. 手动清理缓存

   ```java
   sqlSession.clearCache();
   1
   ```

### 14.4、二级缓存

- 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存
- 基于namespace级别的缓存，一个名称空间，对应一个二级缓存
- 工作机制
  - 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中
  - 如果会话关闭了，这个会员对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中
  - 新的会话查询信息，就可以从二级缓存中获取内容
  - 不同的mapper查询出的数据会放在自己对应的缓存（map）中

一级缓存开启（SqlSession级别的缓存，也称为本地缓存）

- 二级缓存需要手动开启和配置，他是基于namespace级别的缓存。
- 为了提高可扩展性，MyBatis定义了缓存接口Cache。我们可以通过实现Cache接口来定义二级缓存。

步骤：

1. 开启全局缓存

   ```xml
   <!--显示的开启全局缓存-->
   <setting name="cacheEnabled" value="true"/>
   12
   ```

2. 在Mapper.xml中使用缓存

   ```xml
   <!--在当前Mapper.xml中使用二级缓存-->
   <cache
          eviction="FIFO"
          flushInterval="60000"
          size="512"
          readOnly="true"/>
   123456
   ```

3. 测试

   1. 问题：我们需要将实体类序列化，否则就会报错

**小结：**

- 只要开启了二级缓存，在同一个Mapper下就有效
- 所有的数据都会放在一级缓存中
- 只有当前会话提交，或者关闭的时候，才会提交到二级缓存中

### 14.5、缓存原理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200623165404113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0RERERlbmdf,size_16,color_FFFFFF,t_70#pic_center)

**注意：**

- 只有查询才有缓存，根据数据是否需要缓存（修改是否频繁选择是否开启）useCache=“true”

  ```xml
      <select id="getUserById" resultType="user" useCache="true">
          select * from user where id = #{id}
      </select>
  123
  ```

### 14.6、自定义缓存-ehcache

> Ehcache是一种广泛使用的开源Java分布式缓存。主要面向通用缓存

1. 导包

   ```xml
   <dependency>
       <groupId>org.mybatis.caches</groupId>
       <artifactId>mybatis-ehcache</artifactId>
       <version>1.2.1</version>
   </dependency>
   12345
   ```

2. 在mapper中指定使用我们的ehcache缓存实现

   ```xml
   <cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
   ```



# Mybatis自己的笔记

## 1、第一个Mybatis程序

### 1.1、创建项目---引入依赖

1. 新建一个普通的maven项目

2. 删除src目录(把项目作为一个父项目)

3. 导入maven依赖

4. 导入MyBatis相关 jar 包

   > Maven仓库：https://mvnrepository.com/
   >
   > Maven搜索：https://search.maven.org/

5. 创建一个模块（New Module）

   这样做等于说是建立了一个子项目，而这个子项目拥有父项目所拥有的所有依赖

   - name：mybatis-01
   - next-next-finish

```xml
 <!--    mysql驱动    -->
 <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>5.1.47</version>
 </dependency>
 <!--    Mybatis    -->
 <dependency>
     <groupId>org.mybatis</groupId>
     <artifactId>mybatis</artifactId>
     <version>3.5.2</version>
 </dependency>
 <!--    Junit    -->
 <dependency>
     <groupId>junit</groupId>
     <artifactId>junit</artifactId>
     <version>4.12</version>
     <scope>test</scope>
 </dependency>
```

### 1.2、编写MyBatis核心配置文件

官方文档说要求这个名字要叫mybatis-config.xml，这个名字可以随意取，但是我们惯性就叫它为mybatis-config.xml

在src/main/resource中建立一个mybatis-config.xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

**下面是这个XML的解释**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
       PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- configuration/配置 -->
<configuration>
   <!-- environments/环境 里面可以有很多个environment default指向你当前使用的环境 -->
   <environments default="development">
       <!-- 每一个environment都使用id作为唯一标识符 -->
       <environment id="development">
           <!-- transactionManager/事务管理 这里说明的是这个environment所使用的事务管理方式 这里是JDBC -->
           <transactionManager type="JDBC"/>
           <!-- dataSource/数据源 顾名思义就是所连接的数据库 每一个environment都有一个数据源 -->
           <dataSource type="POOLED">
               <!-- driver/驱动 所连接的sql使用的驱动 -->
               <property name="driver" value="com.mysql.jdbc.Driver"/>
               <!-- url/链接 &amp;是转义符号，这里不能直接使用& 后面指的是
					useSSL/使用安全连接
					useUnicode/使用eUnicode编码
					characterEncoding/设置编码格式
					还有其他的配置可在官网文档上看见
				-->
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
       
       <environment id="test">
           <transactionManager type="JDBC"/>
           <dataSource type="POOLED">
               <property name="driver" value="com.mysql.jdbc.Driver"/>
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
       
   </environments>
    
   <mappers>
       <mapper resource="com/kuang/dao/userMapper.xml"/>
   </mappers>
</configuration>
```

### 1.3、编写MyBatis工具类

- 查看帮助文档

```java
package com.guo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class mybatisUtils {
    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis的第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    //获取SqlSession连接
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
```

### 1.4、创建实体类

- 创建pojo包
- 把数据库中的字段写出来
- 构造,有参,无参
- set/get
- toString()

```java
package com.guo.pojo;

public class user {
    
    //实体类
    private int id;  //id
    private String name;   //姓名
    private String pwd;   //密码

    //构造,有参,无参
    //set/get
    //toString()

    public user() {
    }

    public user(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
```

### 1.5、编写Mapper接口类

以后的dao都叫Mapper

```java
package com.guo.dao;

import com.guo.pojo.user;

import java.util.List;

public interface userMapper {
    List<user> selectUser();
}
```

### 1.6、编写Mapper.xml配置文件

- **namespace 十分重要，不能写错！**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 绑定一个对应的dao/Mapper接口 -->
<mapper namespace="com.guo.dao.userMapper">
    <select id="selectUser" resultType="com.guo.pojo.user">
  select * from mybatis.user
 </select>
</mapper>
```

### 1.7、编写测试类

- Junit 包测试

```java
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
}
```

## 2、CRUD增删改查

在上面已经把一个基本的Mybatis项目搭建起来后，需要改动的文件就只剩下了：

1. userMapper.java
2. userMapper.xml
3. 测试类

**userMapper.java中每一个方法都是和userMapper.xml中的每一个标签是一一对应的**

### 2.1、userMapper.java

这里面写每一个操作的接口，比如

```java
package com.guo.dao;

import com.guo.pojo.user;

import java.util.List;

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
}
```

如果想让它返回什么类型的，就写成什么类型的

### 2.2、userMapper.xml

这里面写着所有的sql语句，其中：

1. namespace中的包名要和Dao/Mapper接口的包名一致
2. id：对应着userMapper中的接口名
3. resultType：返回值类型
4. parameterType：参数类型

**类型是什么就写成什么，是封装类就写类的全路径，int就是int，long就是long**

例子：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 绑定一个对应的dao/Mapper接口 -->
<mapper namespace="com.guo.dao.userMapper">
    <!--  简单的查询  -->
    <select id="selectUser" resultType="com.guo.pojo.user">
        select * from mybatis.user
    </select>
    <!--  通过id查询  -->
    <select id="getUserById" resultType="com.guo.pojo.user" parameterType="int">
        select * from mybatis.user where id = #{id}
    </select>
    <!--  对象中的属性可以直接取出来  -->
    <insert id="addUser" parameterType="com.guo.pojo.user">
        insert into mybatis.user (id, name, pwd) values (#{id},#{name},#{pwd});
    </insert>
    
    <update id="updateUser" parameterType="com.guo.pojo.user">
        update mybatis.user
        set name = #{name},pwd = #{pwd}
        where id = #{id};
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from mybatis.user where id = #{id};
    </delete>
</mapper>
```

### 2.3、编写测试类

这就是为什么要用到Junit测试，注意的点：

1. **增删改一定要提交事务**，增删改必备的几句是这样的

   ```java
   //第一步：获取SqlSession对象
   SqlSession session = mybatisUtils.getSqlSession();
   userMapper mapper = session.getMapper(userMapper.class);
   mapper.你要用到的方法名
   //提交
   session.commit();
   //关闭SqlSession
   session.close();
   ```

2. 查询必备的几句是这样的：

   ```java
   //第一步：获取SqlSession对象
   SqlSession session = mybatisUtils.getSqlSession();
   userMapper mapper = session.getMapper(userMapper.class);
   mapper.你要用到的方法名
   //关闭SqlSession
   session.close();
   ```

例子：

```java
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
```

## 3、**可能会遇到的问题：**

1. 配置文件没有注册
2. 绑定接口错误
3. 方法名不对
4. 返回类型不对
5. Maven导出资源问题







