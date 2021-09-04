package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.OcorrenciaDTO;
import br.com.prime.projeto.live.dio.modelo.Ocorrencia;
import br.com.prime.projeto.live.dio.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	
	OcorrenciaRepository repository;

	@Autowired
	public OcorrenciaService(OcorrenciaRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public OcorrenciaDTO save(OcorrenciaDTO jd) {
		Ocorrencia j = new Ocorrencia(0,jd.getNome() ,jd.getDescricao());
		
		repository.save(j);
		return new OcorrenciaDTO(j);
	}



	public List<OcorrenciaDTO> findAll() {
		
		
		
		List<Ocorrencia> list = repository.findAll();
		
		List<OcorrenciaDTO> jlist = new ArrayList<OcorrenciaDTO>();
		
		list.stream().forEach(a -> jlist.add(new OcorrenciaDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<OcorrenciaDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Ocorrencia> a = repository.findById(id);
		
		OcorrenciaDTO adto = new OcorrenciaDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public OcorrenciaDTO update(OcorrenciaDTO j) {
		
		Ocorrencia a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new OcorrenciaDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
