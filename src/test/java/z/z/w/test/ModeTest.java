package z.z.w.test ;

import org.junit.Test ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.ModeTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月21日 下午5:46:07 
 *   LastChange: 2015年9月21日 下午5:46:07 
 *      History:
 * </pre>
 **************************************************************************/
public class ModeTest
{
	
	@Test
	public void testMode()
	{
		for ( int i = 0 ; i < 10 ; i++ )
		{
			System.out.println( i + " : " + ( i % 2 ) + " - " + ( i / 2 ) ) ;
		}
	}
}
