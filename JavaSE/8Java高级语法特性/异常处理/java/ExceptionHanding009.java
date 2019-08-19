/*链式异常：JDK1.4开始
 * 
 	通过链式异常，可以为异常关联另一个异常
 	第二个异常描述第一个异常的原因（描述当前异常原因的异常，在后面又被称为“引发异常”或“背后异常”）
 	
 	使用链式异常可以处理所有其他存在多层异常的情况！
 		如：某个方法试图除零而导致 ArithmeticException异常，而实际导致问题根源发生的是一个I/O错误
 			那么编译器会显式地抛出 ArithmeticException异常，这是已经发生的错误，但我们更想知道更加内在的错误！
 	
 	为了使用链式异常，可向 Throwable 类添加两个构造函数和两个方法
 		两个构造函数：
 			Throwable(Throwable causeExc)				//是引发当前异常的异常，causeExc是当前异常的背后原因
 			Throwable(String msq, Throwable causeExc)	//第二种形式允许在指定引发异常的同时指定异常描述
 		两个方法：
 			Throwable getCause()						//返回引发当前异常的异常，如果不存在背后异常，就返回null
 			Throwable initCause(Throwable causeExc)		//将cause和调用异常关联到一起，并返回对异常的引用
 	
 */
public class ExceptionHanding009 {
	
	static void demoproc() {
		//new 一个顶层异常
		NullPointerException e = new NullPointerException("顶层异常");
		//new 一个引发异常的异常
		e.initCause(new ArithmeticException("cause"));
		//抛出该异常
		throw e;
	}
	
	public static void main(String[] args) {
		try {
			demoproc();
		} catch(NullPointerException e) {
			//显式外层异常
			System.out.println(e);					//java.lang.NullPointerException: 顶层异常
			//显式内层异常
			System.out.println(e.getCause());		//java.lang.ArithmeticException: cause
		}
	}
}
