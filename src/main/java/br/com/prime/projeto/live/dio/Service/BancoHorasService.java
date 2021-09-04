package br.com.prime.projeto.live.dio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prime.projeto.live.dio.dto.BancoHorasDTO;
import br.com.prime.projeto.live.dio.modelo.BancoHoras;
import br.com.prime.projeto.live.dio.modelo.BancoHoras.BancoHorasId;
import br.com.prime.projeto.live.dio.repository.BancoHorasRepository;

@Service
public class BancoHorasService {

	
	
	BancoHorasRepository repository;

	@Autowired
	public BancoHorasService(BancoHorasRepository repository) {
	
		this.repository = repository;
	}
	
	
	
	public BancoHorasDTO save(BancoHorasDTO jd) {
		
		
		BancoHoras j = new BancoHoras();
		j = new BancoHoras(j.new BancoHorasId(jd.getIdBancoHoras(), jd.getIdMovimentacao(), jd.getIdUsuario()) ,jd.getDataTrabalhada(), jd.getQuantidadeHoras(), jd.getSaldoHoras());
		
		repository.save(j);
		return new BancoHorasDTO(j);
	}



	public List<BancoHorasDTO> findAll() {
		
		
		
		List<BancoHoras> list = repository.findAll();
		
		List<BancoHorasDTO> jlist = new ArrayList<BancoHorasDTO>();
		
		list.stream().forEach(a -> jlist.add(new BancoHorasDTO(a)));
		
		
		return jlist;
		
	}



	public Optional<BancoHorasDTO> getById(BancoHorasId id) {
		// TODO Auto-generated method stub
		Optional<BancoHoras> a = repository.findById(id);
		
		BancoHorasDTO adto = new BancoHorasDTO(a.get());
		
		return Optional.ofNullable(adto); 
	}
	
	
	

	public BancoHorasDTO update(BancoHorasDTO j) {
		
		BancoHoras a = new BancoHoras();
		BancoHorasId id = a.new BancoHorasId(j.getIdBancoHoras(), j.getIdMovimentacao(), j.getIdUsuario());
		
		a = repository.getById(id);
		
		a.setDataTrabalhada(j.getDataTrabalhada());
		a.setQuantidadeHoras(j.getQuantidadeHoras());
		a.setSaldoHoras(j.getSaldoHoras());
		
		repository.save(a);
		
		return new BancoHorasDTO(a);
		
		
	}
	
	

	public void delete(BancoHorasId id) {
		
				
		
		repository.deleteById(id);
	}
	
}
