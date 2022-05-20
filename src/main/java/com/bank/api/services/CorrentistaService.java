package com.bank.api.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.api.dto.correntista.NovoCorrentistaDto;
import com.bank.api.models.Conta;
import com.bank.api.models.Correntista;
import com.bank.api.repositories.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovoCorrentistaDto novoCorrentistaDto) {
		
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentistaDto.getCpf());
		correntista.setNome(novoCorrentistaDto.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		
		correntistaRepository.save(correntista);
		
	}

}
