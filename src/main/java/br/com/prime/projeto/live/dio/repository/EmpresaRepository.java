package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
