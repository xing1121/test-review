package com.sf.wdx.ticket;

import org.junit.Test;

/**
 * 描述：存款与贷款
 * @author 80002888
 * @date   2019年9月20日
 */
public class DepositAndWithdrawTest {

	/**
	 * 存款
	 *	@ReturnType	void 
	 *	@Date	2019年9月20日	上午10:20:26
	 *  @Param
	 */
	@Test
	public void saveTest1(){
		double monthRate = 0.005D;
		double monthMoney = 4916.666666666667D;
		int monthCount = 36;
		double totalMoney = 0D;
		for (int i = 0; i < monthCount; i++) {
			totalMoney = totalMoney * (1 + monthRate) + monthMoney;
		}
		System.out.println(totalMoney);
	}
	
	/**
	 * 信用贷款
	 *	@ReturnType	void 
	 *	@Date	2019年9月20日	上午10:20:31
	 *  @Param
	 */
	@Test
	public void lendTest1(){
		double handRate = 0.03;
		double monthRate = 0.005;
		double baseMoney = 150000;
		double totalMoney = 150000;
		
		double handMoney = totalMoney * handRate;
		int monthCount = 36;
		
		for (int i = 0; i < monthCount; i++) {
			totalMoney = totalMoney + baseMoney * monthRate;
		}
		System.out.println(totalMoney / 36);
		System.out.println(totalMoney);
		System.out.println(totalMoney + handMoney);
	}
	
}
