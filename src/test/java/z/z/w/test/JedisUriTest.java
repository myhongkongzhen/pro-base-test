/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

import org.junit.Test;

import java.net.URI;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.JedisUriTest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-03 14:49
 *   LastChange: 2015-11-03 14:49
 *      History:
 * </pre>
 *********************************************************************************************/
public class JedisUriTest
{
	private static final int DEFAULT_DB = 0;

	@Test public void testUri() throws Exception
	{

		URI uri = new URI( "http://113.31.87.156:6399/2123" );

		String[] pathSplit = uri.getPath().split( "/", 2 );
		if ( pathSplit.length > 1 )
		{
			String dbIndexStr = pathSplit[ 1 ];
			if ( dbIndexStr.isEmpty() )
			{
				System.out.println( DEFAULT_DB );
			}
			System.out.println( Integer.parseInt( dbIndexStr ) );
		}
		else
		{
			System.out.println( DEFAULT_DB );
		}

	}
}
