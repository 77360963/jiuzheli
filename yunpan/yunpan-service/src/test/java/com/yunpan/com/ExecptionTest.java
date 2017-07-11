package com.yunpan.com;

import www.yunpan.com.exception.FundException;

public class ExecptionTest {
	
	public static void add() throws FundException{
		throw new FundException("123","错误");
	}
	
	public static void main(String[] args) {
		try {
			ExecptionTest.add();
		} catch (FundException e) {
			System.out.println(e.getMessage()+e.getErrorCode());
		}
	}

}
