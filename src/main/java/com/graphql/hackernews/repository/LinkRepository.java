package com.graphql.hackernews.repository;

import com.graphql.hackernews.pojo.Link;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends PagingAndSortingRepository<Link, String> {

}
