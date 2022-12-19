# hackernews
#### Starting the Springboot server 
```
mvn spring-boot:run
```

#### Syntaxes
###### Query syntax to get allLinks
```
{
  allLinks {
    url
    description
  }
}
```

###### Mutation to create a new link

```
mutation createLink {
  createLink(url: "http://howtographql.com", description: "lorem ispum") {
    url
  }
}
```


###### Mutation to create a new user

```
mutation createUser {
    createUser(name: "Bojak Horseman", authData: {
        email: "bojak@example.com",
        password: "password"
    }) {
        name
    }
}
```

###### Query syntax to get allUsers
```
{
  allUsers {
    name
    email
  }
}
```

###### Query syntax to get user by email
```
{
    getUserByEmail(email: "bojak@example.com") {
        id
        name
        email
    }
}
```

###### Query syntax to get user by id
```
{
    getUser(id: "63a091b6fa98717bfc678850") {
        id
        name
        email
    }
}
```
