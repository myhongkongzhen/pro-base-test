package z.z.w.test.random ;

import java.util.Random ;
import java.util.concurrent.CountDownLatch ;
import java.util.concurrent.ThreadLocalRandom ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.random.RandomTaskTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月23日 下午6:17:41 
 *   LastChange: 2015年9月23日 下午6:17:41 
 *      History:
 * </pre>
 **************************************************************************/
public class RandomTaskTest
{
	private static final long	COUNT	= 100000000 ;
	private static final int	THREADS	= 100 ;
	
	/**
	 * Create by : 2015年9月23日 下午6:17:41
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		/**
		 * Thread #1 Time = 0.581 sec, sum = 1488041860
		 * Thread #0 Time = 0.584 sec, sum = -1385865074
		 */
//		System.out.println( "Shared Random" ) ;
//		testRandom( THREADS , COUNT ) ;
		
		/*
		 * Thread #1 Time = 0.117 sec, sum = 2024089153
		 * Thread #0 Time = 0.12 sec, sum = 2024089153
		 */
//		System.out.println( "ThreadLocal<Random>" ) ;
//		testTL_Random( THREADS , COUNT ) ;
		
		/**
		 * 多線程下性能最優
		 * Thread #1 Time = 0.022 sec, sum = -683672660
		 * Thread #0 Time = 0.022 sec, sum = 1402881282
		 */
		System.out.println( "ThreadLocalRandom" ) ;
		testTLRandom( THREADS , COUNT ) ;

		/**
		 * Thread #0 Time = 0.116 sec, sum = 2024089153
		 * Thread #1 Time = 0.12 sec, sum = 2024089153
		 */
//		System.out.println( "Shared Random[] with no padding" ) ;
//		testRandomArray( THREADS , COUNT , 1 ) ;
		
		/**
		 * Thread #0 Time = 0.117 sec, sum = 2024089153
		 * Thread #1 Time = 0.119 sec, sum = 2024089153
		 */
//		System.out.println( "Shared Random[] with padding" ) ;
//		testRandomArray( THREADS , COUNT , 2 ) ;
	}
	
	//runner for all tests
	private static class RandomTask implements Runnable
	{
		private final Random			rnd ;
		protected final int				id ;
		private final long				cnt ;
		private final CountDownLatch	latch ;
		
		private RandomTask( Random rnd , int id , long cnt , CountDownLatch latch )
		{
			this.rnd = rnd ;
			this.id = id ;
			this.cnt = cnt ;
			this.latch = latch ;
		}
		
		protected Random getRandom()
		{
			return rnd ;
		}
		
		@Override
		public void run()
		{
			try
			{
				final Random r = getRandom() ;
				latch.countDown() ;
				latch.await() ;
				final long start = System.currentTimeMillis() ;
				int sum = 0 ;
				for ( long j = 0 ; j < cnt ; ++j )
				{
					sum += r.nextInt() ;
				}
				final long time = System.currentTimeMillis() - start ;
				System.out.println( "Thread #" + id + " Time = " + time / 1000.0 + " sec, sum = " + sum ) ;
			}
			catch ( InterruptedException e )
			{}
		}
	}
	
	private static void testRandom( final int threads , final long cnt )
	{
		final CountDownLatch latch = new CountDownLatch( threads ) ;
		final Random r = new Random( 100 ) ;
		for ( int i = 0 ; i < threads ; ++i )
		{
			final Thread thread = new Thread( new RandomTask( r , i , cnt , latch ) ) ;
			thread.start() ;
		}
	}
	
	private static void testRandomArray( final int threads , final long cnt , final int padding )
	{
		final CountDownLatch latch = new CountDownLatch( threads ) ;
		final Random[] rnd = new Random[ threads * padding ] ;
		for ( int i = 0 ; i < threads * padding ; ++i )
			//allocate together
			rnd[ i ] = new Random( 100 ) ;
		for ( int i = 0 ; i < threads ; ++i )
		{
			final Thread thread = new Thread( new RandomTask( rnd[ i * padding ] , i , cnt , latch ) ) ;
			thread.start() ;
		}
	}
	
	private static void testTLRandom( final int threads , final long cnt )
	{
		final CountDownLatch latch = new CountDownLatch( threads ) ;
		for ( int i = 0 ; i < threads ; ++i )
		{
			final Thread thread = new Thread( new RandomTask( null , i , cnt , latch )
			{
				@Override
				protected Random getRandom()
				{
					return ThreadLocalRandom.current() ;
				}
			} ) ;
			thread.start() ;
		}
	}
	
	private static void testTL_Random( final int threads , final long cnt )
	{
		final CountDownLatch latch = new CountDownLatch( threads ) ;
		final ThreadLocal< Random > rnd = new ThreadLocal< Random >()
		{
			@Override
			protected Random initialValue()
			{
				return new Random( 100 ) ;
			}
		} ;
		for ( int i = 0 ; i < threads ; ++i )
		{
			final Thread thread = new Thread( new RandomTask( null , i , cnt , latch )
			{
				@Override
				protected Random getRandom()
				{
					return rnd.get() ;
				}
			} ) ;
			thread.start() ;
		}
	}
}
