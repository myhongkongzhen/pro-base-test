package z.z.w.test ;

import java.util.HashSet ;
import java.util.Set ;
import java.util.concurrent.ConcurrentSkipListSet ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.ListTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月2日 上午10:34:22 
 *   LastChange: 2015年9月2日 上午10:34:22 
 *      History:
 * </pre>
 **************************************************************************/
public class ListTest
{
	
	/**
	 * Create by : 2015年9月2日 上午10:34:22
	 */
	public static void main( String[] args )
	{
		ConcurrentSkipListSet< Integer > list = new ConcurrentSkipListSet< Integer >() ;
		list.add( 1 ) ;
		list.add( 2 ) ;
		list.add( 3 ) ;
		list.add( 4 ) ;
		
		Set< Integer > s = new HashSet< Integer >() ;
		s.add( 3 ) ;
		s.add( 1 ) ;
//		s = null ;
		
		get( list, s ) ; // 不能為null
	}
	
	/**
	 * Create by : 2015年9月2日 上午10:35:46
	 */
	private static void get( ConcurrentSkipListSet< Integer > list, Set< Integer > string )
	{
		list.removeAll( string ) ;
		System.out.println( list.first() ) ;
	}
	
}
