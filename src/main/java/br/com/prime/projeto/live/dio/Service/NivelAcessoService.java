package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.NivelAcessoDTO;
import br.com.prime.projeto.live.dio.modelo.NivelAcesso;
import br.com.prime.projeto.live.dio.repository.NivelAcessoRepository;

@Service
public class NivelAcessoService {

	
	NivelAcessoRepository repository;

	@Autowired
	public NivelAcessoService(NivelAcessoRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public NivelAcessoDTO save(NivelAcessoDTO jd) {
		NivelAcesso j = new NivelAcesso(0, jd.getDescricao());
		
		repository.save(j);
		return new NivelAcessoDTO(j);
	}



	public List<NivelAcessoDTO> findAll() {
		
		
		
		List<NivelAcesso> list = repository.findAll();
		
		List<NivelAcessoDTO> jlist = new ArrayList<NivelAcessoDTO>();
		
		list.stream().forEach(a -> jlist.add(new NivelAcessoDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<NivelAcessoDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<NivelAcesso> a = repository.findById(id);
		
		NivelAcessoDTO adto = new NivelAcessoDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public NivelAcessoDTO update(NivelAcessoDTO j) {
		
		NivelAcesso a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new NivelAcessoDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
