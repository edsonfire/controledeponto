package br.com.prime.projeto.live.dio.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.prime.projeto.live.dio.modelo.Usuario;
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

public class UsuarioDTO {
	private long id;
	private CategoriaUsuarioDTO categoriaUsuario;
	private String nome;
	private EmpresaDTO empresa;
	private NivelAcessoDTO nivelAcesso;
	private JornadaTrabalhoDTO jornadaTrabalho;
	private BigDecimal tolerancia;
	private LocalDateTime inicioJornada;
	private LocalDateTime fimJornada;
	public UsuarioDTO(Usuario u) {
		super();
		this.id = u.getId();
		this.categoriaUsuario = new CategoriaUsuarioDTO(u.getCategoriaUsuario());
		this.nome = u.getNome();
		this.empresa = new EmpresaDTO( u.getEmpresa());
		this.nivelAcesso =new NivelAcessoDTO(u.getNivelAcesso());
		this.jornadaTrabalho = new JornadaTrabalhoDTO(u.getJornadaTrabalho());
		this.tolerancia =  u.getTolerancia();
		this.inicioJornada = u.getInicioJornada();
		this.fimJornada = u.getFimJornada();
	}
	
	
	
	
}
