package br.com.prime.projeto.live.dio.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.prime.projeto.live.dio.modelo.Movimentacao;
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

public class MovimentacaoDTO {


	private long idMovimentacao;
	private long idUsuario;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodoPermanencia;

	private OcorrenciaDTO ocorrencia;

	private CalendarioDTO calendario;

	public MovimentacaoDTO(Movimentacao m) {
		
		this.idMovimentacao = m.getId().getIdMovimentacao();
		this.idUsuario = m.getId().getIdUsuario();
		this.dataEntrada = m.getDataEntrada();
		this.dataSaida = m.getDataSaida();
		this.periodoPermanencia = m.getPeriodoPermanencia();
		this.ocorrencia = new OcorrenciaDTO( m.getOcorrencia());
		this.calendario = new CalendarioDTO(m.getCalendario());
	}
	
	
	
	
	
}
