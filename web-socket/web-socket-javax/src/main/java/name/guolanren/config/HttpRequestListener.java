package name.guolanren.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guolanren
 */
public class HttpRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ((HttpServletRequest) sre.getServletRequest()).getSession();
    }
}
