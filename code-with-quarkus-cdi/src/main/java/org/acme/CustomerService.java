package org.acme;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

    public String getCustomers(){
        return "Customers";
    }
}
