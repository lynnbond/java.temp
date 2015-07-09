package classLoader;

//Class B 必须位于MyClassLoader的查找范围内，
//而不应该在MyClassLoader的父类装载器的查找范围内。

public class B {
    static int b ;

    public B(Integer testb) {
        b = testb.intValue();
    }

    public void printB() {
        System.out.println("my static field b is "+ b);
    }
}

