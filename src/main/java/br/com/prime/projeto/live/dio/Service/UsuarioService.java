package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.UsuarioDTO;
import br.com.prime.projeto.live.dio.modelo.CategoriaUsuario;
import br.com.prime.projeto.live.dio.modelo.Empresa;
import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;
import br.com.prime.projeto.live.dio.modelo.NivelAcesso;
import br.com.prime.projeto.live.dio.modelo.Usuario;
import br.com.prime.projeto.live.dio.repository.CategoriaUsuarioRepository;
import br.com.prime.projeto.live.dio.repository.EmpresaRepository;
import br.com.prime.projeto.live.dio.repository.JornadaTrabalhoRepository;
import br.com.prime.projeto.live.dio.repository.NivelAcessoRepository;
import br.com.prime.projeto.live.dio.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	UsuarioRepository repository;
	CategoriaUsuarioRepository creository; 
	EmpresaRepository erepository;
	NivelAcessoRepository nrepository;
	JornadaTrabalhoRepository jtrepository;
	

	@Autowired
	public UsuarioService(UsuarioRepository repository, CategoriaUsuarioRepository curepository, EmpresaRepository erepository, NivelAcessoRepository nrepository, JornadaTrabalhoRepository jtrepository) {
	
		this.repository = repository;
		this.creository = curepository;
		this.erepository = erepository;
		this.jtrepository = jtrepository;
	}
	
	
	
	public UsuarioDTO save(UsuarioDTO jd) {
		
		
		
		CategoriaUsuario c = creository.getById(jd.getCategoriaUsuario().getId()); 
		Empresa e = erepository.getById(jd.getEmpresa().getId());
		NivelAcesso n = nrepository.getById(jd.getId());
		JornadaTrabalho j = jtrepository.getById(jd.getJornadaTrabalho().getId());
		
		
		Usuario u = new Usuario(0, c,jd.getNome(), e, n, j, jd.getTolerancia(), jd.getInicioJornada(), jd.getFimJornada());
		
		repository.save(u);
		return new UsuarioDTO(u);
	}



	public List<UsuarioDTO> findAll() {
		
		
		
		List<Usuario> list = repository.findAll();
		
		List<UsuarioDTO> jlist = new ArrayList<UsuarioDTO>();
		
		list.stream().forEach(a -> jlist.add(new UsuarioDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<UsuarioDTO> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Usuario> a = repository.findById(id);
		
		UsuarioDTO adto = new UsuarioDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public UsuarioDTO update(UsuarioDTO jd) {
		
		Usuario a = repository.getById(jd.getId());
		
		CategoriaUsuario c = creository.getById(jd.getCategoriaUsuario().getId()); 
		Empresa e = erepository.getById(jd.getEmpresa().getId());
		NivelAcesso n = nrepository.getById(jd.getId());
		JornadaTrabalho j = jtrepository.getById(jd.getJornadaTrabalho().getId());
		
		
		a.setCategoriaUsuario(c);
		a.setEmpresa(e);
		a.setFimJornada(jd.getFimJornada());
		a.setInicioJornada(jd.getInicioJornada());
		a.setJornadaTrabalho(j);
		a.setNivelAcesso(n);
		a.setNome(jd.getNome());
		a.setTolerancia(jd.getTolerancia());
		
		repository.save(a);
		
		return new UsuarioDTO(a);
		
		
	}
	
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
}
