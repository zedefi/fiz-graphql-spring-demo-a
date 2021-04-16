package com.fiz.demo.a.resolves;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fiz.demo.a.pojo.Hello;
import com.fiz.demo.a.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    HelloService helloService;

    public Hello hello() {

        Hello h = new Hello();
        h.setMessage("hello");

        return h;
    }

    public List<Hello> allData() {
        return helloService.getAll();
    }
}
