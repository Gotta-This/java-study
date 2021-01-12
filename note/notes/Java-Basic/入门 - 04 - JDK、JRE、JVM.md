# 入门 - 04 - JDK、JRE、JVM

---

- JDK：Java Development Kit(JAVA 开发工具包)
  - 除了包含JRE以外还包含了开发java程序所必须的命令工具
  - JDK是 Java 语言的软件开发工具包(**SDK**)。在JDK的安装目录下有一个jre目录，里面有两个文件夹bin和lib，在这里可以认为bin里的就是**jvm**，lib中则是jvm工作所需要的类库，而jvm和 lib合起来就称为**jre**
  - ***JDK = JRE+编译、运行等命令工具***
- JRE：Java Runtime Environment(JAVA 运行环境)
  - 除了包含JVM以外还包含了运行java程序所必须的环境
  - ***JRE = JVM+java系统类库(小零件)***
- JVM：JAVA Virtual Machine(JAVA 虚拟机)
  - 加载.class并运行.class

***说明：***

1. ***运行java程序的最小环境是JRE***
2. ***开发java程序的最小环境是JDK***



![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200606140440381-1318763352.png)

***

参考文献：

> https://blog.csdn.net/ancientear/article/details/79483592