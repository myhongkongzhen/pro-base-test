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
 *     FileName: z.z.w.test.IntegerTest
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-17 15:35
 *   LastChange: 2015-12-17 15:35
 *      History:
 * </pre>
 *********************************************************************************************/
public class IntegerTest
{
    public static void main( String[] args )
    {

        int i = 12;

        i |= ( i >> 1 ); // 2-0
        System.out.println( i );
        i |= ( i >> 2 ); // 2-1
        System.out.println( i );
        i |= ( i >> 4 ); // 2-2
        System.out.println( i );
        i |= ( i >> 8 ); // 2-3
        System.out.println( i );
        i |= ( i >> 16 ); // 2-4
        System.out.println( i );
        int j = ( i >>> 1 );
        System.out.println( j );
        System.out.println( i - j );
    }
}