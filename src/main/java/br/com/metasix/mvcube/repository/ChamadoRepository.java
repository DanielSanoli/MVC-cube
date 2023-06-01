package br.com.metasix.mvcube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.metasix.mvcube.entity.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

	@Query("SELECT u FROM Chamado u ORDER BY id")
	List<Chamado> findAllOrderById();
	
}
