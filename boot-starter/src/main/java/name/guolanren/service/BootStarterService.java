package name.guolanren.service;

/**
 * @author guolanren
 */
public class BootStarterService {

    private String msg;

    public void printMsg() {
        System.out.println(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
