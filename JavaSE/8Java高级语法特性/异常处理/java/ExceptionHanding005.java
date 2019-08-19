/*throw
 * 
 	之前 try catch 语句是JAVA运行时系统抛出的异常，
 	您的程序可以使用 throw 语句创建JAVA标准异常对象
 	
 		throw new Throwable或者子类类型的对象();
 		
 		该new构造可以是空参构造或者字符串构造，字符串构造可以描述该异常
 		
 		有getMessage()方法获取这个字符串。
 	
 	基本类型以及非 Throwable 类都不能作为异常，可以通过两种方式获得Throwable对象：
 		在 catch 子句中使用参数或者使用 new 运算符创建 Throwable 对象
 	
 	如何创建JAVA的标准异常对象：
 		throw new NullPointerException
 */
public class ExceptionHanding005 {
	static void demoproc() {
		try {
			throw new NullPointerException("显式地抛出该异常");	//使用new构造了NullPointerException实例
																//并且该异常将被显式，那么之后的catch就会捕获到这个异常实例并输出相应的输出语句
		} catch(NullPointerException e) {
			System.out.println("第一条catch语句");				//第一条catch语句
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			demoproc();
		} catch(NullPointerException e) {
			System.out.println("第二条catch语句" + e);			//第二条catch语句java.lang.NullPointerException: 显式地抛出该异常
		}

	}

}





