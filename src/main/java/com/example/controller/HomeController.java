package com.example.controller;

import com.example.model.AddressbookEntry;
import com.example.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Manu on 10/10/2016.
 */
@Controller
public class HomeController {

    private final AddressbookService addressbookService;

    @Autowired
    public HomeController(final AddressbookService addressbookService) {
        this.addressbookService = addressbookService;
    }

    /**
     * get all persisted addressbook entries
     *
     * @ModelAttribute does not stand for mvc model but view-responsible data holder
     * @return list of {@link AddressbookEntry}, empty if no entries were found
     */
    @ModelAttribute("entries")
    public List<AddressbookEntry> getEntries() {
        return addressbookService.findAll();
    }

    /**
     * show the home page view
     * @return
     */
    @RequestMapping(path="/", method = RequestMethod.GET)
    public String showHomepage() {

        /* searches for template with name 'home' */
        return "home";
    }

    @RequestMapping(value= "/delete{id}", method = RequestMethod.GET)
    public String deleteEntry(@PathVariable("id") final String id) {
        this.addressbookService.delete(id);
        return "redirect:/";
    }
}
