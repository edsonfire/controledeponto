package br.com.prime.projeto.live.dio.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.projeto.live.dio.Service.BancoHorasService;
import br.com.prime.projeto.live.dio.dto.BancoHorasDTO;
import br.com.prime.projeto.live.dio.modelo.BancoHoras;
import br.com.prime.projeto.live.dio.modelo.BancoHoras.BancoHorasId;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {

	
	@Autowired
	private BancoHorasService service;
	
	@PostMapping
	public BancoHorasDTO createJornada(@RequestBody BancoHorasDTO jt) {
		
		return service.save(jt);
		
	}
	
	@GetMapping
	public List<BancoHorasDTO> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}/{idmov}/{idu}")
	public ResponseEntity<BancoHorasDTO>  getById(@PathVariable("id") long idbh,@PathVariable("idmov") long idmov, @PathVariable("idu") long idu ) throws Exception {
		
		
		BancoHorasId bid = new BancoHoras().new BancoHorasId(idbh, idmov, idu);
		
		
		
		
		return ResponseEntity.ok(service.getById(bid).orElseThrow(()-> new Exception("Jornada não encontrada")));
	}

	@PutMapping
	public BancoHorasDTO updateJornada(@RequestBody BancoHorasDTO jt) {
		return service.update(jt);
		
	}
	
	@GetMapping("/del/{id}/{idmov}/{idu}")
	public ResponseEntity<String> deleteJormada(@PathVariable("id") long idbh,@PathVariable("idmov") long idmov, @PathVariable("idu") long idu) {
		
		

		BancoHorasId bid = new BancoHoras().new BancoHorasId(idbh, idmov, idu);
		
		
		try {
			
			service.delete(bid);
			
		return ResponseEntity.ok().body("ok");
		}catch (Exception e) {
			return  ResponseEntity.status(500).body("falha");
		}
		
		
	}
	
	
	


}
