package com.events.apievents.services.implement;

import com.events.apievents.models.Author;
import com.events.apievents.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private Author author;

    private RestTemplate authorTemplate = new RestTemplate();
    private String BASE_URI = "http://10.0.16.239:4000/";

    @Override
    public List<Author> index() {
        ResponseEntity<List<Author>> result =  authorTemplate.exchange(BASE_URI + "authors", GET, null, new ParameterizedTypeReference<List<Author>>() {
        });
        return result.getBody();
    }

    @Override
    public Author save(Author author) {
        return authorTemplate.postForObject(BASE_URI + "authors/", author,Author.class);
    }

    @Override
    public Author get(String id) {
        return authorTemplate.getForObject(BASE_URI + "authors/" + id, Author.class);
    }

    @Override
    public Author update(Author author, String id) {
        Author _author = this.get(id);
        _author.setName( (author.getName() != null ) ? author.getName() : _author.getName() );
        _author.setEmail( (author.getEmail() != null ) ? author.getEmail() : _author.getEmail() );
        _author.setWebsite( (author.getWebsite() != null ) ? author.getWebsite() : _author.getWebsite() );
        _author.setCity( (author.getCity() != null ) ? author.getCity() : _author.getCity() );
        _author.setCountry( (author.getCountry() != null ) ? author.getCountry() : _author.getCountry() );
        authorTemplate.put(BASE_URI + "authors/" + id, _author);
        return this.get(id);
    }
}
