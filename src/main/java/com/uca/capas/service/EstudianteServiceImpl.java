package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepo estudianteRepo;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteRepo.findAll();
		return estudianteRepo.mostrarTodos();
	}
	
	@Override
	public Estudiante findOne(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(id);
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer c_usuario) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(c_usuario);
		
	}
	
	@Override
	@Transactional
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteRepo.findByNombre(cadena);
		return estudianteRepo.mostrarPorNombre(cadena);
	}

	@Override
	public List<Estudiante> empiezaPor(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findByApellidoStartingWith(cadena);
	}
	

	

}
