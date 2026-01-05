package com.medori42.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class RoutingGatewayApplication {
    public static void main(String[] launchArguments) {
        SpringApplication.run(RoutingGatewayApplication.class, launchArguments);
    }
    @Bean
    DiscoveryClientRouteDefinitionLocator configureRouteDiscovery(
            ReactiveDiscoveryClient reactiveClient,
            DiscoveryLocatorProperties locatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(reactiveClient, locatorProperties);
    }
}