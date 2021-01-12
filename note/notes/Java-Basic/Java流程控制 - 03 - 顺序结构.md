# Java流程控制 - 03 - 顺序结构

JAVA的基本结构就是顺序结构,除非特别指明,否则就按照顺序一句一句执行。
顺序结构是最简单的算法结构。

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617173547654-1737872379.png)

语句与语句之间,框与框之间是按从上到下的顺序进行的,它是由若干个依次执行的处理步骤组成的,***它是任何一个算法都离不开的一种基本算法结构***。

---

## 例子

```java
public class ShunXuDemo {
    public static void main(String[] args) {
        System.out.println("hello1");
        System.out.println("hello2");
        System.out.println("hello3");
        System.out.println("hello4");
        System.out.println("hello5");
        System.out.println("hello6");
    }
}
```

控制台输出为：

```java
hello1
hello2
hello3
hello4
hello5
hello6
```

***顺序结构就是程序一步一步，一行一行，从上往下执行***

---