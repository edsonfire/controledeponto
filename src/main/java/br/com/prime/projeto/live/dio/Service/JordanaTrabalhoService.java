package br.com.prime.projeto.live.dio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;
import br.com.prime.projeto.live.dio.repository.JornadaTrabalhoRepository;

@Service
public class JordanaTrabalhoService {

	
	JornadaTrabalhoRepository repository;

	@Autowired
	public JordanaTrabalhoService(JornadaTrabalhoRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public JornadaTrabalho save(JornadaTrabalho j) {
		
		return repository.save(j);
	}



	public List<JornadaTrabalho> findAll() {
		return repository.findAll();
	}



	public Optional<JornadaTrabalho> getById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	
	

	public JornadaTrabalho update(JornadaTrabalho j) {
		
		return repository.save(j);
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
