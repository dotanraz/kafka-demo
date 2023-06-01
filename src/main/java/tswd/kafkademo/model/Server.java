package tswd.kafkademo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Server")
public class Server {
    public Server() {
    }

    public Server(String ip, String os, String osVersion) {
        this.ip = ip;
        this.os = os;
        this.osVersion = osVersion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "os_type")
    private String os;

    @Column(name = "os_version")
    private String osVersion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                '}';
    }
}
