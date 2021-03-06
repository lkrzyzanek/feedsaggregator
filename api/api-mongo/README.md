# Feeds Aggregator Service API - mongo backend

Feeds Aggregator Service API with mongo backend and in-memory caching.

## REST API

REST API description
* `/rest/v1/search` - get latest blog posts (order by published date desc)
    optional request parameters:
  * from=0 - index of first returned item (for result-set paging, zero based)
  * size=10 - max number of returned items in the response, maximum is 100 (use result-set paging for more), (default 10)
  * sort=[asc|desc] - sorting oder of the result-set, they are always sorted by publishdate (default desc).
  * feed=feed_name - filter posts only for given feed, can be used multiple times to mix more feeds
  * feed_exclude=feed_name - filter posts NOT to contain given feed, can be used multiple times to exclude more feeds
  * group=group_name - filter posts only for given group, can be used multiple times to mix more groups
  * group_exclude=group_name - filter posts NOT to contain given group, can be used multiple times to exclude more groups
  * tag=tag_value - filter posts only for given tag, can be used multiple times to mix more tags
  * tag_exclude=tag_value - filter posts NOT to contain given tag, can be used multiple times to exclude more tags
  * content=[false|true] - controls if 'content' field is returned in the response, as it is a really huge field in most cases, so this can save lots of network bandwidth. 'contentPreview' is always available, so ask for full content only if you really need it (default false)
* `/rest/v1/post/{code}` - get blog-post based on its `code` field in mongo
* `/health` - health checks
* `/health/live` - liveness check
* `/health/ready` - readiness check. If MongoDB is down the check is down as well.

Example Search:

* http://localhost:8080/rest/v1/search?size=10&group=keycloak
* http://localhost:8080/rest/v1/post/5f858efcd36cf88d1ff331a4

Related URL's
* `/openapi` - OpenAPI/Swagger documentation of the REST API
* `/openapi?format=json` - OpenAPI/Swagger documentation of the REST API in JSON format
* `/swagger-ui` - Swagger UI for the REST API

## RSS Feeds API
* `/feed/v1` - RSS Atom Feed with blog posts (order by published desc). Optional request parameters:


## GraphQL API
* `/graphql` - GraphQL API
* `/graphql-ui` - GUI for GraphQL API introspection and testing


## Configuration

The app is configurable in Quarkus way. Any of [application.properties](src/main/resources/application.properties) can be overwritten.
The most important are:
* `quarkus.mongodb.connection-string` - mongo db connection string. See [Configuration reference](https://quarkus.io/guides/mongodb#configuration-reference)
* `app.mongo.db` - DB name
* `app.mongo.collection` - Collection name

## How to run app

The application is runnable using `java -jar target/restapi-mongo-runner.jar`.
