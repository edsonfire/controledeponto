package br.com.prime.projeto.live.dio.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class BancoHoras {


	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Embeddable
	public class BancoHorasId implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long idBancoHoras;
		private Long idMovimentacao;
		private Long idUsuario;
	}
	@EmbeddedId
	private BancoHorasId id;
	private LocalDateTime dataTrabalhada;
	private BigDecimal quantidadeHoras;
	private BigDecimal saldoHoras;
	
	
	
}
