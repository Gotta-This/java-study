# Java基础 - 09 - JavaDoc

***Java：面向百度编程***
***基础部分这里结束***
***基础部分的一切知识，后面几乎每天都在用！！！***

## 一、javadoc文档

---

百度搜**JDK帮助文档**就会找到官网上的[Javadoc文档](https://www.oracle.com/cn/java/technologies/java-se-api-doc.html)
`javadoc`命令是用来生成自己的`API文档``的

---

### 参数信息

- @author 作者名
- @version 版本号
- @since 指明需要最早使用的jdk版本
- @param 参数名
- @return 返回值情况
- @throws 异常抛出情况

---

### 写一个Java类

```java
package com.guo.base;

public class Doc {
    String name;
  
    public  String test(String name)throws Exception{
        return name;
    }
}

```

这里定义了一个`name`和方法`test`，方法抛出了异常

---

### 类注释——在类外写文档注释/**      */

```java
package com.guo.base;

/**
 * @author Guo
 * @version 1.0
 * @since 1.8
 */
public class Doc {
    String name;

    public  String test(String name)throws Exception{
        return name;
    }
}
```

---

### 方法注释——当在方法名前写文档注释时，发现会自动生成一些

```java
package com.guo.base;

/**
 * @author Guo
 * @version 1.0
 * @since 1.8
 */
public class Doc {
    String name;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public  String test(String name)throws Exception{
        return name;
    }
}
```

---

## 二、javadoc注释和普通注释的差别/用处

1. 把刚才敲的`Doc.java`在资源管理器中显示(在IDEA中右键，windows - show in explorer，Mac - show in Finder)
2. 进入目录下的命令行工具(windows - 地址栏前面敲上cmd+空格 回车，Mac - 打开终端 cd+把整个文件夹拉进去 回车)
3. 往里面输入：

```shell
javadoc -encoding UTF-8 -charset UTF-8 Doc.java
```

***中间的参数`-encoding UTF-8`和`charset UTF-8`是防止注释中有中文，提前解决掉***

回车后虽然可能有错误，但是还是执行成功，这时候就会发现，文件夹里多了一大堆东西
除了之前的Java类，多出了一个`index.html`这个明显是主页
打开后就会发现，这个东西和官方的API文档一模一样，而且里面的东西，都是我们当时敲的类

---

## 三、作业：如何使用IDEA生成JavaDoc文档

1. 首先在想要生成javadoc的地方新建一个文件夹

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163157430-778096286.png)

2. 接下来点击IntelliJ IDEA顶部的Tools菜单，选择Generate JavaDoc选项

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163307205-856920459.png)

3. 然后在弹出的界面中我们点击Output directory输入框后面的按钮

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163507820-473695204.png)

4. 在弹出的选择文件夹界面中选择刚才新建的文件夹

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163534956-1544021805.png)

5. 接下来在底部的Locale输入框配置语言和编码集，如下图所示，语言用zh_CN，代表中文

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163554656-1784809620.png)

6. 然后点击确定以后我们就等待IntelliJ IDEA给我们生成JavaDoc文档即可，等到输出栏出现如下图所示的提示代表生成完毕

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163642117-1187209024.png)

7. 接下来我们打开JavaDoc文件夹，找到index.html文件，点击它

   ![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163749558-1765163876.png)

8. 最后我们就可以看到如下图所示的JavaDoc文档了，它把项目中所有的类，程序包都给写到文档了，非常的详细

	![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617163809215-1996803601.png)

---

