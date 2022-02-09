package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
    @RequestMapping("/info")
	public String info(Model model) {
		String formation = "Fullstack";
		model.addAttribute("workshop",formation);
	    return "home/info";
	}
	
    @RequestMapping("/affichage")
  	public String affiche(Model model) {
    	ArrayList<String> names = new ArrayList<String>();		// (clé, valeur)
		names.add("OCA");
		names.add("OCP");
		names.add("Spring");
		names.add("Angular");

		model.addAttribute("names",names);
  		return "home/personList";
  	}
    
 
}

