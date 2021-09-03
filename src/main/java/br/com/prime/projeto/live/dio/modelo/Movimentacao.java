package br.com.prime.projeto.live.dio.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
@Entity
public class Movimentacao {


	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Embeddable
	public class MovimentacaoId implements Serializable{
		private long idMovimentacao;
		private long idUsuario;
	}
	@EmbeddedId
	private MovimentacaoId id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodoPermanencia;
	@ManyToOne
	private Ocorrencia ocorrencia;
	@ManyToOne
	private Calendario calendario;
	
	
	
	
	
}
