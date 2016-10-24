package com.example.data;

import com.example.model.AddressbookEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Manu on 13/10/2016.
 * MongoRepository delivers complete CRUD-functionality: Create:Update:Delete
 *
 * automatically creates the required repository
 */
@Repository
public interface AddressbookEntryRepository extends MongoRepository<AddressbookEntry, String> {

/* automatically gets recognized by MongoDB to be a 'Like' statement on 'LastName'
 PROBLEM: Upper/Lowercase is not ignored by this automatic function
 */
    List<AddressbookEntry> findByLastNameLike(String pattern);
}
