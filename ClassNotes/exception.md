

## 一、Java 中异常的整体分类结构（先看全景）

Java 中所有“异常/错误”都继承自一个祖先类：

    java.lang.Throwable
    ├── Error
    └── Exception
        ├── RuntimeException（非检查性异常）
        └── 其他 Exception（检查性异常）

可以用一句话概括：

> **Throwable = Error + Exception**

***

## 二、Error 和 Exception 的关系与本质区别

### 1️⃣ Error（错误）

**定义：**

*   表示 **JVM 或系统级的严重问题**
*   程序通常**无能为力，也不应该处理**

**特点：**

*   一般是**不可恢复的**
*   不要求程序员捕获或处理
*   大多数情况下即使 catch 了也毫无意义

**常见子类举例：**

```java
OutOfMemoryError      // 内存溢出
StackOverflowError   // 栈溢出
NoClassDefFoundError // 类定义找不到
```

✅ **结论：**

> Error 通常不处理，让程序直接崩溃是合理的。

***

### 2️⃣ Exception（异常）

**定义：**

*   表示 **程序在运行过程中出现的异常情况**
*   原则上是**可以预期、可以处理的**

Exception 又分为两大类（这正是面试和实际开发的重点）👇

***

## 三、检查性异常（Checked Exception）是什么？

### ✅ 1️⃣ 定义

**检查性异常：**

> **编译期就必须检查的异常**
>
> 👉 不处理就**无法通过编译**

### ✅ 2️⃣ 典型特征

*   **必须显式处理**（二选一）
    *   `try-catch`
    *   `throws`

否则：

```text
编译错误（Compile-time error）
```

### ✅ 3️⃣ 典型示例

```java
IOException
SQLException
ClassNotFoundException
FileNotFoundException
```

### ✅ 4️⃣ 示例代码

```java
public void readFile() throws IOException {
    FileInputStream fis = new FileInputStream("a.txt");
}
```

或者：

```java
try {
    FileInputStream fis = new FileInputStream("a.txt");
} catch (IOException e) {
    e.printStackTrace();
}
```

📌 **说明：**
这类异常通常是：

*   外部因素导致的（文件、网络、数据库）
*   程序无法百分百保证不发生

***

## 四、非检查性异常（Unchecked Exception）是什么？

### ✅ 1️⃣ 定义

**非检查性异常：**

> **编译期不强制检查**
>
> 👉 可以写，也可以不写 `try-catch`

### ✅ 2️⃣ 本质

它们全部是：

    RuntimeException 的子类

### ✅ 3️⃣ 常见示例（你一定见过）

```java
NullPointerException
ArrayIndexOutOfBoundsException
ClassCastException
ArithmeticException
IllegalArgumentException
```

### ✅ 4️⃣ 示例

```java
int a = 10 / 0;  // ArithmeticException
```

```java
String s = null;
s.length();     // NullPointerException
```

✅ **编译完全没问题，运行时才炸**

***

## 五、为什么 RuntimeException 不要求强制处理？

核心原因一句话：

> **它们通常是“程序员错误”，修代码比 try-catch 更重要**

例如：

| 异常                             | 是否应该 try-catch |
| ------------------------------ | -------------- |
| NullPointerException           | ❌ 不应，应该修复逻辑    |
| ArrayIndexOutOfBoundsException | ❌ 修正数组边界       |
| IllegalArgumentException       | ❌ 校验参数         |

✅ Java 的设计理念是：

> **强制你处理“不可控异常”，放开“可通过代码避免的异常”**

***

## 六、哪些异常「必须要处理」？

### ✅ 必须处理的异常（编译器强制）

👉 **所有检查性异常（Checked Exception）**

规则非常简单：

    Exception（不包括 RuntimeException）

必须处理 ✅

### ❌ 不必须处理的异常

*   所有 `RuntimeException`
*   所有 `Error`

***

## 七、一句话对所有概念作最终总结（面试级）

> *   **Throwable** 是所有异常与错误的父类
> *   **Error**：JVM 级错误，程序不该处理
> *   **Exception**：程序级异常
>     *   ✅ **Checked Exception**：必须显式处理
>     *   ✅ **RuntimeException**：非检查性异常，通常是程序员错误
> *   **必须处理的只有检查性异常**

***

> **Java 异常的“捕获机制”和“抛出机制”是如何配合使用的？**

我先给你一个**一句话结论**，再展开说明。

***

## 一句话结论（先记这个）

> **try-catch-finally 是“接住异常”的机制，  
> throw / throws 是“制造或上抛异常”的机制，  
> 二者是相互配合而不是相互替代的。**

***

## 一、先整体看一张「角色分工图」

| 关键字       | 作用阶段  | 核心职责                |
| --------- | ----- | ------------------- |
| `throw`   | 运行时   | **手动抛出一个异常对象**      |
| `throws`  | 方法定义处 | **声明本方法可能抛出的异常**    |
| `try`     | 运行时   | **包裹可能出异常的代码**      |
| `catch`   | 运行时   | **捕获并处理异常**         |
| `finally` | 运行时   | **无论是否异常都会执行的清理代码** |

