# Migrateway

This a unified backend application based on microservices architecture, that acts both as 
* A spring boot service which allows for migrating data (using specific data models) between database services using HTTP protocol
AND
* A gateway which redirects requests to individual downstream database serivce from the same domain, without requiring users to independantly interact with each service

The React based frontend for this application can be found here - https://github.com/AnkurDesai11/adminportal

## Authentication and Authorisation

The entire full stack application along with the frontend is protected using OAuth with Okta as the Authentication provider. 

Successful sign in to the frontend application generates a jwt token which has the role sassigned to the user with Okta groups. 

This jwt token is required by migrateway service and the roles are extracted on incoming requests and accordingly user will be able to access certain api endpoints.

Each request is checked for bearer token based authentication and calls other than GET requests are checked for role based authorisation using the roles mentioned in the bearer token.

All the cxommunicaiton between the frontend and this service are therfore protected using bearer token, and the communication between the gateway and downstream services protected by api key which are passed in the header. This allows for end to end security from the forntend all the way to individual microservices.

## Spring Boot Migration Service

Migration service requires Super Admin group role to be assinged in Okta to both the frontend application and the backend application. This allows the user to request data to b e migrated among databases. 

Multiple migrations can be operational simultaneously but one database service can only act as the destination(under write operation) in one ongoing migrations, new request having a database service (as source or destination), which is already a destination in a current ongoing migration will not start and will be queued up.

3 migrations can be queued up apart from the current ongoing migrations.

Migrations are done using Single Producer Single Consumer process using BlockingQueue queue implementation in Java. This allows independant fetching and posting of data, especially useful when the individual services have different pagination capabilities.

Updates of the current ongoing migrations are pushed to the frontend using websocket messaging.

## Gateway Service

The unified gateway service using yml configuration file allows url masking so that request to individual down-stream services which aren't migration related but rather admin related (like crud operation on the indivdual databases) can be redirected accordingly. This allows thew admin protal to perform individual administrator dutites on individual databases.

Cofigurations also allow protection of database microservices using header based api token for security.

This service can be integrated with eureka hytersics dashboard for monitering and itself is a eureka client that can be registered with eureka server similar to down-stream database services.
