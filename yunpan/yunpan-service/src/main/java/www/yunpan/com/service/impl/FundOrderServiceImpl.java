package www.yunpan.com.service.impl;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import www.yunpan.com.db.FundOrderDao;
import www.yunpan.com.entity.FundOrderEntity;
import www.yunpan.com.service.FundOrderService;

@Service
public class FundOrderServiceImpl implements FundOrderService {
	
	@Autowired
	private FundOrderDao fundOrderDao; 

	private ExecutorService executor = Executors.newFixedThreadPool(10);

	private static final int MAX_DEAL = 50;

	public void ThreadUpdateOrder(List<FundOrderEntity> list) {

		if (list == null || list.isEmpty()) {
			return;
		}

		int times = (list.size() + MAX_DEAL - 1) / MAX_DEAL;
		CountDownLatch countDownLatch = new CountDownLatch(times);
	    // 创建一个计时器
        StopWatch watch = new StopWatch();
        watch.start();
		long startTime=System.currentTimeMillis();   //获取开始时间 

		try {			
			
		   for (int i = 0; i < times; i++) {
				if (i == times - 1) {
					executor.execute(new addListRunnable(list.subList(i* MAX_DEAL, list.size()), countDownLatch));
				} else {
					executor.execute(new addListRunnable(list.subList(i* MAX_DEAL, (i + 1) * MAX_DEAL), countDownLatch));
				}
			}
			countDownLatch.await();// 一个线程(或者多个)， 等待另外N个线程完成某个事情之后才能执行
	} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 watch.stop();			
		     long endTime=System.currentTimeMillis(); //获取结束时间  
		     System.out.println("上传文件共使用时间："+watch.getTotalTimeSeconds()+"最后得"+(endTime-startTime));  
		}

	}

	private class addListRunnable implements Runnable {

		private List<FundOrderEntity> list;

		private CountDownLatch countDownLatch;

		public addListRunnable(List<FundOrderEntity> list,
				CountDownLatch countDownLatch) {
			super();
			this.list = list;
			this.countDownLatch = countDownLatch;
		}

		public void run() {
			try {
				for (FundOrderEntity entity : list) {
					entity.setOrderVersion("1");
					fundOrderDao.updateByPrimaryKeySelective(entity);
					System.out.println("线程名"+Thread.currentThread().getName()+"执行"+entity.getOrderId());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				countDownLatch.countDown();
			}

		}

	}

}