***

## 二、throw 和 throws 的区别与关系

### 1️⃣ throw ——「真的把异常扔出去」

**throw 是一个动作**

```java
throw new IllegalArgumentException("参数非法");
```

✅ 特点：

*   用在 **方法体内部**
*   抛出的是一个 **异常对象**
*   可以抛出：
    *   RuntimeException
    *   Checked Exception（前提是方法声明了 throws）

📌 本质上：

> **throw = 异常发生的“源头”**

***

### 2️⃣ throws ——「提前打声明」

**throws 是一个声明**

```java
public void readFile() throws IOException
```

✅ 特点：

*   用在 **方法签名上**
*   告诉调用者：
    > “我可能会抛这个异常，你自己处理”

📌 本质上：

> **throws = 把异常处理责任“往上推”**

***

### 3️⃣ throw 和 throws 的典型配合

```java
public void readFile() throws IOException {
    if (!file.exists()) {
        throw new IOException("文件不存在");
    }
}
```

✅ 这里发生了什么？

*   `throw`：实际抛出 IOException
*   `throws`：让方法合法（否则编译报错）

***

## 三、try-catch-finally 是干什么的？

### ✅ try-catch：异常的“拦截器”

```java
try {
    readFile();
} catch (IOException e) {
    System.out.println("读取失败");
}
```

✅ 含义：

*   **try**：尝试执行
*   **catch**：如果异常来了，就在这里处理

📌 本质：

> **try-catch = 终结异常 or 转化异常**

***

### ✅ finally：善后工作（资源释放）

```java
finally {
    fis.close();
}
```

✅ 特点：

*   不管：
    *   是否发生异常
    *   是否 return
*   **都会执行**（几乎）

📌 典型用途：

*   关闭资源（文件 / socket / DB 连接）

***

## 四、try-catch vs throws 的根本区别（重点）

### ✅ try-catch：**当前方法处理**

```java
public void method() {
    try {
        risky();
    } catch (IOException e) {
        // 在这里处理
    }
}
```

👉 异常**到此为止**

***

### ✅ throws：**当前方法不处理，交给上层**

```java
public void method() throws IOException {
    risky();
}
```

👉 异常**继续向上抛**

***

### ✅ 本质对比表（非常重要）

| 维度       | try-catch | throws     |
| -------- | --------- | ---------- |
| 是否真正处理异常 | ✅ 是       | ❌ 否        |
| 异常是否终止传播 | ✅ 是       | ❌ 否        |
| 代码位置     | 方法体内      | 方法声明处      |
| 使用目的     | 兜底、补救、记录  | 职责划分、交给调用方 |

***

## 五、throw + try-catch 的典型组合方式

### ✅ 场景 1：catch 后重新 throw（真实项目常用）

```java
try {
    dao.save();
} catch (SQLException e) {
    // 记录日志
    log.error(e);
    // 转为业务异常
    throw new ServiceException("保存失败", e);
}
```

📌 这里说明了什么？

*   **catch** 负责记录、转换
*   **throw** 抛出更高层可理解的异常

✅ 这是「异常分层设计」的核心写法

***

## 六、finally 和 throw / return 的关系（易错点）

### ✅ finally 一定会执行吗？

大多数情况下 ✅  
但以下情况 ❌：

*   `System.exit()`
*   JVM 崩溃
*   finally 之前机器断电

***

### ✅ finally + return 的执行顺序

```java
try {
    return 1;
} finally {
    System.out.println("finally");
}
```

输出：

```text
finally
```

✅ **先执行 finally，再返回值**

⚠️ 不推荐在 finally 里写 return（会吞掉异常）

***

## 七、哪些组合是“合理的”，哪些是“雷区”

### ✅ 推荐 ✅

*   Checked Exception：
    *   局部能处理：try-catch
    *   不能处理：throws
*   RuntimeException：
    *   让它抛出
    *   或 catch 后转换成业务异常

***

### ❌ 不推荐 ❌

```java
try {
    ...
} catch (Exception e) {
    // 什么也不做
}
```

❌ 吞异常 —— 调试地狱

***

```java
finally {
    return;
}
```

❌ 覆盖原异常

***

## 八、最重要的一句工程经验总结

> **异常不是用来“防止程序出错”的，而是用来“表达错误语义”的**

*   `throw`：表达“发生了什么问题”
*   `throws`：表达“谁来负责处理”
*   `try-catch`：决定“在这一层要不要解决”

***



# 一、try-with-resources 是什么？（从 finally 的痛点说起）

## 1️⃣ 传统 try-finally 的问题

以前我们这样关资源：

```java
FileInputStream fis = null;
try {
    fis = new FileInputStream("a.txt");
    // 使用资源
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fis != null) {
        fis.close();  // 这里也可能抛异常
    }
}
```

❌ 问题很多：

*   代码冗长
*   close 也可能抛异常
*   多个资源要写多层 finally
*   非常容易漏关

***

## 2️⃣ try-with-resources 的核心思想

> **“让 JVM 帮你在 finally 阶段自动关闭资源”**

从 **Java 7** 开始引入。

