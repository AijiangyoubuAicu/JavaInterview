/*3个近期添加的异常特性：从JDK7开始
 * 
 	1）当资源（例如文件）不再需要时能够自行释放，是 try 语句的扩展形式，称带有资源的 try 语句，常见于I/O中
 	
 	2）多重捕获：允许通过相同的 catch 子句捕获两个或多个异常。不必逐个捕获所有异常，可通过一条catch子句使用相同的代码处理所有代码
 				 使用多重捕获，在catch子句中使用或运算符 " | " 分隔每个异常，每个多重捕获参数都被隐式声明为final，因此不能赋新值
 	
 	3）最后重新抛出（更精准地重新抛出）：会对重新抛出的异常类型进行限制，只能重新抛出满足以下条件的经检查的异常：
 										 由关联的 try 代码块抛出，没有被前面的 catch 子句处理过，并且是单数的子类型或超类型。
 										 为了强制使用“更精准地重新抛出”异常特性，catch 参数必须被有效地显式地声明为final，意味着 catch 代码块不能为之赋值
 */
public class ExceptionHanding010 {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] vals = {1, 2, 3};
		
		try {
			int result = a / b;
			vals[10] = 17;
		//多重捕获语法书写
		} catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {	//java.lang.ArithmeticException: / by zero
			System.out.println(e);
		}
		System.out.println("最后的输出");									//最后的输出

	}

}
