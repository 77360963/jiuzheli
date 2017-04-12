package www.yunpan.com.utils;

import java.util.Map;




import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {
	
	/**
     * 把JSON String 转换成 Map
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> jsonToMap(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;            
        }
        Map<String, Object> extMap = JSON.parseObject(jsonStr,
            new TypeReference<Map<String, Object>>() {
            });
        return extMap;
    }
   
   
    /**
     * 把JSON String 转换成 Map
     * @param jsonStr
     * @return
     */
    public static Map<String, String> jsonToMapStr(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        Map<String, String> extMap = JSON.parseObject(jsonStr,
            new TypeReference<Map<String, String>>() {
            });
        return extMap;
    }

    /**
     * 把 Map 转换成 JSON String
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map) {
        if(map == null || map.isEmpty()){
            return null;
        }
        return JSON.toJSONString(map, SerializerFeature.UseISO8601DateFormat);
    }

}
