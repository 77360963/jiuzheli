package www.yunpan.com.db;

import www.yunpan.com.entity.FundOrderEntity;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface FundOrderDao {
	
	public int insert(FundOrderEntity fundOrderEntity);
	
	public int updateByPrimaryKeySelective(FundOrderEntity fundOrderEntity);
	
	public PageList<FundOrderEntity> selectFundOrder(FundOrderEntity fundOrderEntity,PageBounds page); 
	

}
