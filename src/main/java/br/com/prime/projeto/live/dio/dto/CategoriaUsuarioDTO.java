package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.CategoriaUsuario;
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
public class CategoriaUsuarioDTO {
	private long id;
	private String descricao;
	
	
	public CategoriaUsuarioDTO(CategoriaUsuario c) {
		
		this.id = c.getId();
		this.descricao = c.getDescricao();
		
	}
	
	
}
