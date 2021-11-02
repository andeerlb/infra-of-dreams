package com.test.helm.demo.repositories;

import com.test.helm.demo.domains.RequisicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<RequisicaoModel, Long> {
}
