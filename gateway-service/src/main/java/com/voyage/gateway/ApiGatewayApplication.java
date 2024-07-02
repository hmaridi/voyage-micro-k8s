package com.voyage.gateway;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
//@OpenAPIDefinition(info =
//@Info(title = "Gateway Service API", version = "1.0", description = "Documentation Gateway Service API v1.0")
//)
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

	@Bean
	@Lazy(false)
	public Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> apis(RouteDefinitionLocator locator,
																  SwaggerUiConfigParameters swaggerUiConfigParameters) {
		Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
			String name = routeDefinition.getId().replaceAll("-service", "");
			AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl = new AbstractSwaggerUiConfigProperties.SwaggerUrl(name, "/" + name, null);
			urls.add(swaggerUrl);
		});
		swaggerUiConfigParameters.setUrls(urls);
		return urls;
	}
}
