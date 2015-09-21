package z.z.w.test ;

import java.util.Random ;

import org.junit.Ignore ;
import org.junit.Test ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.RandomTest.java
 *         Desc: 直接调用Math.random()是产生一个[0，1）之间的随机数,
 *               new Random();random.nextInt() 
 *               这样产生一个长整型的随机数并且与上一次是一样的
 *               一般最好用nextInt(范围)的，如果不是大量的运算的话，
 *               就可以用Math.random了，因为他可以运算起来慢一些，浮点之后再取整
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月17日 下午2:50:01 
 *   LastChange: 2015年9月17日 下午2:50:01 
 *      History:
 * </pre>
 **************************************************************************/
public class RandomTest
{
	/**
	 * 指定範圍內的隨機數
	 * Create by : 2015年9月17日 下午2:51:23
	 */
	@Test
	@Ignore
	public void testRandom()
	{
		int max = 9999 ;
		int min = 1000 ;
		Random random = new Random() ;
		
		while ( true )
		{
			int s = random.nextInt( max ) % ( max - min + 1 ) + min ;
			System.out.println( s ) ;
		}
	}
	
	/**
	 * 产生机制：
	 * 产生Min-Max之间的数字
	 * 实现原理：
	 * Math.round(Math.random()*(Max-Min)+Min)
	 * long Temp; //不能设定为int,必须设定为long
	 * //产生1000到9999的随机数
	 * Temp=Math.round(Math.random()*8999+1000);
	 * Create by : 2015年9月17日 下午2:57:26
	 */
	@Test
//	@Ignore
			public void
			testRandom0()
	{
//		  Math.round(Math.random()*(Max-Min)+Min)
		while ( true )
		{
			long rannum = Math.round( Math.random() * ( 9999999999l - 100000000l ) + 100000000l ) ;
//			long rannum = Math.round( Math.random() * ( 9999 - 1000 ) + 1000 ) ;
			System.out.println( rannum ) ;
		}
	}
	
	@Test
	@Ignore
	public void testRandom1()
	{
		Random random = new Random() ;
		while ( true )
		{
			int rannum = ( int ) ( random.nextDouble() * ( 9999 - 1000 + 1000 ) + 1000 ) ;
			System.out.println( rannum ) ;
		}
	}
	
	@Test
	@Ignore
	public void testRandom2()
	{
		Random random = new Random( System.currentTimeMillis() ) ;
		while ( true )
		{
//			int rannum = ( int ) ( random.nextDouble() * ( 9999 - 1000 + 1000 ) ) ;
			int rannum = random.nextInt( 200 ) ;
			System.out.println( rannum ) ;
		}
	}
	
	@Test
	@Ignore
	public void testRandom3()
	{	
		
//		java.util.concurrent.ThreadLocalRandom.current().nextInt(10)
//		while ( true )
//		{
//		int rannum = ( int ) ( random.nextDouble() * ( 9999 - 1000 + 1000 ) ) ;
//			int rannum = random.nextInt( 200 ) ;
//			System.out.println( rannum ) ;
//		}
	}
}
