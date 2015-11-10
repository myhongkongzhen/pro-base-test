/**********************************************************************************************************************
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.                                       *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.                        *
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.                                                   *
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.                     *
 * Vestibulum commodo. Ut rhoncus gravida arcu.                                                                       *
 **********************************************************************************************************************/

package z.z.w.test;

import org.junit.Test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/*********************************************************************************************
 * <pre>
 *     FileName: z.z.w.test.TestString
 *         Desc:
 *       author: Z_Z.W - myhongkongzhen@gmail.com
 *      version: 2015-11-06 14:05
 *   LastChange: 2015-11-06 14:05
 *      History:
 * </pre>
 *********************************************************************************************/
public class TestString
{

	@Test
	public void testStr() throws Exception
	{

		String sou
				= "{\"SingleSMSRequest\":{\"SingleSMSRequest\":{\"UserID\":\"10040001\",\"TPLID\":\"1000\",\"MSMSID\":\"97ea6b7165dc423a9bd7c19d53600d3d\",\"StampTime\":\"2015-11-06T12:30:05\",\"SMSText\":\"您好：您的注册码是460【技AHDX】\"\",\"Sign\":\"57f8e2a6b58ad093c681b082ad3599bc\",\"ObjMobile\":\"15098648522\"}}}";
		String encode = URLEncoder.encode( sou, "utf-8" );
//		System.out.println( encode );

//		System.out.println( URLDecoder.decode( encode, "utf-8" ) );

		sou = "%E6%82%A8%E5%A5%BD%EF%BC%9A%E6%82%A8%E7%9A%84%E6%B3%A8%E5%86%8C%E7%A0%81%E6%98%AF7773%E3%80%90%E6%8A%80FXYD%E3%80%91%22";
//		System.out.println( URLDecoder.decode( sou, "utf-8" ) );

		sou
				= "%E9%AA%8C%E8%AF%81%E7%A0%817662%EF%BC%8C%E6%AC%A2%E8%BF%8E%E4%BD%BF%E7%94%A83G%E4%BA%A7%E5%93%81%EF%BC%81%E3%80%90%E5%87%BA%E4%BC%97%E7%BD%91%E7%BB%9C%E3%80%91";
		System.out.println( URLDecoder.decode( sou, "utf-8" ) );
	}
}
