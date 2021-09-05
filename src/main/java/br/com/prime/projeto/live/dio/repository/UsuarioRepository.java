package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
