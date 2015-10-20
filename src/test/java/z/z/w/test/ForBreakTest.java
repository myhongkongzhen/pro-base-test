package z.z.w.test ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.ForBreakTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月24日 上午10:05:33 
 *   LastChange: 2015年9月24日 上午10:05:33 
 *      History:
 * </pre>
 **************************************************************************/
public class ForBreakTest
{
	
	/**
	 * Create by : 2015年9月24日 上午10:05:33
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		boolean flag = Boolean.FALSE ;
		for ( int i = 0 ; i < 10000000 ; i++ )
		{
			if ( flag )
			{
				System.out.println( "break" ) ;
				break ;
			}
			System.out.println( i ) ;
			if ( ( ( ( i + 1 ) % 10 ) == 0 ) )
			{
				flag = Boolean.TRUE ;
			}
			
		}
	}
	
}
