package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("customers")
public class CustomerResource {

    @Inject
    CustomerService customerService;
    @Inject
    ProductService productService;
    @GET
    @Path("products")
    public String getProducts() {
        return productService.getProducts();
    }

    @GET
    public String getCustomers() {
        return customerService.getCustomers();
    }
}
