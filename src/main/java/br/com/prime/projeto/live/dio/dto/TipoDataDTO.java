package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.TipoData;
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
public class TipoDataDTO {
	private long id;
	private String descricao;
	public TipoDataDTO(TipoData td) {
		
		this.id = td.getId();
		this.descricao = td.getDescricao();
	}
	
	
}