**前提条件只有一个：**

> 资源必须实现 `AutoCloseable`（或 `Closeable`）

***

## 3️⃣ try-with-resources 基本写法 ✅

```java
try (FileInputStream fis = new FileInputStream("a.txt")) {
    // 使用资源
} catch (IOException e) {
    e.printStackTrace();
}
```

✅ 等价于：

*   JVM 自动在 try 结束时调用：
    ```java
    fis.close();
    ```

✅ 不论：

*   正常结束
*   抛异常
*   return

都会自动关闭

***

## 4️⃣ 可以同时管理多个资源（非常重要）

```java
try (
    FileInputStream fis = new FileInputStream("a.txt");
    BufferedInputStream bis = new BufferedInputStream(fis)
) {
    // 使用多个资源
}
```

✅ 关闭顺序：**后声明的，先关闭（栈结构）**

***

## 5️⃣ try-with-resources 的执行顺序（面试点）

```java
try (Resource r = new Resource()) {
    // 使用
}
```

顺序是：

1.  创建资源
2.  执行 try 块
3.  自动调用 `close()`
4.  再处理异常 / 返回

***

## 6️⃣ try-with-resources + catch + finally 是可以共存的

```java
try (Connection conn = getConnection()) {
    // 使用连接
} catch (SQLException e) {
    throw new RuntimeException(e);
} finally {
    System.out.println("日志记录");
}
```

✅ **finally 仍然会执行**  
✅ 资源仍然会被自动关闭

***

## 7️⃣ try-with-resources 的一个高级细节（了解即可）

### ❗ suppressed exception（被抑制异常）

```java
try (AutoCloseable r = ...) {
    throw new RuntimeException("业务异常");
}
```

如果：

*   try 里抛异常
*   close() 也抛异常

👉 **close 的异常会被“压制（suppressed）”**

可以这样查看：

```java
Throwable[] suppressed = e.getSuppressed();
```

***

# 二、多个异常的「处理方式」有哪些？

Java 对“多个异常”给了三套解决方案。

***

## 一）多个 catch（传统方式）

```java
try {
    readFile();
    connectDb();
} catch (IOException e) {
    // 文件异常
} catch (SQLException e) {
    // 数据库异常
}
```

✅ 优点：清晰、针对性强  
❌ 缺点：catch 太多时代码膨胀

***

## 二）多异常 catch（Java 7 之后）

### ✅ 语法（非常常用）

```java
try {
    risky();
} catch (IOException | SQLException e) {
    e.printStackTrace();
}
```

✅ 要求：

*   异常之间 **没有继承关系**
*   `e` 是 **final 的**（不能重新赋值）

📌 适用场景：

> **处理逻辑完全一样的不同异常**

***

## 三）catch 父类异常（谨慎使用）

```java
try {
    risky();
} catch (Exception e) {
    e.printStackTrace();
}
```

⚠️ 注意：

*   不能写在具体异常前面（否则编译失败）
*   容易“吃掉”真正的异常语义

✅ 一般用于：

*   程序最外层兜底
*   框架层（如 Controller）

***

# 三、多个异常的「抛出方式」怎么写？

## 1️⃣ 一个方法抛多个异常（用 throws）

```java
public void process() throws IOException, SQLException {
    readFile();
    saveDb();
}
```

✅ 编译期明确告诉调用者：

> “我可能在多个点失败”

***

## 2️⃣ throws + try-with-resources 的典型搭配 ✅

```java
public void read() throws IOException {
    try (FileInputStream fis = new FileInputStream("a.txt")) {
        // 读文件
    }
}
```

✅ 不需要手动 close  
✅ IOException 自动往上抛

***

## 3️⃣ catch 后包装并抛出（真实项目最常见）

```java
try {
    dao.save();
} catch (SQLException e) {
    throw new ServiceException("保存失败", e);
}
```

✅ 好处：

*   保留原始异常（异常链）
*   对上层隐藏技术细节

***

# 四、try-with-resources + 多异常的完整示例（综合）

```java
public void execute() {
    try (
        FileInputStream fis = new FileInputStream("a.txt");
        Connection conn = getConnection()
    ) {
        // 使用资源
    } catch (IOException | SQLException e) {
        throw new RuntimeException("处理失败", e);
    }
}
```

✅ 资源自动关闭  
✅ 异常统一处理  
✅ 代码极其干净

***

# 五、什么时候必须用 try-with-resources？

✅ **只要满足这两点，就强烈推荐用：**

1.  有“需要关闭的资源”
2.  资源实现了 `AutoCloseable`

典型对象：

*   FileInputStream / OutputStream
*   Reader / Writer
*   Socket
*   JDBC 的 Connection / Statement / ResultSet

***

# 六、最终工程级总结（你可以直接背）

> *   **try-with-resources：解决资源关闭问题**
> *   **try-catch：决定是否在本层处理异常**
> *   **throw：制造异常**
> *   **throws：声明异常并上抛**
> *   **多 catch / 多异常 catch：解决异常分支爆炸**
> *   **真实项目中：try-with-resources + catch 包装异常 是标配**

***

