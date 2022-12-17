# hackernews
#### Starting the Jetty server 
```
mvn jetty:run
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