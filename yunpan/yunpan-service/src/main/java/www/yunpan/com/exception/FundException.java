package www.yunpan.com.exception;

public class FundException extends BaseException {	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FundException(String errorCode, String errorMsg, Throwable caused) {
        super(errorCode, errorMsg, caused);
       
   }

   public FundException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);         
   }

   public FundException(String errorCode, Throwable caused) {
        super(errorCode, caused);         
   }
	
	
   
}
