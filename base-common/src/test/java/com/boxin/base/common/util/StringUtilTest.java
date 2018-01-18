package com.boxin.base.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * StringUtil 简单测试
 */
public class StringUtilTest {

	@Test
	public void testAll(){

		String email1 = "551996458@qq.com";
		boolean isEmail1 = StringUtil.isEmail(email1);

		String email2 = "aaa@qq.a";
		boolean isEmail2 = StringUtil.isEmail(email2);

		String phone1 = "+8618614234509";
		boolean isPhone1 = StringUtil.isPhone(phone1);

		String phone2 = "(+86)18614234509";
		boolean isPhone2 = StringUtil.isPhone(phone2);

		String long1 = "+123";
		boolean isLong1 = StringUtil.isLong(long1);
		//
		Assert.assertTrue("测试未通过: " + email1, isEmail1);
		Assert.assertTrue("测试未通过: " + email2, isEmail2);
		Assert.assertTrue("测试未通过: " + phone1, isPhone1);
		Assert.assertTrue("测试未通过: " + long1, isLong1);
	}
}
