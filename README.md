# Read Me
This is a sample to solve **github issue** : https://github.com/spring-cloud/spring-cloud-openfeign/issues/814

This is the backend API bounded to a fake DB.

# Getting Started

Start the api as a SpringBootApplication, with a JDK 19.

**Swagger url** : http://localhost:8090/api/swagger-ui/index.html


### Step to reproduce
Start the other API : **com.example.api.bff-my-app**, and use the endpoint GET / http://localhost:8091/api/v1.0/users/?page=0&size=5&sort=lastName%2CASC
