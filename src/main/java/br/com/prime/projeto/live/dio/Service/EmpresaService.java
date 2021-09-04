package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.EmpresaDTO;
import br.com.prime.projeto.live.dio.modelo.Empresa;
import br.com.prime.projeto.live.dio.repository.EmpresaRepository;

@Service
public class EmpresaService {

	
	EmpresaRepository repository;

	@Autowired
	public EmpresaService(EmpresaRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public EmpresaDTO save(EmpresaDTO jd) {
		Empresa j = new Empresa(0, jd.getDescricao(), jd.getCnpj(), jd.getEndereco(), jd.getBairro(), jd.getCidade(), jd.getUf(), jd.getTelefone());
		
		repository.save(j);
		return new EmpresaDTO(j);
	}



	public List<EmpresaDTO> findAll() {
		
		
		
		List<Empresa> list = repository.findAll();
		
		List<EmpresaDTO> jlist = new ArrayList<EmpresaDTO>();
		
		list.stream().forEach(a -> jlist.add(new EmpresaDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<EmpresaDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Empresa> a = repository.findById(id);
		
		EmpresaDTO adto = new EmpresaDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public EmpresaDTO update(EmpresaDTO j) {
		
		Empresa a = repository.getById(j.getId());
		
		a.setDescricao(j.getDescricao());
		
		repository.save(a);
		
		return new EmpresaDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
