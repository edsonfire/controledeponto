package br.com.prime.projeto.live.dio.dto;

import java.time.LocalDateTime;

import br.com.prime.projeto.live.dio.modelo.Calendario;
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
public class CalendarioDTO {

	private long id;
	private TipoDataDTO tipoData;
	private String descricao;
	private LocalDateTime dataEspecial;
	public CalendarioDTO(Calendario c) {
		
		this.id = c.getId();
		this.tipoData =new TipoDataDTO(c.getTipoData());
		this.descricao = c.getDescricao();
		this.dataEspecial = c.getDataEspecial();
	}
	
	
	
}
