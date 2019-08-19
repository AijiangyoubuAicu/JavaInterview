/*使用 try 和 catch
 * 
 	JAVA提供的默认异常处理程序很有用，但是通常我们希望自己处理异常
 		自己处理有两个优点：1）允许修复错误 2）阻止程序自动终止
 		
 	可以使用 try{ }catch(){ } 格式处理可能会出现异常的代码块
 	
 		try：封装希望监视的代码
 		catch：指定希望捕获的异常类型
 		
 		try {
 			要监视的代码块;
 		} catch(出现的异常1) {
 			该异常的处理方式;
 		} catch(出现的异常2) {
 			该异常的处理方式;
 		} catch(出现的异常3) {
 			该异常的处理方式;
 		} ...
 	
 	显式异常的描述信息：Throwable 重写了（由Object）toString()方法，从而可以返回一个包含异常描述的字符串
 	
 */
public class ExceptionHanding002 {

	public static void main(String[] args) {
		int d, a;
		// try 以及 catch 语句构成了一个单元
		try {
			// try 代码块一旦抛出了异常，那么它就会终止运行并跳转至 catch 代码块中
			d = 0;
			a = 42 / d;
			System.out.println("这条语句不会输出");
			// catch 代码块将一直往下运行
			// catch 子句的作用域限制在由之前 try 语句指定的那些语句内，不能捕获由另外一条 try 语句抛出的异常（嵌套try语句例外） 
		} catch(ArithmeticException e) {
			System.out.println("在除法计算中除以了0");				//在除法计算中除以了0
			//可选择打印这个异常
			System.out.println(e);									//java.lang.ArithmeticException: / by zero
		}
		System.out.println("捕获了该异常的话，这条语句就会输出");	//捕获了该异常的话，这条语句就会输出
	}
}
















