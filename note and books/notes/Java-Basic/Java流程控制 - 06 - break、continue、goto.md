# Java流程控制 - 06 - break、continue、goto

## 一、`break`

`break`在任何循环语句的主体部分,均可用` break`控制循环的流程。`break`用于强行退出循环,不执行循环中剩余的语句。( `break`语句也在 `switch`语句中使用)

```java
public class BreakDemo {
    public static void main(String[] args) {
        int i = 0;
        while (i<100){
            i++;
            System.out.println(i);
            if(i==30){
                break;//当i为30时中断当前语句
            }
        }
        System.out.println("这里证明，只是循环结束了，程序还是往下走！！");
    }
}
```

---

## 二、`continue`

`continue`语句用在循环语句体中,用于终止某次循环过程,即跳过循环体中尚未执行的语句,接着进行下一次是否执行循环的判定。

```java
public class ContinueDemo {
    public static void main(String[] args) {
        int i =0;
        while (i<100){
            i++;
            if(i%10==0){//当i为10的倍数时，跳过这个10
                System.out.println();
                continue;
            }
            System.out.println(i);
        }
    }
}
```

---

## 三、`continue`和`break`区别

- `break`在任何循环语句的主体部分，均可用`break`控制循环的流程。`break`用于强行退出循环，不执行循环中剩余的语句。
- `break `语句也在`switch`语句中使用
- `continue`  语句用在循环语句体重，用于终止某次循环过程，即跳过循环体中尚未执行的语句，接着进行下一次是否执行循环的判定。

---

## 四、关于`goto`关键字

- `goto`关键字很早就在程序设计语言中出现。尽管`goto`仍是Java的一个保留字,但并未在语言中得到正式使用;Java没有`goto`。然而,在 `break`和 `continue`这两个关键字的身上,我们仍然能看出一些`goto`的影子---带标签的 `break`和`continue`
- 标签”是指后面跟一个冒号的标识符,例如:` label`:
- 对Java来说唯一用到标签的地方是在循环语句之前。而在循环之前设置标签的唯一理由是:我们希望在其中嵌套另一个循环,由于` break`和` continue`关键字通常只中断当前循环,但若随同标签使用,它们就会中断到存在标签的地方。≈

### 标签

```java
public class LabelDemo {
    public static void main(String[] args) {
        //打印101-150之间所有的质数
        //质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数
        int count = 0;
        //不建议使用
        outer:for (int i = 101; i < 150; i++) {
            for(int j = 2; j<i/2; j++){
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.println(i+"  ");
        }
    }
}
```

---