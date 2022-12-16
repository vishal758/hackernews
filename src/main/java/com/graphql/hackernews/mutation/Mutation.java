package com.graphql.hackernews.mutation;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphql.hackernews.pojo.Link;
import com.graphql.hackernews.repository.LinkRepository;

public class Mutation implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;

    public Mutation(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    
    public Link createLink(final String url, final String description) {

        final Link newLink = Link.builder()
            .url(url)
            .description(description)
            .build();
        linkRepository.saveLink(newLink);
        return newLink;
    }
}
