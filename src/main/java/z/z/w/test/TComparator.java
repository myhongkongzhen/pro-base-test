package z.z.w.test ;

import java.util.Comparator ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.util.TComparator.java
 *         Desc: Comparator接口，算法與數據分離
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月16日 下午2:28:43 
 *   LastChange: 2015年9月16日 下午2:28:43 
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
	public int compare( String o1, String o2 )
	{
		return o1.compareTo( o2 ) ;
	}
	
}
