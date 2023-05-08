package org.ibm.quarkus.data.resource;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ibm.quarkus.data.entity.User;

//Panache with DAO/Repository pattern
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    //put custom query
}