package com.tests;

import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends LoginPage {

	@Test
	public void test1() {

		loginPage();
		System.out.println("Login Test");
	}

}
