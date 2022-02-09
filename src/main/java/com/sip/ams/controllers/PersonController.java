package com.sip.ams.controllers;

import java.awt.List;
import java.util.ArrayList;

import com.sip.ams.entities.Person;
import com.sip.ams.forms.PersonForm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {
    
	private static ArrayList<Person> person= new ArrayList<Person>();
	
static {
	person.add(new Person("Eric","macro"));
	person.add(new Person("Emili","teri"));
	person.add(new Person("Stefan","Brrouss"));
	
}

    @Value("${error.message}")
    private String errormsg;
    
    @GetMapping("/")
	public String redirect(Model model) {
    	model.addAttribute("persons",person);
	    return "home/personList";
	}
    
    @GetMapping("/personList")
	public String fnpersonsList(Model model) {
	model.addAttribute("persons",person);
		return "home/personList";
	}

    @GetMapping("/addPerson")
  	public String fnaddpersonn(Model model) {
      PersonForm personform = new PersonForm();
    	model.addAttribute("personform",personform);
  		return "home/addPerson";
  	}
    
    @PostMapping("/addPerson")
  	public String fnaddperson(Model model, @ModelAttribute("personform") PersonForm personform) {
 
    	String firstname = personform.getFirstName();
    	String lastname = personform.getLastName();
    	if(firstname != null && lastname != null && firstname.length()>0 && lastname.length()>0) {
    		Person prs = new Person(firstname,lastname);
        	person.add(prs);
        	return "redirect:/personList";
    	}
    	model.addAttribute("errormsg",errormsg);
    	return "home/addPerson";
  	}
    
}
























