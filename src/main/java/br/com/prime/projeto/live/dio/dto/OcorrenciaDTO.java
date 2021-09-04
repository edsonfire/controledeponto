package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.Ocorrencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class OcorrenciaDTO {
	
	private long id;
	private String nome;
	private String descricao;
	public OcorrenciaDTO(Ocorrencia oc) {
		
		this.id = oc.getId();
		this.nome = oc.getNome();
		this.descricao = oc.getDescricao();
	}
	
	
	
	

}
