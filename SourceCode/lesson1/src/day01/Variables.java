package day01;

public class Variables {
    /**
     * 成员变量声明在一个类中，但在方法、构造方法和语句块之外。
     * 当一个对象被实例化之后，每个成员变量的值就跟着确定。
     * 成员变量在对象创建的时候创建，在对象被销毁的时候销毁。
     * 成员变量的值应该至少被一个方法、构造方法或者语句块引用，使得外部能够通过这些方式获取实例变量信息。
     * 成员变量可以声明在使用前或者使用后。
     * 访问修饰符可以修饰成员变量。
     * 成员变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把成员变量设为私有。通过使用访问修饰符可以使成员变量对子类可见。
     * 成员变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是 false，引用类型变量的默认值是 null。变量的值可以在声明时指定，也可以在构造方法中指定；
     * 成员变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObjectReference.VariableName。
     */
    //强制类型转换的例子
    public static void main(String[] args) {
        int i = 100;
        long l = i; //自动类型转换，int可以自动转换为long
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);

        double d = 3.14;
        int j = (int) d; //强制类型转换，double需要强制转换为int
        System.out.println("double d = " + d);
        System.out.println("int j = " + j);

        //int和double之间转换，以及除法计算的例子
        int a = 10;
        int b = 3;
        double result1 = a / b; //整数除法，结果是3.0
        double result2 = (double) a / b; //强制类型转换为double，结果是3.3333333333333335
        int result3 = a / b; //整数除法，结果是3

        //类型转换在不同的位置的区别
        System.out.println((double)a/6);
        System.out.println(a/(double)6);
        System.out.println((double)(a/6));
    }

}
