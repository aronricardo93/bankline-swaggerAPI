package com.bank.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.api.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
