package com.example.service;

import com.example.data.AddressbookEntryRepository;
import com.example.model.AddressbookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Manu on 13/10/2016.
 */
@Service
public class AddressbookService {

private final AddressbookEntryRepository addressbookEntryRepository;


    //on create: make sure that reference on correct Repository is transfered to htis Service class
    @Autowired
    public AddressbookService(final AddressbookEntryRepository addressbookEntryRepository) {
        this.addressbookEntryRepository = addressbookEntryRepository;
    }

    /**
     * get all DB entries
     * @return
     */
    public List<AddressbookEntry> findAll(){
        return addressbookEntryRepository.findAll();
    }

}
