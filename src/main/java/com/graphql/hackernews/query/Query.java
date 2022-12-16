package com.graphql.hackernews.query;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphql.hackernews.pojo.Link;
import com.graphql.hackernews.repository.LinkRepository;

public class Query implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;

    public Query(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks() {
        return linkRepository.getAllLinks();
    }

}
