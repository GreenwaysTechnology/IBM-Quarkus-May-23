package org.ibm.quarkus.data.resource;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ibm.quarkus.data.entity.User;

import java.net.URI;
import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserRepository userRepository;

    @GET
    @WithSession
    public Uni<List<User>> get() {
        return userRepository.listAll();
    }
    //CURD operations
    @POST
    @Transactional
    @WithSession
    public Uni<String> create(User user){
        userRepository.persist(user);
        return Uni.createFrom().item("Saved");
    }
}