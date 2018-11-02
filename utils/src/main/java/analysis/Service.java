package analysis;

public class Service implements Comparable {

    private String serviceName;

    private String type;

    private String host;

    private String port;

    private String pid;


    public Service(String serviceName, String type, String host, String port, String pid) {
        this.serviceName = serviceName;
        this.type = type;
        this.host = host;
        this.port = port;
        this.pid = pid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return
                "serviceName:"+serviceName+
                ",type:"+type+
                ",host:"+host+
                ",port:"+port+
                ",pid:"+pid;
    }

//    @Override
//    public int compareTo(Object o) {
//        String port = ((Service) o).getPort();
//        int iport = Integer.parseInt(port);
//        int aport = Integer.parseInt(this.port);
//        if (iport>aport)
//            return 1;
//        if (iport==aport)
//            return 0;
//        return -1;
//    }


    @Override
    public int compareTo(Object o) {
        int i = ((Service) o).getHost().compareTo(this.getHost());
        if (i==0){
            return ((Service) o).getPid().compareTo(this.getPid());
        }else
            return i;
    }
}
