package com.graphql.hackernews.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Link {
    private final String id;
    private final String url;
    private final String description;
}
