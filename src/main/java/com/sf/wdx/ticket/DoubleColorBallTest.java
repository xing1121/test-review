package com.sf.wdx.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

import cn.hutool.core.lang.Assert;

/**
 * 描述：DoubleColorBall:6[1-33]+1[1-16]
 * @author 80002888
 * @date   2019年9月12日
 */
public class DoubleColorBallTest {
	
	@Test
	public void dcbTest2(){
		fireLuck(1,
				33, 
				Sets.newHashSet(), 
				1, 
				Sets.newHashSet());
	}
	
	// 28 == 7, 9
	@Test
	public void dcbTest1(){
		fireLuck(1,
				6, 
				Sets.newHashSet(28), 
				2, 
				Sets.newHashSet(7, 9));
	}
	
	/**
	 * 开启幸运
	 *	@ReturnType	void 
	 *	@Date	2019年9月12日	下午2:19:22
	 *  @Param  @param ticketCount		数量
	 *  @Param  @param redCount			红数量，>=6
	 *  @Param  @param rp				预选红
	 *  @Param  @param blueCount		蓝数量，>=6
	 *  @Param  @param bp				预选蓝
	 */
	private void fireLuck(int ticketCount, int redCount, Set<Integer> rp, int blueCount, Set<Integer> bp){
		Assert.isTrue(ticketCount >= 1, "ticketCount must >= 1!");
		Assert.isTrue(redCount >= 6, "redCount must >= 6!");
		Assert.isTrue(rp == null || rp.size() <= redCount, "rp size must <= redCount!");
		Assert.isTrue(blueCount >= 1, "blueCount must >= 1!");
		Assert.isTrue(bp == null || bp.size() <= blueCount, "bp size must <= blueCount!");
		Map<Set<Integer>, Set<Integer>> map = new HashMap<>();
		while (map.size() < ticketCount) {
			Set<Integer> redPick = new HashSet<>();
			if (rp != null) {
				redPick.addAll(rp);
			}
			Set<Integer> bluePick = new HashSet<>();
			if (bp != null) {
				bluePick.addAll(bp);
			}
			while (redPick.size() < redCount) {
				// [1, 33]
				redPick.add(new Random().nextInt(33) + 1);
			}
			while (bluePick.size() < blueCount) {
				// [1, 16]
				bluePick.add(new Random().nextInt(16) + 1);
			}
			map.put(redPick, bluePick);
		}
		System.out.println("ticketPrice:" + (calCxy(redCount, 6).multiply(calCxy(blueCount, 1)).multiply(new BigDecimal(ticketCount * 2))));
		System.out.println("rate:" + (calCxy(redCount, 6).multiply(calCxy(blueCount, 1))).divide(calCxy(33, 6).multiply(calCxy(16, 1)), 10, RoundingMode.HALF_UP));
		Set<Entry<Set<Integer>, Set<Integer>>> entrySet = map.entrySet();
		for (Entry<Set<Integer>, Set<Integer>> entry : entrySet) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
	}
	
	/**
	 * 计算Cxy（x>=y）
	 *	@ReturnType	int 
	 *	@Date	2019年9月12日	下午2:08:51
	 *  @Param  @param x
	 *  @Param  @param y
	 *  @Param  @return
	 */
	private BigDecimal calCxy(int x, int y){
		BigDecimal fson = factorial(x);
		BigDecimal fmother = (factorial(y).multiply(factorial(x-y)));
		return fson.divide(fmother, 2, RoundingMode.HALF_UP);
	}
	
	/**
	 * 计算阶乘
	 *	@ReturnType	int 
	 *	@Date	2019年9月12日	下午2:08:22
	 *  @Param  @param x
	 *  @Param  @return
	 */
	private BigDecimal factorial(int x){
		BigDecimal y = new BigDecimal(1);
		for (int i = 1; i <= x; i++) {
			y = y.multiply(new BigDecimal(i));
		}
		return y;
	}
	
}
