package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.MovimentacaoDTO;
import br.com.prime.projeto.live.dio.modelo.Calendario;
import br.com.prime.projeto.live.dio.modelo.Movimentacao;
import br.com.prime.projeto.live.dio.modelo.Movimentacao.MovimentacaoId;
import br.com.prime.projeto.live.dio.modelo.Ocorrencia;
import br.com.prime.projeto.live.dio.repository.CalendarioRepository;
import br.com.prime.projeto.live.dio.repository.MovimentacaoRepository;
import br.com.prime.projeto.live.dio.repository.OcorrenciaRepository;

@Service
public class MovimentacaoService {

	
	MovimentacaoRepository repository;
	OcorrenciaRepository   orepository;
	CalendarioRepository crepository;
	
	
	

	@Autowired
	public MovimentacaoService(MovimentacaoRepository repository, OcorrenciaRepository orepository, CalendarioRepository crepository) {
	
		this.repository = repository;
		this.orepository = orepository;
		this.crepository = crepository;
	}
	
	
	
	public MovimentacaoDTO save(MovimentacaoDTO jd) {
		
		Movimentacao j = new Movimentacao();
		
		Ocorrencia o = orepository.getById(jd.getOcorrencia().getId());
		Calendario c = crepository.getById(jd.getCalendario().getId());
		MovimentacaoId mid = j.new MovimentacaoId(jd.getIdMovimentacao(), jd.getIdUsuario()); 
		
		j = new Movimentacao(mid, jd.getDataEntrada(), jd.getDataSaida(), jd.getPeriodoPermanencia(), o, c);
		
		repository.save(j);
		return new MovimentacaoDTO(j);
	}



	public List<MovimentacaoDTO> findAll() {
		
		
		
		List<Movimentacao> list = repository.findAll();
		
		List<MovimentacaoDTO> jlist = new ArrayList<MovimentacaoDTO>();
		
		list.stream().forEach(a -> jlist.add(new MovimentacaoDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<MovimentacaoDTO> getById(MovimentacaoId mid) {
		// TODO Auto-generated method stub
		Optional<Movimentacao> a = repository.findById(mid);
		
		MovimentacaoDTO adto = new MovimentacaoDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public MovimentacaoDTO update(MovimentacaoDTO j) {
		
		
		Movimentacao a = new Movimentacao();
		MovimentacaoId mid = a.new MovimentacaoId(j.getIdMovimentacao(),j.getIdUsuario() );
		
		
		
		Ocorrencia o = orepository.getById(j.getOcorrencia().getId());
		Calendario c = crepository.getById(j.getCalendario().getId());
		
		
		a = repository.getById(mid);
		a.setCalendario( c);
		a.setOcorrencia(o);
		a.setDataEntrada(j.getDataEntrada());
		a.setDataSaida(j.getDataSaida());
		a.setPeriodoPermanencia(j.getPeriodoPermanencia());
		
		
		repository.save(a);
		
		return new MovimentacaoDTO(a);
		
		
	}
	
	

	public void delete(MovimentacaoId mid) {
		// TODO Auto-generated method stub
		repository.deleteById(mid);
	}
	
}
