package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Rol;
import com.mitocode.repo.IRolRepo;
import com.mitocode.service.IRolService;

@Service
public class RolServiceImpl implements IRolService {
	
	@Autowired
	private IRolRepo repo;

	@Override
	public Rol registrar(Rol rol) {
		return repo.save(rol);
	}

	@Override
	public Rol modificar(Rol rol) {
		return repo.save(rol);
	}

	@Override
	public Rol listarPorId(Integer idRol) {
		Optional<Rol> op = repo.findById(idRol);
		return op.isPresent() ? op.get() : new Rol();
	}

	@Override
	public List<Rol> listar() {
		return repo.findAll();
	}

	@Override
	public boolean eliminar(Integer idRol) {
		repo.deleteById(idRol);
		return true;
	}

	@Override
	public Page<Rol> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
