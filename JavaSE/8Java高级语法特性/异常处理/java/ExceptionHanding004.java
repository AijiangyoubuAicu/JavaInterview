/*嵌套的 try 语句
 *
	try 语句可嵌套！一条try语句可以位于一条try语句中，每次遇到 try 语句时，异常的上下文就会被推入堆栈中
	如果内层的try语句没有为特定的异常提供catch处理程序，堆栈就会弹出该try语句，检查下一条try语句的catch处理程序
	一直到能够匹配的catch语句，或是检查完所有嵌套的 try语句
	
	如果没有找到匹配的catch语句，JAVA运行时系统会处理异常
	
 */
public class ExceptionHanding004 {
	public static void main(String[] args) {
		try {
			int a = args.length;
			int b = 42 / a;
			System.out.println("a = " + a);
		
			try {
				if(a == 1) {
					a = a / (a - a);
				}
				
				if(a == 2) {
					int[] c = {1};
					c[42] = 99;
				}
				
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("内部try catch语句" + e);
				 }
			
			} catch(ArithmeticException e) {
				System.out.println("外部try catch语句" + e);			//外部try catch语句java.lang.ArithmeticException: / by zero
	
			}
		
		}
	}




























