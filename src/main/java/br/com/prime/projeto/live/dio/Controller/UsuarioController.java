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

import br.com.prime.projeto.live.dio.Service.UsuarioService;
import br.com.prime.projeto.live.dio.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public UsuarioDTO createJornada(@RequestBody UsuarioDTO jt) {
		
		return service.save(jt);
		
	}
	
	@GetMapping
	public List<UsuarioDTO> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO>  getById(@PathVariable("id") long id ) throws Exception {
		
		return ResponseEntity.ok(service.getById(id).orElseThrow(()-> new Exception("Jornada não encontrada")));
	}

	@PutMapping
	public UsuarioDTO updateJornada(@RequestBody UsuarioDTO jt) {
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
