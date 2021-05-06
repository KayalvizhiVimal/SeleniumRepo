package org.test;

public class TestProgram extends BaseClass{

	public static void main(String[] args) {
		browserLaunch("chrome");
		urlLaunch("http://www.facebook.com/");
		browserMaximize();
		deleteCookies();
		fillValues(findById("email"), "kayalvizhi");
		fillValues(findById("pass"), "kayalvizhi");
		buttonClick(findByName("login"));
	}
	
}
