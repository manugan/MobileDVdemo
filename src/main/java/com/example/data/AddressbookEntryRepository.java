package com.example.data;

import com.example.model.AddressbookEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Manu on 13/10/2016.
 * MongoRepository delivers complete CRUD-functionality: Create:Update:Delete
 *
 * automatically creates the required repository
 */
public interface AddressbookEntryRepository extends MongoRepository<AddressbookEntry, String> {


}
