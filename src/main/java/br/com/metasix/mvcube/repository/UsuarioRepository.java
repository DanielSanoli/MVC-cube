package br.com.metasix.mvcube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.metasix.mvcube.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
	@Query("SELECT u FROM Usuario u ORDER BY id")
	List<Usuario> findAllOrderById();
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.roles where u.email = :email")
	Usuario findByEmailFetchRoles(@Param("email") String email);
	
//	@Query("SELECT u FROM Usuario u WHERE u.nomeCompleto like ?1%")   
//	List<Usuario> findByName(String nome);
	
}
