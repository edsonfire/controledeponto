package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.TipoDataDTO;
import br.com.prime.projeto.live.dio.modelo.TipoData;
import br.com.prime.projeto.live.dio.repository.TipoDataRepository;

@Service
public class TipoDataService {

	
	TipoDataRepository repository;

	@Autowired
	public TipoDataService(TipoDataRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public TipoDataDTO save(TipoDataDTO jd) {
		TipoData j = new TipoData(0, jd.getDescricao());
		
		repository.save(j);
		return new TipoDataDTO(j);
	}



	public List<TipoDataDTO> findAll() {
		
		
		
		List<TipoData> list = repository.findAll();
		
		List<TipoDataDTO> jlist = new ArrayList<TipoDataDTO>();
		
		list.stream().forEach(a -> jlist.add(new TipoDataDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<TipoDataDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<TipoData> a = repository.findById(id);
		
		TipoDataDTO adto = new TipoDataDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public TipoDataDTO update(TipoDataDTO j) {
		
		TipoData a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new TipoDataDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
