package name.guolanren.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author guolanren
 */
@ConfigurationProperties(prefix = "boot.starter")
public class StarterProperties {

    private String msg = "Hello Hell";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
