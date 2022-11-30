package ch.hearc.beershopfull.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ch.hearc.beershopfull.catalog.service.CatalogService;


/**
 * Controlleur lié au catalogue de bières
 * Une classe annoté @Controller, avec la librairie thymeleaf, permettra de retourner les noms des templates 
 * à service à l'utilisateur
 * @author Seb
 *
 */
@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogeService;
	
	/**
	 * Retourne le template de création de la page d'accueil
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = {"/","/accueil"})
	public String showAccueilPage(Model model)
	{
	    model.addAttribute("beers", catalogeService.getAllBeersFromCatalog());   
		return "accueil";
	}
}
