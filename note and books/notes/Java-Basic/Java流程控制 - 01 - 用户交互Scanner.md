# Java流程控制 - 01 - 用户交互Scanner

之前我们学的基本语法中我们并没有实现程序和人的交豆,但是Java给我们提供了这样一个工具类,我们可以获取用户的输入。`java.util. Scanner`是Java5的新特征,***我们可以通过Scanner类来获取用户的输入***。

### 基本语法

```java
Scanner s = new Scanner(System.in);
```

通过 `Scanner`类的`next()`与 `nextLine()`方法获取输入的字符串,在读取前我们一般需要使用` hasNext()`与 `has Nextline()`判断是否还有输入的数据。

### 基本使用

```java
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        //从键盘接收数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数据：");

        String str = scanner.nextLine();

        System.out.println("输出的内容为："+str);

        scanner.close();
    }
}
```

---

## 一、`hasnext()`方式判断

```java
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收：");

        //判断用户有没有输入字符串
        if(scanner.hasNext()){
            //使用next方式接收
            String str = scanner.next();//程序会等待用户输入完毕
            System.out.println("输入的内容为："+str);
        }
        //凡是属于IO流的类如果不关闭会一直占用资源，要养成良好的习惯用完就关掉
        scanner.close();
    }
}
```

运行后，控制台会处于一直运行的状态，除非往上面输入内容然后回车，这里输入`hello world`，会发现它只输出了`hello`

---

## 二、`hasNextline()`方式判断

```java
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        //从键盘接收数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用nextline方式接收：");

        //判断是否还有输入
        if(scanner.hasNextLine()){
            String str = scanner.nextLine();
            System.out.println("输出的内容为"+str);
        }
        scanner.close();
    }
}
```

这里在控制台上输入`Hello World!!`控制台就会输出同样的`Hello World!!`

---

## 三、两种方式的比较

- `next()`:
  - 1. 一定要读取到有效字符后才可以结束输入。
  - 2. 对输入有效字符之前遇到的空白,`next()`方法会自动将其去掉
  - 3. 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
  - 4. ***`next()`不能得到带有空格的字符串***。

- `nextLine()`:

	- 1. 以` Enter`为结束符也就是说 `nextLine()`方法返回的是输入回车之前的所有字符。

	- 2. 可以获得空白

---

