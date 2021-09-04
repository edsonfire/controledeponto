package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.LocalidadeDTO;
import br.com.prime.projeto.live.dio.modelo.Localidade;
import br.com.prime.projeto.live.dio.modelo.NivelAcesso;
import br.com.prime.projeto.live.dio.repository.LocalidadeRepository;
import br.com.prime.projeto.live.dio.repository.NivelAcessoRepository;

@Service
public class LocalidadeService {

	
	LocalidadeRepository repository;
	NivelAcessoRepository nrepository;

	@Autowired
	public LocalidadeService(LocalidadeRepository repository, NivelAcessoRepository nrepository) {
	
		this.repository = repository;
		this.nrepository = nrepository;
	}
	
	
	
	public LocalidadeDTO save(LocalidadeDTO jd) {
		
		
		NivelAcesso nv = nrepository.getById(jd.getCodigoNivel().getId());
		
		Localidade j = new Localidade(0, nv, jd.getDescricao());
		
		repository.save(j);
		return new LocalidadeDTO(j);
	}



	public List<LocalidadeDTO> findAll() {
		
		
		
		List<Localidade> list = repository.findAll();
		
		List<LocalidadeDTO> jlist = new ArrayList<LocalidadeDTO>();
		
		list.stream().forEach(a -> jlist.add(new LocalidadeDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<LocalidadeDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Localidade> a = repository.findById(id);
		
		LocalidadeDTO adto = new LocalidadeDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public LocalidadeDTO update(LocalidadeDTO j) {
		
		Localidade a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new LocalidadeDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
