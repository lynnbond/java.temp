package classLoader;

//Class B ����λ��MyClassLoader�Ĳ��ҷ�Χ�ڣ�
//����Ӧ����MyClassLoader�ĸ���װ�����Ĳ��ҷ�Χ�ڡ�

public class B {
    static int b ;

    public B(Integer testb) {
        b = testb.intValue();
    }

    public void printB() {
        System.out.println("my static field b is "+ b);
    }
}

