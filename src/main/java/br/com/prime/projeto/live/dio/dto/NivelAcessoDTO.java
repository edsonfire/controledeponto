package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.NivelAcesso;
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
public class NivelAcessoDTO {
	private long id;
	private String descricao;
	
	
	public NivelAcessoDTO(NivelAcesso na) {
		super();
		this.id = na.getId();
		this.descricao = na.getDescricao();
	}
	
	
	
	
	

}
