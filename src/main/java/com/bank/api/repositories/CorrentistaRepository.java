package com.bank.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.api.models.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer>{

}
