package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.JornadaTrabalho;

public interface UsuarioRepository extends JpaRepository<JornadaTrabalho, Long> {

}
