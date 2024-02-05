package com.food.unitTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class A {

	@Test
	public void test1() {

		System.out.println("From test1");
	}

	@Test
	public void test2() {

//		int a=10/0;
		System.out.println("From test2");
	}

	@Before
	public void beforeTest() {
		System.out.println("From before test");
	}

	@After
	public void AfterTest() {
		System.out.println("From after test");
	}

	@BeforeClass
	public static  void beforeClass() {
		System.out.println("From before classtest");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("From after classtest");
	}

}
