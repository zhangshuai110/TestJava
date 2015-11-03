package com.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJava {

	public static void main(String[] args) {
		testNullInstanceof();
	}

	/**
	 * 测试当前执行路径和java的正则表达式
	 */
	public static void test1() {
		String userDirStr = System.getProperty("user.dir");
		System.out.println(userDirStr);
		String name = "/jetty-start-test/src/test/resources/jetty home with spaces/modules/base.mod";
		Pattern pat = Pattern.compile(
				"^.*[/\\\\]{1}modules[/\\\\]{1}(.*).mod$",
				Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(name);
		if (!mat.find()) {
			throw new RuntimeException(
					"Invalid Module location (must be located under /modules/ directory): "
							+ name);
		}
		String fileRef = mat.group(1).replace('\\', '/');
		System.out.println(fileRef);
	}

	/**
	 * 测试当一个对象为null时，使用instanceof接口会不会报错
	 */
	public static void testNullInstanceof() {
		Object obj = null;
		if (obj instanceof String) {
			System.out.println("没有报错...");
		} else {
			System.out.println("虽然不成了，但也没有报错...");
		}
	}

}
