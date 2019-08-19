/*多条catch子句
 * 
 	单块代码可能会引起多个异常，那么就指定两条或多条 catch 子句，每条 catch 子句都可以捕获不同类型的异常
 	当抛出异常时，按顺序检查每条 catch 语句，并执行类型和异常能够匹配的第一条 catch 子句。
 	
 	执行了一条 catch 子句后，会忽略其他 catch 语句，并继续执行之后的语句
 	
 	当使用多条 catch 语句时，要重点记住异常子类必须位于所有超类之前，
 	因为使用了某超类的 catch 语句会捕获这个超类以其所有子类的异常！！
	
 	
 */
public class ExceptionHanding003 {

	public static void main(String[] args) {
		try {
			int a = args.length;
			System.out.println("a = " + a);						//0
			int b = 42 / a;
			int[] c = {1};
			c[42] = 99;											
		} catch(ArithmeticException e) {
			System.out.println("第一条 catch 的异常" + e);		//第一条 catch 的异常java.lang.ArithmeticException: / by zero
		//异常的超类 Exception 如果位于异常子类之前，那么之后的子类将会报错
		//那么想处理这个问题就必须要调换异常的顺序，让超类 Exception 处于子类 catch 之后
//		} catch(Exception e) {
//			System.out.println("一个超类的异常");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("第二条 catch 的异常" + e);
		}
		System.out.println("之后的代码块");						//之后的代码块
	}

}
