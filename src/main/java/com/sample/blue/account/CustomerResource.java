package com.sample.blue.account;

import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.metrics.annotation.Timed;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    private final CustomerDAO dao;

    @Inject
    public CustomerResource(CustomerDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    @UnitOfWork
    public List<Customer> all() {
        return dao.findAll();
    }
}