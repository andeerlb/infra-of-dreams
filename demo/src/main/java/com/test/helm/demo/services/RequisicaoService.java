package com.test.helm.demo.services;

import com.test.helm.demo.domains.RequisicaoModel;
import com.test.helm.demo.repositories.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

@Service
public class RequisicaoService {
    @Value("${server.name}")
    private String serverName;

    @Value("${k8s.service.name}")
    private String k8sServiceName;

    @Autowired
    private RequisicaoRepository repo;

    @Cacheable(cacheNames = "requisicao", key="#root.method.name")
    public List<RequisicaoModel> findAll() {
        return repo.findAll();
    }

    @CachePut(cacheNames = "requisicao", key="#requisicao.getId()")
    public RequisicaoModel update(HttpServletRequest request, RequisicaoModel requisicao) {

        requisicao.setRequestDate(new Date());
        requisicao.setIp(request.getRemoteAddr());
        requisicao.setServerName(this.serverName);
        requisicao.setK8sSvcName(this.k8sServiceName);

        try {
            requisicao.setHostname(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return repo.save(requisicao);
    }

    @CacheEvict(cacheNames = "requisicao", key="#id")
    public RequisicaoModel delete(Long id) {
        return repo.save(new RequisicaoModel(id));
    }

    @CacheEvict(cacheNames = "requisicao", allEntries = true)
    public RequisicaoModel requisicao(HttpServletRequest request) {
        RequisicaoModel model = new RequisicaoModel();

        model.setRequestDate(new Date());
        model.setIp(request.getRemoteAddr());
        model.setServerName(this.serverName);
        model.setK8sSvcName(this.k8sServiceName);

        try {
            model.setHostname(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return repo.save(model);
    }
}
