package com.ensat.controllers;

import com.ensat.entities.People;
import com.ensat.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/peoples", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("peoples", peopleService.listAllPeoples());
        System.out.println("Returning peoples:");
        return "peoples";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("people/{id}")
    public String showPeople(@PathVariable Integer id, Model model) {
        model.addAttribute("people", peopleService.getPeopleById(id));
        return "peopleshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("people/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("people", peopleService.getPeopleById(id));
        return "peopleform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("people/new")
    public String newPeople(Model model) {
        model.addAttribute("people", new People());
        return "peopleform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "people", method = RequestMethod.POST)
    public String savePeople(People people) {
    	peopleService.savePeople(people);
        return "redirect:/people/" + people.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("people/delete/{id}")
    public String delete(@PathVariable Integer id) {
    	peopleService.deletePeople(id);
        return "redirect:/peoples";
    }

}
