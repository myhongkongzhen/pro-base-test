/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

import org.apache.commons.lang3.StringUtils;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.StringTest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-17 14:15
 *   LastChange: 2015-11-17 14:15
 *      History:
 * </pre>
 *********************************************************************************************/
public class StringTest
{
	public static void main( String[] args )
	{
		String result = "success:fe2b4a0c08414142a43a56e0ae63a26c1:";
//		String result = "success:15098648522:fe2b4a0c08414142a43a56e0ae63a26c1.";
//		System.out.println( StringUtils.containsIgnoreCase( "success", result ) );

//		System.out.println( StringUtils.contains( "success", result ) );
		System.out.println( StringUtils.containsAny( "success", result ) );
//		System.out.println( StringUtils.containsNone( "success", result ) );
		System.out.println( StringUtils.containsOnly( "success", result ) );

		String[] split = StringUtils.splitByWholeSeparatorPreserveAllTokens( result,":"  );
		System.out.println(split.length);
		for ( String s : split )
		{
			System.out.println(s);
		}

	}
}
