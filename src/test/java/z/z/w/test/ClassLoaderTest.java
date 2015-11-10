/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.ClassLoaderTest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-11 11:09
 *   LastChange: 2015-11-11 11:09
 *      History:
 * </pre>
 *********************************************************************************************/
public class ClassLoaderTest
{
	public static void main( String[] args )
	{
		System.out.println( "sun.boot.class.path:" + System.getProperty( "sun.boot.class.path" ) );

		System.out.println( "java.ext.dirs:" + System.getProperty( "java.ext.dirs" ) );

		System.out.println( "java.class.path:" + System.getProperty( "java.class.path" ) );

		ClassLoader cl = Thread.currentThread().getContextClassLoader();//ClassLoader.getSystemClassLoader()

		System.out.println( "getContextClassLoader:" + cl.toString() );

		System.out.println( "getContextClassLoader.parent:" + cl.getParent().toString() );

		System.out.println( "getContextClassLoader.parent2:" + cl.getParent().getParent() );
	}
}
