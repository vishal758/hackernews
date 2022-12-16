package com.graphql.hackernews.repository;

import java.util.ArrayList;
import java.util.List;

import com.graphql.hackernews.pojo.*;

public class LinkRepository {
    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
        links.add(new Link("http://graphql.org/learn/", "The official docks"));
    }

    public List<Link> getAllLinks() {
        return links;
    }
    
    public void saveLink(Link link) {
        links.add(link);
    }
}
