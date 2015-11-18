/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

import java.util.LinkedList;
import java.util.List;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.LinkedListTtest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-18 11:58
 *   LastChange: 2015-11-18 11:58
 *      History:
 * </pre>
 *********************************************************************************************/
public class LinkedListTtest
{
	public static void main( String[] args )
	{
		List<Integer> list = new LinkedList<>();
		/**
		 5
		 4
		 2
		 3
		 */
		list.add( 1 );
		list.add( 2 );
		list.add( 3 );
		list.add( 1, 4 );
		list.add( 33 );
		list.set( 0, 5 );

		for ( Integer i : list )
		{
			System.out.println( i );
		}
	}
}
