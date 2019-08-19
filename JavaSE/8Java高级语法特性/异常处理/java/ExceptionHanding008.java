/*创建自己的异常子类
 * 
 	尽管JAVA的内置异常处理了大部分常见错误，但是您可能希望创建自己的异常类型，以处理特定于应用程序的情况
 	
 	只需要 Exception 的子类（当然也是 Throwable 子类）即可，您的子类不需要实现任何内容；
 	只要它们存在于类型系统中，就可以将它们用作异常
 	
 	Exception 类没有为自己定义任何方法，它继承了 Throwalbe 提供的方法；
 	所有的异常，包括自定义的那些异常，都可以获得 Throwable 定义的方法，可以重写这些方法中一个或多个!
 	
 	Exception类定义了4个公有的构造函数，其中的两个支持链式异常
 		
 		Exception()			 //创建没有描述的异常
 		Exception(String i)  //可以为异常指定描述信息
 	
 	
 */

class MyException extends Exception {
	private int datail;
	
	MyException(int datail) {
		this.datail = datail;
	}
	
	@Override
	public String toString() {
		return "MyException(" + datail + ")";		
	}
	
}

public class ExceptionHanding008 {
	static void compute(int a) throws MyException {
		System.out.println("MyException(" + a + ")");
		//此处使用if语句声明该异常的触发条件的是 a > 10
		if(a > 10) {
			throw new MyException(a);				
		}
		System.out.println("正常地退出");			
	}
	
	public static void main(String[] args) {
		try {
			//未触发异常
			compute(1);								//MyException(1)
													//正常地退出
			//触发异常
			compute(20);							//MyException(20)
		} catch(MyException e) {
			System.out.println("Caught" + e);		//CaughtMyException(20)

		}
	}

}

