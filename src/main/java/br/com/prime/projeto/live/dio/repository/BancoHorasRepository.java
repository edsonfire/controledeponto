package br.com.prime.projeto.live.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.projeto.live.dio.modelo.BancoHoras;
import br.com.prime.projeto.live.dio.modelo.BancoHoras.BancoHorasId;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {

}
