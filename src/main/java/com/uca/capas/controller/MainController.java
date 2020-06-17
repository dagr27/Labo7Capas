package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	
	@RequestMapping("/formEstudiante")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				
				estudianteService.insert(estudiante);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			estudiante = new Estudiante();
			mav.addObject("estudiante", estudiante);
			
		}
		
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/borrarEstudiante")
	public ModelAndView borrar(@RequestParam(value="c_usuario")int c_usuario) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(c_usuario);
			estudiantes = estudianteService.findAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@PostMapping("/filtrar")
	public ModelAndView filtro(@RequestParam(value="nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes= estudianteService.filtrarPor(cadena);
			//estudiantes= estudianteService.empiezaPor(cadena);
		 
		} catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@PostMapping("/editar")
	public ModelAndView edit(@RequestParam(value="c_usuario") int c_usuario) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiantes = null;
		try {
			estudiantes= estudianteService.findOne(c_usuario);
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("modificar");
		 
		} catch (Exception e){
			e.printStackTrace();
			estudiantes = new Estudiante();
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@PostMapping("/editarEstudiante")
	public ModelAndView modificarEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		if(!result.hasErrors()) {
			try {
				
				estudianteService.insert(estudiante);
				estudiantes = estudianteService.findAll();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("listado");
			
			
		}else {
			estudiante = new Estudiante();
			mav.addObject("estudiante", estudiante);
			mav.setViewName("index");
		}
		
		
		
		return mav;
		
	}
	
	
}
