/*finally
 * 
 	当抛出异常时，方法中的执行流会采用一条非常突然、非线性的路径，这将改变方法的正常执行流；
 	
 	使用 finally 可以创建一个代码块，该代码块会在执行 try catch 代码块之后，并执行完 try catch代码块后面的代码之前执行
 	不管是否有异常抛出，都会执行 finally 代码块；
 	
 	所以抛出异常，那么即使没有 catch 语句能匹配异常，finally 代码块仍会执行
 	只要方法从 try catch 代码块内部返回调用者，不管通过未捕获的异常还是显式的返回语句，都会在方法返回之前执行 finally 子句
 	
 	对于关闭文件句柄以及释放在方法开始时进行分配，并在方法返回之前进行处理的所有其他资源来说，finally 子句都很有用；
 	
 	每条 try 语句至少需要一条 catch 子句或 finally 子句
 	
 	如果finally代码块和某个try代码块相关联，那么finally代码块会在这个 try 代码块结束后执行
 	
 */
public class ExceptionHanding007 {
	static void procA() {
		try {
			System.out.println("第一个方法的try");
			throw new RuntimeException("demo");
		//不管异常是否抛出，该finally代码块都会执行
		} finally {
			System.out.println("第一个方法的finally");
		}
	}
	static void procB() {
		try {
			System.out.println("第二方法的try");
		//return语句将结束代码块，所以不会再跳转finally
			return;
		} finally {
			System.out.println("第二个方法的finally");
		}
	}
	static void procC() {
		try {
		System.out.println("第三个方法的try");
		//不管异常是否抛出，该finally代码块都会执行
		} finally {
			System.out.println("第三个方法的fianlly");
		}
	}
	public static void main(String[] args) {
		try {
			procA();									//第一个方法的try
														//第一个方法的finally
		} catch (Exception e) {
			System.out.println("主方法里的try");		//主方法里的try
		}
		
		procB();										//第二方法的try
														//第二个方法的finally
		procC();										//第三个方法的try
														//第三个方法的fianlly
	}
}


















