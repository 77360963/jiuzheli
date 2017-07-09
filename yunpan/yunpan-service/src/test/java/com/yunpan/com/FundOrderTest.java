package com.yunpan.com;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import www.yunpan.com.db.FundOrderDao;
import www.yunpan.com.entity.FundOrderEntity;
import www.yunpan.com.service.FundOrderService;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public class FundOrderTest extends BaseTest{
	
	@Resource
	private FundOrderDao fundOrderDao;
	
	@Autowired
	private FundOrderService fundOrderService;
	
	
	@Test
    public void addFundOrder() throws Exception{
		for(int i=0;i<1000;i++){
			FundOrderEntity entity=new FundOrderEntity();
			entity.setOrderId("order"+i);
			entity.setOrderName("基金订单"+i);
			entity.setOrderVersion("0");
			fundOrderDao.insert(entity);
		}
		
		
	}
	@Test
    public void updateFundOrder() throws Exception{
		FundOrderEntity entity=new FundOrderEntity();
		entity.setOrderId("e112");
		entity.setOrderName("tttttttttt");
		entity.setOrderVersion("0");
		fundOrderDao.updateByPrimaryKeySelective(entity);
		
	}
	
	
	@Test
    public void selectFundOrder() throws Exception{
		FundOrderEntity entity=new FundOrderEntity();	
		PageBounds pb=new PageBounds();
		pb.setPage(1);
		pb.setLimit(10);
		PageList<FundOrderEntity> pageInfo=fundOrderDao.selectFundOrder(entity,pb);
		for(FundOrderEntity e:pageInfo){
			System.out.println(e.getOrderId()+"--"+e.getOrderName()+"--"+e.getOrderVersion());
		}
		
	}
	
	
	@Test
    public void selectFundOrderPage() throws Exception{
		int pageNum=1;
		FundOrderEntity entity=new FundOrderEntity();
		PageBounds pb=new PageBounds();
		pb.setLimit(1);
		while(true){
			pb.setPage(pageNum);
			PageList<FundOrderEntity> pageInfo=fundOrderDao.selectFundOrder(entity,pb);			
			if(pageInfo!=null && pageInfo.size()>0){
				System.out.println("第："+pageNum+"页");
			}else{				
				break;
			}
			pageNum++;			
			
		}
		
	}
	
	@Test
	public void Test1(){
		int pageNum=1;
		FundOrderEntity entity=new FundOrderEntity();
		PageBounds pb=new PageBounds();
		pb.setLimit(1000);
		while(true){
			pb.setPage(pageNum);
			PageList<FundOrderEntity> pageInfo=fundOrderDao.selectFundOrder(entity,pb);			
			if(pageInfo!=null && pageInfo.size()>0){
				fundOrderService.ThreadUpdateOrder(pageInfo);
			}else{				
				break;
			}
			pageNum++;			
			
		}
		
	}

}
