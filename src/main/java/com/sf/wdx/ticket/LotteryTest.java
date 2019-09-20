package com.sf.wdx.ticket;

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
 * 描述：Lottery:5[1-35]+2[1-12]
 * @author 80002888
 * @date   2019年9月12日
 */
public class LotteryTest {
	
	@Test
	public void lotTest2(){
		fireLuck(5,
				5, 
				Sets.newHashSet(), 
				2, 
				Sets.newHashSet());
	}
	
	// 28 == 7, 9
	@Test
	public void lotTest1(){
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
	 *  @Param  @param redCount			红数量，>=5
	 *  @Param  @param rp				预选红
	 *  @Param  @param blueCount		蓝数量，>=2
	 *  @Param  @param bp				预选蓝
	 */
	private void fireLuck(int ticketCount, int redCount, Set<Integer> rp, int blueCount, Set<Integer> bp){
		Assert.isTrue(ticketCount >= 1, "ticketCount must >= 1!");
		Assert.isTrue(redCount >= 5, "redCount must >= 5!");
		Assert.isTrue(rp == null || rp.size() <= redCount, "rp size must <= redCount!");
		Assert.isTrue(blueCount >= 2, "blueCount must >= 2!");
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
				// [1, 35]
				redPick.add(new Random().nextInt(35) + 1);
			}
			while (bluePick.size() < blueCount) {
				// [1, 12]
				bluePick.add(new Random().nextInt(12) + 1);
			}
			map.put(redPick, bluePick);
		}
		System.out.println("ticketPrice:" + (calCxy(redCount, 5) * calCxy(blueCount, 2) * ticketCount * 2));
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
	private int calCxy(int x, int y){
		return factorial(x) / (factorial(y) * factorial(x-y));
	}
	
	/**
	 * 计算阶乘
	 *	@ReturnType	int 
	 *	@Date	2019年9月12日	下午2:08:22
	 *  @Param  @param x
	 *  @Param  @return
	 */
	private int factorial(int x){
		int y = 1;
		for (int i = 1; i <= x; i++) {
			y = y * i;
		}
		return y;
	}
	
}
