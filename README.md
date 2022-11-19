                              Simple SpringBoot Rest CRUD API based on Asset Management System.

It has two entity which is just a plain old java object exposing basic CRUD services
1. Category

       a. Create new category             [URL : http://localhost:8080/category],        [Request Type : POST]
       b. Update a category               [URL : http://localhost:8080/category/id],     [Request Type : PUT]
       c. Get list of all category        [URL : http://localhost:8080/category],        [Request Type : GET]
       d. Get category by its id          [URL : http://localhost:8080/category/id],     [Request Type : GET]
       e. Delete a category               [URL : http://localhost:8080/category/id],     [Request Type : DELETE]


2. Asset

       a. Create new asset              [URL : http://localhost:8080/asset],        [Request Type : POST]
       b. Update an asset               [URL : http://localhost:8080/asset/id],     [Request Type : PUT]
       c. Get list of all asset         [URL : http://localhost:8080/asset],        [Request Type : GET]
       d. Get asset by its name         [URL : http://localhost:8080/asset/id],     [Request Type : GET]
       e. Delete an asset               [URL : http://localhost:8080/asset/id],     [Request Type : DELETE]
       

Technology Used : Java, Spring Boot, Spring Data JPA, H2 database
