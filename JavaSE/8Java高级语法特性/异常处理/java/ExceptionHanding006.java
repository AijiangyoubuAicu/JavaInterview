/*throws
 * 
 	如果异常方法发生了意料之外的异常，那么就必须指明这种行为，以便方法的调用者能够保卫它们自己以防备上述异常
 	
 	throws 子句列出方法可能会抛出的异常类型。除了 Error 和 RuntimeException 及其子类类型的异常之外
 		对于其他类型的异常这都是必需的
 	
 	方法可能抛出的所有其他异常都必须在 throws 子句中进行声明，否则编译会出错。
 		
 		参数类型 方法名(参数列表) throws 异常列表 {
 			方法内容;
 		}
 	
 */
public class ExceptionHanding006 {
	//列出可能会抛出的异常类型，方法可能抛出的所有类型都必须在此处声明，
	//如果没有 throws 那么该程序试图抛出无法匹配的异常而编译错误
	static void throwOne() throws IllegalAccessException,ArrayIndexOutOfBoundsException {
		System.out.println("插入一个异常");					//插入一个异常
		throw new IllegalAccessException("demo");
	}
	
	public static void main(String[] args) {
		//必须定义捕获该异常的 try catch 语句
		try {
			throwOne();
		} catch(IllegalAccessException e) {
			System.out.println(e);							//java.lang.IllegalAccessException: demo
		}
	}

}
