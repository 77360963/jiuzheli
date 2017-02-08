package www.yunpan.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.yunpan.com.db.FundCalendarDao;
import www.yunpan.com.entity.FundCalendar;
import www.yunpan.com.service.FundCalendarService;

@Service
public class FundCalendarServiceImpl implements FundCalendarService {
	
	@Autowired
	private FundCalendarDao fundCalendarDao;

	public List<FundCalendar> queryFundCalendar() {
		return fundCalendarDao.queryFundCalendar();
	}

}
