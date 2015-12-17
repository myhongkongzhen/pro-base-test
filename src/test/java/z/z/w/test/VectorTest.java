/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

import java.util.*;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.VectorTest
 *         Desc: 線程安全存在問題，要自行加鎖Vector不能完全保證
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-12-17 11:44
 *   LastChange: 2015-12-17 11:44
 *      History:
 * </pre>
 *********************************************************************************************/
public class VectorTest
{
    public static Vector< Integer > vector = new Vector< Integer >();

    public static void main( String[] args )
    {
        try
        {
            while ( true )
            {
                for ( int i = 0; i < 10; i++ )
                {
                    vector.add( i );
                }

                Thread.sleep( 50 );

                Thread removeThread = new Thread( new Runnable()
                {

                    @Override
                    public void run()
                    {
                        for ( int i = 0; i < vector.size(); i++ )
                        {
                            vector.remove( i );
                        }
                    }
                } );

                Thread printThread = new Thread( new Runnable()
                {

                    @Override
                    public void run()
                    {
                        for ( int i = 0; i < 10; i++ )
                        {
                            System.out.println( vector.get( i ) );
                        }
                    }
                } );

                removeThread.start();
                printThread.start();

                while ( Thread.activeCount() > 20 )
                    ;
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}