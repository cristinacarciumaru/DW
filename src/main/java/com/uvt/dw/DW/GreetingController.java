package com.uvt.dw.DW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class GreetingController {
    @Autowired
    private GreetRepository greetRepository;


    @GetMapping(value = "/greeting")
    @ResponseBody
    public List<Greeting> greeting() {
        List<Greeting> greetings = new ArrayList<>();
        greetRepository.findAll().forEach(e->greetings.add(e));
        return greetings;
    }

    @GetMapping(value = "/greeting/{user}/")
    @ResponseBody
    public List<Greeting> greetingUserLimit(@PathVariable String user,Integer limit) {
        List<Greeting> greetings = new ArrayList<>();
        greetRepository.findByUser(user,limit).forEach(e -> greetings.add(e));
        return greetings;
    }

    @GetMapping(value = "/asset")
    @ResponseBody
    public List<Greeting> getAsssetTable() {
        List<Greeting> greetings = new ArrayList<>();
        greetRepository.selectAsset().forEach(e -> greetings.add(e));
        return greetings;
    }

    @GetMapping(value = "/attribute")
    @ResponseBody
    public List<Greeting> getAttribute() {
        List<Greeting> greetings = new ArrayList<>();
        greetRepository.selectAttribute().forEach(e -> greetings.add(e));
        return greetings;
    }

    @PostMapping(value = "/greeting")
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        greetRepository.save(greeting);
        return "OK";
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public String createTable() {
        greetRepository.createTable();
        return "OK - test table created";
    }

    @PostMapping(value = "/createAsset")
    @ResponseBody
    public String createAsset() {
        greetRepository.createAssetTable();
        return "OK - Assets table created";
    }

    @PostMapping(value = "/createAttribute")
    @ResponseBody
    public String createAttribute() {
        greetRepository.createAttributeTable();
        return "OK - Attribute table created";
    }
}