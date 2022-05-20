package com.bank.api.dto.movimentacao;

import com.bank.api.models.MovimentacaoTipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovaMovimentacaoDto {

	private String descricao;
	
	private Double valor;
	
	private MovimentacaoTipo tipo;

	private Integer idConta;
}
