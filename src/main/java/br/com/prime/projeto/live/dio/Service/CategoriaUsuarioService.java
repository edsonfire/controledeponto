package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.CategoriaUsuarioDTO;
import br.com.prime.projeto.live.dio.modelo.CategoriaUsuario;
import br.com.prime.projeto.live.dio.repository.CategoriaUsuarioRepository;

@Service
public class CategoriaUsuarioService {

	
	CategoriaUsuarioRepository repository;

	@Autowired
	public CategoriaUsuarioService(CategoriaUsuarioRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public CategoriaUsuarioDTO save(CategoriaUsuarioDTO jd) {
		CategoriaUsuario j = new CategoriaUsuario(0, jd.getDescricao());
		
		repository.save(j);
		return new CategoriaUsuarioDTO(j);
	}



	public List<CategoriaUsuarioDTO> findAll() {
		
		
		
		List<CategoriaUsuario> list = repository.findAll();
		
		List<CategoriaUsuarioDTO> jlist = new ArrayList<CategoriaUsuarioDTO>();
		
		list.stream().forEach(a -> jlist.add(new CategoriaUsuarioDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<CategoriaUsuarioDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<CategoriaUsuario> a = repository.findById(id);
		
		CategoriaUsuarioDTO adto = new CategoriaUsuarioDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public CategoriaUsuarioDTO update(CategoriaUsuarioDTO j) {
		
		CategoriaUsuario a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new CategoriaUsuarioDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
