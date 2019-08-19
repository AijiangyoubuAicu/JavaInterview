
public class ExceptionHanding001 {

	public static void main(String[] args) {
		/**
		 * 未捕获的异常
		 * 	当JAVA运行时检测到异常时，那么它将会构造一个新的异常对象，然后抛出这个异常；
		 * 	这将导致当前程序终止执行；
		 *
		 * 	一旦抛出异常，就必须有一个异常程序去捕获这个异常并立即进行处理！
		 * 	如果没有提供任何异常处理的程序，那么该异常会由JAVA运行时系统提供的默认处理程序捕获。
		 * 	没有被程序捕获的所有异常，最终都将由默认程序进行处理
		 *
		 * 	默认处理程序会显示一个描述异常的字符串，输出异常发生点的“堆栈踪迹”并终止程序。
		 *
		 */
		
		//如果不处理异常的情况；如下，故意引起处零错误的表达式
		int d = 0;
		int a = 42 / d;		//Exception in thread "main" java.lang.ArithmeticException: / by zero
							//at Konwledge004.ExceptionHanding001.main(ExceptionHanding001.java:68)
							
		/* 	Exception in thread "main" java.lang.ArithmeticException 
				异常类型是Exception的子类ArithmeticException，该类具体描述了发生的错误类型为： zero
		  	at Konwledge004.ExceptionHanding001.main(ExceptionHanding001.java:68)
		  		堆栈轨迹：类名(Konwledge004.ExceptionHanding001)、方法名(main)、文件名(ExceptionHanding001.java)、行号(68)
		*/
		
		
		Exc1.subroutine();		//xception in thread "main" java.lang.ArithmeticException: / by zero
								//at Konwledge004.Exc1.subroutine(ExceptionHanding001.java:94)	多出这行将指示异常处于的类中第几行
								//at Konwledge004.ExceptionHanding001.main(ExceptionHanding001.java:83)

	}

}

class Exc1 {
	static void subroutine() {
		int d = 0;
		int a = 10 / d;
	}
}
































