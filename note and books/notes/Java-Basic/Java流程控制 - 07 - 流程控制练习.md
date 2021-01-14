# Java流程控制 - 07 - 练习和Debug

## 一、练习

- 打印三角形

```java
public class TestDemo01 {
    public static void main(String[] args) {
        //打印三角形
        for (int i = 1; i <= 5; i++) {
            for(int j = 5; j>=i;j--){
                System.out.print(" ");
            }
            for(int j = 1; j<=i;j++){
                System.out.print("*");
            }
            for(int j = 1; j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

---

## 二、Debug

Java流程控制，尤其是循环语句时，Debug非常好用，而且非常实用，Debug就在运行的下面

1. 在某处代码处前行数处单击出一个小红点
2. 右键程序/运行台/main方法小箭头 点Debug 就是小虫子的标志
3. 出来一个程序长时间运行的框
4. 除非你点下一步，不然程序不会走

---