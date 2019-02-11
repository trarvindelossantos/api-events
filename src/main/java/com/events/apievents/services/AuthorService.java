package com.events.apievents.services;


import com.events.apievents.models.Author;

import java.util.List;

public interface AuthorService {

    List<Author> index();

    Author save(Author author);

    Author get(String id);

    Author update(Author author, String id);






}

