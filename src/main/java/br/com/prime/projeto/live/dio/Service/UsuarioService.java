package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.JornadaTrabalhoDTO;
import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;
import br.com.prime.projeto.live.dio.repository.JornadaTrabalhoRepository;

@Service
public class UsuarioService {

	
	JornadaTrabalhoRepository repository;

	@Autowired
	public UsuarioService(JornadaTrabalhoRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public JornadaTrabalhoDTO save(JornadaTrabalhoDTO jd) {
		JornadaTrabalho j = new JornadaTrabalho(0, jd.getDescricao());
		
		repository.save(j);
		return new JornadaTrabalhoDTO(j);
	}



	public List<JornadaTrabalhoDTO> findAll() {
		
		
		
		List<JornadaTrabalho> list = repository.findAll();
		
		List<JornadaTrabalhoDTO> jlist = new ArrayList<JornadaTrabalhoDTO>();
		
		list.stream().forEach(a -> jlist.add(new JornadaTrabalhoDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<JornadaTrabalhoDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<JornadaTrabalho> a = repository.findById(id);
		
		JornadaTrabalhoDTO adto = new JornadaTrabalhoDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public JornadaTrabalhoDTO update(JornadaTrabalhoDTO j) {
		
		JornadaTrabalho a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new JornadaTrabalhoDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
