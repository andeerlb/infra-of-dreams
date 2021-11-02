package com.test.helm.demo.controllers;

import com.test.helm.demo.domains.RequisicaoModel;
import com.test.helm.demo.services.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/requisicoes")
public class RequisicaoController {

    @Autowired
    private RequisicaoService service;

    @PostMapping(value = "/update")
    public ResponseEntity<RequisicaoModel> addRquisicao(HttpServletRequest request, @RequestBody RequisicaoModel req) {
        return ResponseEntity.ok(service.update(request, req));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<RequisicaoModel>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "/requisicao")
    public ResponseEntity<RequisicaoModel> requisicao(HttpServletRequest request) {
        return ResponseEntity.ok(service.requisicao(request));
    }
}
