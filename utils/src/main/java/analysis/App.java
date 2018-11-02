package analysis;

public class App {

    private String appName;

    private String host;

    private String pid;

    public App(String appName, String host, String pid) {
        this.appName = appName;
        this.host = host;
        this.pid = pid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "appName:"+this.appName
                +",host:"+this.host
                +",pid:"+this.pid;
    }

}
