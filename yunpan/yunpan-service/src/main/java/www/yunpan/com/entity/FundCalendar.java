package www.yunpan.com.entity;

import java.util.Date;

public class FundCalendar {
    private String calendarId;

    private String curDate;

    private String profitDate;

    private Date createTime;

    private String memo;

    private String isHoliday;

    private String accountBeginDate;

    private String accountEndDate;

    private String transArrDateBuy;

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId == null ? null : calendarId.trim();
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate == null ? null : curDate.trim();
    }

    public String getProfitDate() {
        return profitDate;
    }

    public void setProfitDate(String profitDate) {
        this.profitDate = profitDate == null ? null : profitDate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(String isHoliday) {
        this.isHoliday = isHoliday == null ? null : isHoliday.trim();
    }

    public String getAccountBeginDate() {
        return accountBeginDate;
    }

    public void setAccountBeginDate(String accountBeginDate) {
        this.accountBeginDate = accountBeginDate == null ? null : accountBeginDate.trim();
    }

    public String getAccountEndDate() {
        return accountEndDate;
    }

    public void setAccountEndDate(String accountEndDate) {
        this.accountEndDate = accountEndDate == null ? null : accountEndDate.trim();
    }

    public String getTransArrDateBuy() {
        return transArrDateBuy;
    }

    public void setTransArrDateBuy(String transArrDateBuy) {
        this.transArrDateBuy = transArrDateBuy == null ? null : transArrDateBuy.trim();
    }
}