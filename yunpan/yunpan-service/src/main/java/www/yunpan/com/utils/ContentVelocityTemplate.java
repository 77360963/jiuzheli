package www.yunpan.com.utils;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class ContentVelocityTemplate {
	/** 注入引擎*/
    private VelocityEngine velocityEngine;

    /** 编码*/
    private String         encoding;

    /** vm 模板路径 */
    private String         vmLocation;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String getContent(Map prepareData) {

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, getVmLocation(),
            encoding, prepareData);
    }

    public String getContent() {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, getVmLocation(),
            encoding, null);
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setVmLocation(String vmLocation) {
        this.vmLocation = vmLocation;
    }

    public String getVmLocation() {
        return this.vmLocation;
    }
}
