package com.example.SBoot.controller;

import com.example.SBoot.entity.Customer;
import com.example.SBoot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

    @Autowired
    private CustomerRepository cr;

    @GetMapping(path="/")
    public String index()
    {
        System.out.println("Console: This is a simple test of Spring Boot");
        return "This is a simple test of Spring Boot";
    }

    @PostMapping(path="/save")
    public String saveCustomer()
    {
        Customer c = new Customer("Med", "Ou");
        cr.save(c);
        return c.toString();
    }

    @GetMapping(path="/get/{id}")
    public String getCustomerById(@PathVariable(value="id") long id)
    {
        Customer c = cr.findById(id);
        return c.toString();
    }

    @GetMapping(path="/get/fname/{fname}")
    public String getCustomerByFirstName(@PathVariable(value="fname") String fname)
    {
        Iterable<Customer> customers = cr.findByFirstName(fname);
        for (Customer c : customers ) {
            if(c != null)
            {
                System.out.println(c.toString());
            }
        }
        return "";
    }

    @GetMapping(path="/get/lname/{lname}")
    public String getCustomerByLastName(@PathVariable(value="lname") String lname)
    {
        Iterable<Customer> customers = cr.findByLastName(lname);
        for (Customer c : customers ) {
            if(c != null)
            {
                System.out.println(c.toString());
            }
        }
        return "";
    }
}
