package z.z.w.test ;

import org.junit.Test ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.StaticFunTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月2日 上午10:55:47 
 *   LastChange: 2015年9月2日 上午10:55:47 
 *      History:
 * </pre>
 **************************************************************************/
public class StaticFunTest
{
	
	@Test
	public void testStaticFun()
	{
		for ( int i = 0 ; i < 3 ; i++ )
		{
			new Thread( new Runnable()
			{
				
				public void run()
				{
					TestClass.getTest() ;
				}
				
			} ).start() ;
		}
	}
	
}

class TestClass
{
	public static TestClass getTest()
	{
		TestClass t = new TestClass() ;
		System.out.println( t ) ;
		return t ;
	}
}
