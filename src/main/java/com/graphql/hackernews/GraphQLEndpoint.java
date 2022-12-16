package com.graphql.hackernews;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.SimpleGraphQLServlet;

public class GraphQLEndpoint extends SimpleGraphQLServlet {
    public GraphQLEndpoint() {
        super(SchemaParser.newParser()
                .file("schema.graphqls") //parse the schema file created earlier
                .build()
                .makeExecutableSchema());
    }
}
