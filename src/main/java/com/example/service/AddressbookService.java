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
     * retrieves all persisted entries
     *
     * @return an empty list if no entries were found
     */
    public List<AddressbookEntry> findAll() {
        return addressbookEntryRepository.findAll();
    }

    /**
     * Find the entry by the given id
     *
     * @param id of the entry
     * @return returns <code>null</code> if no such entry exists
     */
    public AddressbookEntry findById(final String id) {
        return addressbookEntryRepository.findOne(id);
    }

    /**
     * Deletes the entry with the given id
     *
     * @param id of the entry
     */
    public void delete(final String id) {
        this.addressbookEntryRepository.delete(id);
    }

    /**
     * save one {@link AddressbookEntry}
     *
     * @param entry given
     * @return the persisted entry
     */
    public AddressbookEntry save(final AddressbookEntry entry) {
        if ("".equals(entry.getId())) {
            entry.setId(null);
        }
        return this.addressbookEntryRepository.save(entry);
    }

    public List<AddressbookEntry> findByLastNameLike(String pattern) {
        return addressbookEntryRepository.findByLastNameLike(pattern);
    }
}
