package br.com.prime.projeto.live.dio.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.prime.projeto.live.dio.modelo.BancoHoras;
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
public class BancoHorasDTO {

		private Long idBancoHoras;
		private Long idMovimentacao;
		private Long idUsuario;
		private LocalDateTime dataTrabalhada;
		private BigDecimal quantidadeHoras;
		private BigDecimal saldoHoras;
		public BancoHorasDTO(BancoHoras b) {
			
			this.idBancoHoras = b.getId().getIdBancoHoras();
			this.idMovimentacao = b.getId().getIdMovimentacao();
			this.idUsuario = b.getId().getIdUsuario();
			this.dataTrabalhada = b.getDataTrabalhada();
			this.quantidadeHoras = b.getQuantidadeHoras();
			this.saldoHoras = b.getSaldoHoras();
		}
	
		
		
		
	
	
}
