package z.z.w.test.aio ;

import java.io.IOException ;
import java.net.InetSocketAddress ;
import java.nio.ByteBuffer ;
import java.nio.channels.AsynchronousChannelGroup ;
import java.nio.channels.AsynchronousServerSocketChannel ;
import java.nio.channels.AsynchronousSocketChannel ;
import java.nio.channels.CompletionHandler ;
import java.util.concurrent.ExecutionException ;
import java.util.concurrent.ExecutorService ;
import java.util.concurrent.Executors ;
import java.util.concurrent.TimeUnit ;
import java.util.concurrent.TimeoutException ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.aio.AioServer.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月21日 上午11:32:16 
 *   LastChange: 2015年9月21日 上午11:32:16 
 *      History:
 * </pre>
 **************************************************************************/
public class AioServer
{
	private final static Logger				logger		= LoggerFactory.getLogger( AioServer.class ) ;
	public final static int					PORT		= 8888 ;
	private final ExecutorService			executor	= Executors.newFixedThreadPool( 20 ) ;
	private AsynchronousChannelGroup		asyncChannelGroup ;										// aio的核心之一通道组.由它负责处理事件,完成之后通知相应的handler
	private AsynchronousServerSocketChannel	server		= null ;										// 端口侦听器
																										
	/**
	 * Create by : 2015年9月21日 上午11:32:35
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		new AioServer().completionHandler() ;
	}
	
	/**
	 * 
	 */
	public AioServer()
	{
		try
		{
			asyncChannelGroup = AsynchronousChannelGroup.withThreadPool( executor ) ;
			server = AsynchronousServerSocketChannel.open( asyncChannelGroup ).bind( new InetSocketAddress( PORT ) ) ;
		}
		catch ( IOException e )
		{
			logger.error( "Aioserver construction error : {}." , e.getMessage() , e ) ;
		}
	}
	
	public void completionHandler()
	{
		logger.info( "Server listen on {}. " , PORT ) ;
		// 注册事件和事件完成后的处理器 ,accepte()完成异步注册后，线程就可以继续自己的处理了，完全不被这个io所中断
		server.accept( null , new CompletionHandler< AsynchronousSocketChannel, Object >()
		{
			final ByteBuffer	buffer	= ByteBuffer.allocate( 1024 ) ;
			
			public void completed( AsynchronousSocketChannel result , Object attachment )
			{
				logger.info( "start thread : {}." , Thread.currentThread().getName() ) ;
				try
				{
					buffer.clear() ;
					result.read( buffer ).get( 100 , TimeUnit.SECONDS ) ;
					buffer.flip() ;
					logger.info( "received message: {}" , new String( buffer.array() ) ) ;
				}
				catch ( InterruptedException | ExecutionException e )
				{
					logger.error( "InterruptedException | ExecutionException error : {}." , e.toString() ) ;
					logger.error( "CompletionHandler error : {}." , e.getMessage() , e ) ;
				}
				catch ( TimeoutException e )
				{
					logger.error( "CompletionHandler error : {}." , e.getMessage() , e ) ;
				}
				finally
				{
					
					try
					{
						result.close() ;
						server.accept( null , this ) ;
					}
					catch ( Exception e )
					{
						logger.error( "CompletionHandler error : {}." , e.getMessage() , e ) ;
					}
				}
				
				logger.info( "end" ) ;
			}
			
			public void failed( Throwable exc , Object attachment )
			{
				logger.info( "failed: " + exc ) ;
			}
			
		} ) ;
		
		// 主线程继续自己的行为
		while ( true )
		{
			try
			{
				Thread.sleep( 1000 ) ;
			}
			catch ( InterruptedException e )
			{}
		}
	}
}
