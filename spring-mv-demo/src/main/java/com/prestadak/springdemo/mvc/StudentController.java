package com.prestadak.springdemo.mvc;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Convert trim input strings
	// resolve issue for validation
	// remove all white space
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student = new Student();
		student.setFirstName("Mohamadou");
		//student.setLastName("Ndiaye Diatta");
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		
		System.out.println("Student>>>>> |"+student.getLastName()+"|");	
		if (bindingResult.hasErrors()) {
			return "student-form";
		} else {
			
			return "student-confirmation";
		}
		
	}
}
