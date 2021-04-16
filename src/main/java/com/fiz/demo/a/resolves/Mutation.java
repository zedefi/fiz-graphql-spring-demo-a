package com.fiz.demo.a.resolves;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.fiz.demo.a.pojo.Hello;
import com.fiz.demo.a.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    HelloService service;

    public Hello add(String message) {
        return service.add(message);
    }
}
