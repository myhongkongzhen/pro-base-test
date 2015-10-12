package z.z.w.test.aio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.aio.AioClient.java
 *         Desc: 
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015年9月21日 上午11:57:10
 *   LastChange: 2015年9月21日 上午11:57:10 
 *      History:
 * </pre>
 **************************************************************************/
public class AioClient
{
	private final static Logger logger = LoggerFactory.getLogger( AioClient.class );
	
	/**
	 * Create by : 2015年9月21日 上午11:57:10
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		try
		{
			AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
			client.connect( new InetSocketAddress( "127.0.0.1" , 8888 ) );
			client.write( ByteBuffer.wrap( "你好jflkdsfjlskdjflasjfksajlfdsjlkfjsdlkfjlsakd".getBytes() ) ).get();
		}
		catch ( IOException | InterruptedException | ExecutionException e )
		{
			logger.error( "IOException | InterruptedException | ExecutionException error : {}." , e.toString() );
			logger.error( "AioClient error : {}." , e.getMessage() , e );
		}
	}
}
