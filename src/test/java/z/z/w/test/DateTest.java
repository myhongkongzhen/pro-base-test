package z.z.w.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.pro-module
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-09-25 17:29
 *   LastChange: 2015-09-25 17:29
 *      History:
 * </pre>
 **************************************************************************/
public class DateTest
{
	@Test
	public void testDateDiff()
	{
		try
		{
			String startTime = "9:24:04";
			String endTime = "09:25:47";
			
			SimpleDateFormat df = new SimpleDateFormat( "HH:mm:ss" );
			java.util.Date now = df.parse( endTime );
			java.util.Date date = df.parse( startTime );
			long l = now.getTime() - date.getTime();
			long day = l / ( 24 * 60 * 60 * 1000 );
			long hour = ( l / ( 60 * 60 * 1000 ) - day * 24 );
			long min = ( ( l / ( 60 * 1000 ) ) - day * 24 * 60 - hour * 60 );
			long s = ( l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60 );
			System.out.println( day + "day " + hour + "hour " + min + "min" + s + "s" );
		}
		catch ( ParseException e )
		{
			e.printStackTrace();
		}
	}
}
