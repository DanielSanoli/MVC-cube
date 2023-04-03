package br.com.metasix.mvcube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.metasix.mvcube.entity.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

}
