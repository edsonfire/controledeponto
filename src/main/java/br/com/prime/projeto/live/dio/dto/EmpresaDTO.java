package br.com.prime.projeto.live.dio.dto;

import br.com.prime.projeto.live.dio.modelo.Empresa;
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
public class EmpresaDTO {

	private long id;
	private String descricao;
	private String cnpj;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private String telefone;
	
	
	public EmpresaDTO(Empresa e) {
		
		this.id = e.getId();
		this.descricao = e.getDescricao();
		this.cnpj = e.getCnpj();
		this.endereco = e.getEndereco();
		this.bairro = e.getBairro();
		this.cidade = e.getCidade();
		this.uf = e.getUf();
		this.telefone = e.getTelefone();
	}
	
	
	
	
	
}
