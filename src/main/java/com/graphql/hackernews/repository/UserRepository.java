package com.graphql.hackernews.repository;

import com.graphql.hackernews.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    User findByEmail(String email);
}
