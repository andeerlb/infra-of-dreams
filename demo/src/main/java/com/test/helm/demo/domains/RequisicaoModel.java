package com.test.helm.demo.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "requisicao")
public class RequisicaoModel implements Serializable {
    private static final long serialVersionUID = 8303550595770965696L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "server_name")
    private String serverName;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "ip")
    private String ip;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "k8s_svc_name")
    private String k8sSvcName;

    public RequisicaoModel() {
    }

    public RequisicaoModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getK8sSvcName() {
        return k8sSvcName;
    }

    public void setK8sSvcName(String k8sSvcName) {
        this.k8sSvcName = k8sSvcName;
    }
}
