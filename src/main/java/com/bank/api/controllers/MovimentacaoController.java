package com.bank.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.dto.movimentacao.NovaMovimentacaoDto;
import com.bank.api.models.Movimentacao;
import com.bank.api.repositories.MovimentacaoRepository;
import com.bank.api.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return movimentacaoRepository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacaoDto novaMovimentacaoDto) {
		movimentacaoService.save(novaMovimentacaoDto);
	}
}
