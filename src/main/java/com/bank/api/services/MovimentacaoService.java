package com.bank.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.api.dto.movimentacao.NovaMovimentacaoDto;
import com.bank.api.models.Correntista;
import com.bank.api.models.Movimentacao;
import com.bank.api.models.MovimentacaoTipo;
import com.bank.api.repositories.CorrentistaRepository;
import com.bank.api.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacaoDto novaMovimentacaoDto) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacaoDto.getTipo()==MovimentacaoTipo.RECEITA ? 
					novaMovimentacaoDto.getValor() : novaMovimentacaoDto.getValor() * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacaoDto.getDescricao());
		movimentacao.setTipo(novaMovimentacaoDto.getTipo());
		movimentacao.setIdConta(novaMovimentacaoDto.getIdConta());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacaoDto.getIdConta()).orElseThrow();
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		movimentacaoRepository.save(movimentacao);
	}
}
