package ch.hearc.beershopfull.catalog.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.service.CatalogService;


/**
 * Controlleur lié au catalogue de bières
 * Une classe annoté @Controller, avec la librairie thymeleaf, permettra de retourner les noms des templates 
 * à service à l'utilisateur
 * @author Seb
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CatalogService catalogeService;
	
	/**
	 * Point d'entrée permettant de poster une nouvelle bière
	 * @param beer la bière à créér
	 * @param errors un objet contenant les erreurs éventuelles
	 * @param model le modèle de la page
	 * @return on redirige sur la page d'accueil. On redirige sur l'url, pas sur le template
	 */
	@PostMapping(value = "/save-beer")
	//notation alternative:
	//@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveBeer(@ModelAttribute Beer beer, BindingResult errors, Model model) {
	   catalogeService.addBeerToCatalog(beer);
       return "redirect:/admin";
    }
	
	/**
	 * Retourn le template de création des bières
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = "/new-beer")
	public String showNewBeerForm(Model model) {
	    model.addAttribute("beer", new Beer());
		return "new-beer";
	}

    /**
	 * Retourn le template de création des bières
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = "/edit/{id}")
	public String showUpdateBeerForm(@PathVariable int id, Model model)
	{
	    model.addAttribute("beer", catalogeService.getBeerById(new BigInteger("" + id)));
        model.addAttribute("isEdit", true);
		return "new-beer";
	}

    /**
     * Point d'entrée permettant de modifier une bière
     * @param beer
     * @param errors
     * @param model
     * @return
     */
    @PostMapping(value = "/update")
    public String updateBeerInDB(@ModelAttribute Beer beer, BindingResult errors, Model model)
	{
        catalogeService.updateBeerInCatalog(beer);
        return "redirect:/admin";
    }

    /**
     * Supprime une bière
     * @param id
     * @param model
     * @return
     */
    @PostMapping(value = "/delete")
    public String removeBeerInDB(@ModelAttribute("id") Integer id, Model model)
	{
        catalogeService.removeBeerInCatalog(catalogeService.getBeerById(new BigInteger(id.toString())));
        return "redirect:/admin";
    }

	/**
	 * Retourne le template de création de la page d'administration
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = "")
	public String showAdminBeersPage(Model model)
	{
	    model.addAttribute("beers", catalogeService.getAllBeersFromCatalog());   
		return "admin";
	}
}
