package com.example.controller;

import com.example.model.AddressbookEntry;
import com.example.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
     * @ModelAttribute does not stand for mvc model but view-responsible data holder
     * @return list of {@link AddressbookEntry}
     */
    @ModelAttribute("entries")
    public List<AddressbookEntry> getEntries() {
        return addressbookService.findAll();
    }


    @RequestMapping(path="/", method = RequestMethod.GET)
    public String showHomepage() {

        /* searches for template with name 'home' */
        return "home";
    }
}
