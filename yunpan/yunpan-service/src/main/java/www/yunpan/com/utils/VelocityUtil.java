package www.yunpan.com.utils;

import java.util.Map;

public class VelocityUtil {
	/**
     * 生成请求
     * @param template 模板
     * @param params 参数
     * @return
     */
     public static String getXmlData(ContentVelocityTemplate template,Map<String,Object> params){          
          // 产生xml字符串
          return template.getContent(params);
     }
}
