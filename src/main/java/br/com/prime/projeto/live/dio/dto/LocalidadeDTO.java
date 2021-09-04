package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.Localidade;
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
public class LocalidadeDTO {
	private long id;
	private NivelAcessoDTO codigoNivel;
	private String descricao;
	
	public LocalidadeDTO(Localidade l) {
		
		this.id = l.getId();
		this.codigoNivel = new NivelAcessoDTO(l.getCodigoNivel());
		this.descricao = l.getDescricao();
	}
	
	
	
}
