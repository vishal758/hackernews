package com.graphql.hackernews;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;
import com.graphql.hackernews.mutation.Mutation;
import com.graphql.hackernews.query.Query;
import com.graphql.hackernews.repository.LinkRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {
    private static final LinkRepository linkRepository;

    static {
        // MongoClient mongo = new MongoClient();
        MongoDatabase mongoDatabase = new MongoClient().getDatabase("hackernews");
        linkRepository = new LinkRepository(mongoDatabase.getCollection("links"));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(new Query(linkRepository), new Mutation(linkRepository))
            .build()
            .makeExecutableSchema();
    }
}
