package com.dobudobu.article_management_service.Config;

import com.dobudobu.article_management_service.Client.FileClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${file-service.url}")
    private String fileServiceUrl;

    @Bean
    public FileClient fileClient(){
        RestClient restClient = RestClient.builder()
                .baseUrl(fileServiceUrl)
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(FileClient.class);
    }

}
