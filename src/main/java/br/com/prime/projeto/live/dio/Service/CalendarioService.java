package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.CalendarioDTO;
import br.com.prime.projeto.live.dio.modelo.Calendario;
import br.com.prime.projeto.live.dio.modelo.TipoData;
import br.com.prime.projeto.live.dio.repository.CalendarioRepository;
import br.com.prime.projeto.live.dio.repository.TipoDataRepository;

@Service
public class CalendarioService {

	
	CalendarioRepository repository;
	TipoDataRepository tdrepository;
	
	
	@Autowired
	public CalendarioService(CalendarioRepository repository, TipoDataRepository tdrepository) {
	
		this.repository = repository;
		this.tdrepository  = tdrepository;
	}
	
	
	
	public CalendarioDTO save(CalendarioDTO jd) {
		
		
		TipoData td = tdrepository.getById(jd.getTipoData().getId()) ;
		
		Calendario j = new Calendario(0, td, jd.getDescricao(), jd.getDataEspecial());
		
		repository.save(j);
		return new CalendarioDTO(j);
	}



	public List<CalendarioDTO> findAll() {
		
		
		
		List<Calendario> list = repository.findAll();
		
		List<CalendarioDTO> jlist = new ArrayList<CalendarioDTO>();
		
		list.stream().forEach(a -> jlist.add(new CalendarioDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<CalendarioDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Calendario> a = repository.findById(id);
		
		CalendarioDTO adto = new CalendarioDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public CalendarioDTO update(CalendarioDTO j) {
		
		Calendario a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new CalendarioDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
