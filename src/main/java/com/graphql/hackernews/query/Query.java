package com.graphql.hackernews.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.hackernews.pojo.Link;
import com.graphql.hackernews.pojo.User;
import com.graphql.hackernews.repository.LinkRepository;
import com.graphql.hackernews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    private final LinkRepository linkRepository;

    @Autowired
    public Query(final UserRepository userRepository, final LinkRepository linkRepository) {
        this.userRepository = userRepository;
        this.linkRepository = linkRepository;
    }

     public List<User> allUsers() {
         return (List<User>) userRepository.findAll();
     }

    public List<Link> allLinks() {
        return (List<Link>) linkRepository.findAll();
    }

     public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email);
     }

     public User getUser(final String id) {
        return userRepository.findById(id).orElseThrow(null);
     }

}
