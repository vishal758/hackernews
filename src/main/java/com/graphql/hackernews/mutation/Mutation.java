package com.graphql.hackernews.mutation;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.hackernews.pojo.AuthData;
import com.graphql.hackernews.pojo.Link;
import com.graphql.hackernews.pojo.User;
import com.graphql.hackernews.repository.LinkRepository;
import com.graphql.hackernews.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    @Autowired
    public Mutation(final LinkRepository linkRepository, final UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }
    
     public Link createLink(final String url, final String description) {
         final Link newLink = Link.builder()
             .url(url)
             .description(description)
             .build();
         linkRepository.save(newLink);
         return newLink;
     }

    public User createUser(final String name, final AuthData auth) {
         final User newUser = User.builder()
             .name(name)
             .email(auth.getEmail())
             .password(auth.getPassword())
             .build();
         userRepository.save(newUser);
         return newUser;
     }
}
