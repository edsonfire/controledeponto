package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;
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
public class JornadaTrabalhoDTO {


	private long id;
	private String descricao;
	
	
	
	public JornadaTrabalhoDTO(JornadaTrabalho j) {
		this.id = j.getId();
		this.descricao = j.getDescricao();
	}
	
}
