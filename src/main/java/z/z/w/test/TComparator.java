package z.z.w.test;

import java.util.Comparator;

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
public class TComparator implements Comparator< String >
{
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare( String s1 , String s2 )
	{
//		List<Step> steps=new ArrayList<Step>;
//	    //对集合对象进行排序
//	    StepComparator comparator=new StepComparator();
//	    Collections.sort(steps, comparator);
		
		return s1.compareTo( s2 );
	}
}
