package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {
	//Ҫ�����ԭʼ���� 

	private Object objOriginal;

	/** 

	 * ���캯���� 

	 * @param obj Ҫ�����ԭʼ���� 

	 */

	public HelloWorldHandler(Object obj) {

		this.objOriginal = obj;

	}

	public Object invoke(Object proxy, Method method, Object[] args)

	throws Throwable {

		Object result;

		//��������֮ǰ 

		doBefore();

		//����ԭʼ����ķ��� 

		result = method.invoke(this.objOriginal, args);

		//��������֮�� 

		doAfter();

		return result;

	}

	private void doBefore() {

		System.out.println("before method invoke!");

	}

	private void doAfter() {

		System.out.println("after method invoke!");

	}

}
