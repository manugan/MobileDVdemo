package com.example.web;

import com.example.model.AddressbookEntry;
import com.example.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * MVC web for the home page
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
     * @return list of {@link AddressbookEntry}, empty if no entries were found
     * @ModelAttribute does not stand for mvc model but view-responsible data holder
     */
    @ModelAttribute("entries")
    public List<AddressbookEntry> getEntries() {
        return addressbookService.findAll();
    }

    /**
     * show the home page view
     *
     * @return the name of the home page view
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showHomepage() {

        /* searches for template with name 'home' */
        return "home";
    }

    /**
     * Delete the entry with the specified id
     * path variable is shown as get variable in URL
     *
     * @param id of the entry
     * @return the redirect url
     */
    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public String deleteEntry(@PathVariable("id") final String id) {
        this.addressbookService.delete(id);
        return "redirect:/";
    }


    /**
     * Search for pattern variable in LastName
     *
     * @param pattern
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    /* model: list of entries, view: home view */
    public ModelAndView searchByLastName(@RequestParam("pattern") final String pattern) {

        final ModelAndView view = new ModelAndView("home");
        view.addObject("entries", this.addressbookService.findByLastNameLike(pattern));

        return view;
    }
}
