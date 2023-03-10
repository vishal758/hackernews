package com.graphql.hackernews.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "links")
public class Link {
    @Id
    private String id;
    private String url;
    private String description;
}
