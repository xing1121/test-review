package com.sf.wdx.money;

public class TestMoney {

	public static void main(String[] args) {
		double x1 = calculate(150000, (2.8)/100, 6000.0, 24);
		System.out.println(x1);
	}
	
	/**
	 * 计算本息
	 * @param rate		年利率rate
	 * @param salary	每月存salary元钱
	 * @param month		存month个月
	 * @return			本息共x元
	 */
	public static double calculate(double initTotal, double rate, double salary, int month){
		double monthRate = rate / 12;
		double total = initTotal;
		for (int i = 0; i < month; i++) {
			total = total * (1 + monthRate);
			total += salary;
		}
		return total;
	}
	
}
