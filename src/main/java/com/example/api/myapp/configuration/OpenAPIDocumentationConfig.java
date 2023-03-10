package com.example.api.myapp.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIDocumentationConfig {

    @Autowired
    private ConfigProperties configProperties;

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("v1.0")
                .pathsToMatch("/v1.0/**")
                .build();
    }

    @Bean
    public OpenAPI myAppOpenAPI() {
        // No security
        return new OpenAPI()
                .info(new Info().title("API My App")
                        .description("A simple description")
                        .version("1.0")
                        .license(new License().name("Issue Github 814").url("https://github.com/spring-cloud/spring-cloud-openfeign/issues/814")));
    }

    /**
     * Connecteur AJP utilisé par Apache pour avoir une url sans port
     *
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
        return server -> {
            if (Boolean.TRUE.equals(configProperties.getTomcat().getEnableAjp()) && server instanceof TomcatServletWebServerFactory) {
                server.addAdditionalTomcatConnectors(redirectConnector());
            }
        };
    }

    private Connector redirectConnector() {
        var connector = new Connector("AJP/1.3");
        connector.setScheme("http");
        connector.setPort(configProperties.getTomcat().getAjpPort());
        connector.setSecure(false);
        connector.setAllowTrace(true);
        ((AbstractAjpProtocol<?>) connector.getProtocolHandler()).setSecretRequired(false);

        return connector;
    }

}
