package com.events.apievents.controllers;

import com.events.apievents.entities.Event;
import com.events.apievents.models.Author;
import com.events.apievents.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private  AuthorService authorService;

    @RequestMapping(value = "/authors", method = GET)
    public List<Author> index() {
        return authorService.index();
    }

    @RequestMapping(value = "/authors/{id}", method = GET)
    public  Object get(@PathVariable(name = "id") String id){
        return authorService.get(id);
    }

    @RequestMapping(value = "/authors", method = POST)
    public Object save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @RequestMapping(value = "/authors/{id}", method = PUT)
    public  Author update(@RequestBody Author author, @PathVariable(name = "id") String id){
        return authorService.update(author, id);
    }

}
