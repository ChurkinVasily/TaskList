package ru.churkin.tm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.churkin.tm.endpoint.*;

@Configuration
@ComponentScan("ru.churkin.tm")
public class AppClientConfig {

    @Bean
    public ProjectEndpoint projectEndpoint() {
        return new ProjectEndpointService().getProjectEndpointPort();
    }

    @Bean
    public TaskEndpoint taskEndpoint() {
        return new TaskEndpointService().getTaskEndpointPort();
    }

    @Bean
    public UserEndpoint userEndpoint() {
        return new UserEndpointService().getUserEndpointPort();
    }

    @Bean
    public SessionEndpoint sessionEndpoint() {
        return new SessionEndpointService().getSessionEndpointPort();
    }
}
