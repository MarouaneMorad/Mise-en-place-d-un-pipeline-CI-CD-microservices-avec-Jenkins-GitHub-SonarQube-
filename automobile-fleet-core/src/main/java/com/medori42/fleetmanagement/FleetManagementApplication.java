package com.medori42.fleetmanagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class FleetManagementApplication {
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    private static final int HTTP_READ_TIMEOUT = 5000;
    public static void main(String[] commandLineArgs) {
        SpringApplication.run(FleetManagementApplication.class, commandLineArgs);
    }
    @Bean
    public RestTemplate httpRestTemplate() {
        RestTemplate restTemplateInstance = new RestTemplate();
        SimpleClientHttpRequestFactory httpRequestConfiguration = new SimpleClientHttpRequestFactory();
        httpRequestConfiguration.setConnectTimeout(HTTP_CONNECTION_TIMEOUT);
        httpRequestConfiguration.setReadTimeout(HTTP_READ_TIMEOUT);
        restTemplateInstance.setRequestFactory(httpRequestConfiguration);
        return restTemplateInstance;
    }
}