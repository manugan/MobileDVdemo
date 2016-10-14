package com.example.data;

import com.example.model.AddressbookEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Manu on 13/10/2016.
 *
 * automaitcally creates the reuqired repository
 */
public interface AddressbookEntryRepository extends MongoRepository<AddressbookEntry, String> {


}
