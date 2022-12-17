package com.graphql.hackernews.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.graphql.hackernews.pojo.*;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

public class LinkRepository {

    private final MongoCollection<Document> links;

    public LinkRepository(MongoCollection<Document> links) {
        this.links = links;
    }

    public Link findById(final String id) {
        final Document doc = links.find(eq("_id", new ObjectId(id))).first();
        return link(doc);
    }

    public List<Link> getAllLinks() {
        final List<Link> allLinks = new ArrayList<>();
        for (Document doc : links.find()) {
            allLinks.add(link(doc));
        }
        return allLinks;
    }

    public void saveLink(final Link link) {
        final Document doc = new Document();
        doc.append("url", link.getUrl());
        doc.append("description", link.getDescription());
        links.insertOne(doc);
    }

    private Link link(Document doc) {
        return Link.builder()
            .id(doc.get("_id").toString())
            .url(doc.getString("url"))
            .description(doc.getString("description"))
            .build();
    }
}
