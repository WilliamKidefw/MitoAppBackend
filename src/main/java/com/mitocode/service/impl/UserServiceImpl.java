package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Usuario;
import com.mitocode.repo.IUsuarioRepo;
import com.mitocode.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public Usuario registrar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario listarPorId(Integer id) {
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Usuario> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
