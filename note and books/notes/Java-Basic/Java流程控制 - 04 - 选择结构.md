# Java流程控制 - 04 - 选择结构

- if单选择结构
- If双选择结构
- if多选择结构
- 嵌套的if结构
- switch多选择结构

---

## 一、if单选择结构

我们很多时候需要去判断一个东西是否可行,然后我们才去执行,这样一个过程在程序中用if语句来表示

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617174819993-154143909.png)

### 语法

```java
if(布尔表达式){
  //如果布尔表达式为true讲执行的语句
}
```

### 当输入Hello的时候，控制台输出Hello End，否则只输出End

```java
import java.util.Scanner;

public class IfDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入内容：");
        String s = scanner.nextLine();

        //equals：判断字符串是否相等
        if (s.equals("Hello")){
            System.out.println(s);
        }

        System.out.println("End");
        scanner.close();
    }
}
```

---

## 二、if双选择结构

现在有个需求,公司要收购一个软件,成功了,给人支付100万元,失败了,自己找人开发。这样的需求用一个`if`就搞不定了,我们需要有两个判断,需要—个双选择结构,所以就有了`if-else`结构。

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617182229310-459394341.png)

### 语法

```java
if(布尔表达式){
  //如果布尔表达式的值为true
}else{
  //如果布尔表达式的值为false
}
```

### 分数判断

***考试分数大于60就是及格，小于60就不及格***

```java
import java.util.Scanner;

public class IfDemo02 {
    public static void main(String[] args) {
        //考试分数大于60就是及格，小于60就不及格
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();

        if (score>=60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }

        scanner.close();
    }
}
```

---

## 三、if多选择结构

我们发现刚才的代码不符合实际情况,真实的情况还可能存在ABCD,存在区间多级判断。比如90-100就是A,80-90就是B.等等,在生活中我们很多时候的选择也不仅仅只有两个,所以我们需要一个多选择结构来处理这类问题!

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200617193314603-1942914048.png)

### 语法

```java
if(布尔表达式 1){
  //如果布尔表达式 1 的值为true执行代码
}else if(布尔表达式 2){
  //如果布尔表达式 2 的值为true执行代码
}else if(布尔表达式 3){
  //如果布尔表达式 3 的值为true执行代码
}else{
  //如果以上布尔表达式都不为true执行代码
}
```

### 分数判断
***100为满分，90-100为A，80-90为B，70-80为C，60-70为D，0-60为不及格，其余的显示成绩不合法***

```java
import java.util.Scanner;

public class IfDemo03 {

    //100为满分，90-100为A，80-90为B，70-80为C，60-70为D，0-60为不及格，其余的显示成绩不合法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        int score = scanner.nextInt();

        if(score==100){
            System.out.println("恭喜满分。");
        }else if(score<100 && score>=90){
            System.out.println("A级。");
        }else if(score<90 && score>=80){
            System.out.println("B级。");
        }else if(score<80 && score>=70){
            System.out.println("C级。");
        }else if(score<70 && score>=60){
            System.out.println("D级。");
        }else if(score<60 && score>=0){
            System.out.println("不及格！！！");
        }else{
            System.out.println("成绩不合法！！！");
        }

        scanner.close();
    }
}
```

### 注意事项

1. if语句至多有1个eLse语句,else语句在所有的 else if语句之后
2. if语句可以有若干个else if语句,它们必须在else语句之前
3. 一旦其中一个else if语句检测为true,其他的else if以及else语句都将跳过执行

---

## 四、嵌套的if语句

使用嵌套的`if..else`语句是合法的。也就是说你可以在另一个`if`或者` else if`语句中使用`if`或者 `else if`语句。你可以像`if`语句一样嵌套 `else if...else`。

### 语法

```java
if(布尔表达式 1){
  //如果布尔表达式 1的值为true执行代码
  if(布尔表达式 2){
    //如果布尔表达式 1的值为true会进入这个循环，如果布尔表达式 2的值为true执行代码
  }
}
```

---

### 思考

***我们需要寻找一个数，在1-100之间***

1. 从1比到100(消耗时间)
2. 如果用嵌套if语句，就可以实现分为两个部分：
   - 看它是否大于50，如果大于，则在50-100中找，如果小于，则在0-50中找

上述为算法思想，这种算法被称为**二分法查找**

---

## 五、`switch`选择结构

- 多选择结构还有一个实现方式就是 `switch case`语句。
- `switch case`语句判断一个变量与一系列值中**某个值**是否相等,每个值称为一个分支。

### 语法

```java
switch(expression){
  case value :
    //语句
    break;//可选
  case value :
     //语句
    break;//可选
    //可以有任意数量的case语句
  default ://可选
    //语句
}
```

### `switch`语句中的变量类型可以是

- byte、short、int 或者 char
- ***从 Java SE 7开始***
  - ***`switch`支持字符串`String`类型了***
- 同时`case`标签必须为字符串常量或字面量

---

### 例子

```java
public class SwitchDemo01 {
    public static void main(String[] args) {

        char grade = 'C';

        switch (grade){
            case 'A':
                System.out.println("优秀");
                break;//可选
            case 'B':
                System.out.println("良好");
            case 'C':
                System.out.println("及格");
            case 'D':
                System.out.println("再接再厉");
            case 'F':
                System.out.println("挂科");
          	default://如果上面条件都没满足，执行这个语句   //可选
                System.out.println("未知等级");
        }
    }
}
```

---

### `case` 穿透

上面控制台输出为：及格，再接再厉，挂科，原因就是没有加`break`语句
未加`break`语句时，后面都会跟着输出，这个就叫**case穿透**

---

### 字符串类型的`switch`

```java
public class SwitchDemo02 {
    public static void main(String[] args) {
        String name = "郭鹏飞";

        //JDK7的新特性，表达式结果可以是字符串！！！
        //字符的本质还是数字

        switch (name){
            case "郭鹏飞":
                System.out.println("郭鹏飞");
                break;
            case "厉害":
                System.out.println("厉害");
                break;
            default:
                System.out.println("弄啥嘞！");
        }
    }
}
```

---

## 六、补充

### 反编译

Java程序编译：Java -> class(字节码文件)
反编译：class -> Java

IDEA可以进行反编译，class文件不能直接复制进IDEA中，但是可以放在包的文件夹中

放入文件夹中后，IDEA就可以对它进行反编译

