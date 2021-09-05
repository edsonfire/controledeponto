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

import br.com.prime.projeto.live.dio.Service.JordanaTrabalhoService;
import br.com.prime.projeto.live.dio.dto.JornadaTrabalhoDTO;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

	
	@Autowired
	private JordanaTrabalhoService service;
	
	@PostMapping
	public JornadaTrabalhoDTO createJornada(@RequestBody JornadaTrabalhoDTO jt) {
		
		return service.save(jt);
		
	}
	
	@GetMapping
	public List<JornadaTrabalhoDTO> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JornadaTrabalhoDTO>  getById(@PathVariable("id") long id ) throws Exception {
		
		return ResponseEntity.ok(service.getById(id).orElseThrow(()-> new Exception("Jornada não encontrada")));
	}

	@PutMapping
	public JornadaTrabalhoDTO updateJornada(@RequestBody JornadaTrabalhoDTO jt) {
		return service.update(jt);
		
	}
	
	@GetMapping("/del/{id}")
	public ResponseEntity<String> deleteJormada(@PathVariable("id") long id) {
		
		try {
			
			service.delete(id);
			
		return ResponseEntity.ok().body("ok");
		}catch (Exception e) {
			return  ResponseEntity.status(500).body("falha");
		}
		
		
	}
	
	
	


}
