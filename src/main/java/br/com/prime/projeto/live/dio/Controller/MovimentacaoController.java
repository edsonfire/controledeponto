package br.com.prime.projeto.live.dio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.projeto.live.dio.Service.MovimentacaoService;
import br.com.prime.projeto.live.dio.dto.MovimentacaoDTO;
import br.com.prime.projeto.live.dio.modelo.Movimentacao;
import br.com.prime.projeto.live.dio.modelo.Movimentacao.MovimentacaoId;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

	
	@Autowired
	private MovimentacaoService service;
	
	@PostMapping
	public MovimentacaoDTO createJornada(@RequestBody MovimentacaoDTO jt) {
		
		return service.save(jt);
		
	}
	
	@GetMapping
	public List<MovimentacaoDTO> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{idmov}/{idu}")
	public ResponseEntity<MovimentacaoDTO>  getById(@PathVariable("idmov") long idmov, @PathVariable("idu") long idu ) throws Exception {
		
		
		MovimentacaoId bid = new Movimentacao().new MovimentacaoId(idmov, idu);
		
		
		
		
		return ResponseEntity.ok(service.getById(bid).orElseThrow(()-> new Exception("Jornada não encontrada")));
	}

	@PutMapping
	public MovimentacaoDTO updateJornada(@RequestBody MovimentacaoDTO jt) {
		return service.update(jt);
		
	}
	
	@GetMapping("/del/{idmov}/{idu}")
	public ResponseEntity<String> deleteJormada(@PathVariable("idmov") long idmov, @PathVariable("idu") long idu) {
		
		

		MovimentacaoId bid = new Movimentacao().new MovimentacaoId(idmov, idu);
		
		
		try {
			
			service.delete(bid);
			
		return ResponseEntity.ok().body("ok");
		}catch (Exception e) {
			return  ResponseEntity.status(500).body("falha");
		}
		
		
	}
	
	
	


}
