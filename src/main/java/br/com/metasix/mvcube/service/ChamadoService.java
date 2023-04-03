package br.com.metasix.mvcube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.metasix.mvcube.entity.Chamado;
import br.com.metasix.mvcube.repository.ChamadoRepository;

@Service
public class ChamadoService {

	@Autowired
	ChamadoRepository chamadoRepository;
	
	public Chamado execute(Chamado chamado) {
		
		Chamado createdChamado = chamadoRepository.save(chamado);		
		return createdChamado;
		
	}
	
}
