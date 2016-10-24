package com.example.web;

import com.example.model.AddressbookEntry;
import com.example.service.AddressbookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * MVC controller to edit entries
 */
@Controller
public class EditEntryController {

    private final AddressbookService addressbookService;

    @Autowired
    public EditEntryController(final AddressbookService addressbookService) {
        this.addressbookService = addressbookService;
    }

    /**
     * Show edit view for entries
     *
     * @param id of the entry to be edited
     * @return view and model for editiong
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    /* until now (in HomeController) return value has been a string. Now we also need to transfer the complete model (HTML side model inside view) with all its entries */
    public ModelAndView showEditPage(@PathVariable("id") final String id) {

        final AddressbookEntry entry = this.addressbookService.findById(id);

        /* if id does not exist -> redirect to homepage */
        if (entry == null) {
            return new ModelAndView("redirect:/");
        } else {
            final ModelAndView view = new ModelAndView("edit");
            view.addObject("entry", entry);

            return view;
        }
    }

    /**
     * delete given entry
     *
     * @param id of the entry
     * @return list of entries
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEntry(@PathVariable("id") final String id) {
        this.addressbookService.delete(id);
        return "redirect:/";
    }


    /**
     * Show view for creating new entries
     *
     * @return view to create new entries
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showEditPageForNewEntry() {

        final ModelAndView view = new ModelAndView("edit");
        view.addObject("entry", new AddressbookEntry());
        return view;

    }


    /**
     * Edit button pressed
     *
     * @param entry
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEntry(final AddressbookEntry entry) {
        this.addressbookService.save(entry);
        return "redirect:/";
    }
}
