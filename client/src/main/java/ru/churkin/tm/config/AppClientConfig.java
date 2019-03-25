package ru.churkin.tm.config;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.churkin.tm.api.TerminalService;
import ru.churkin.tm.endpoint.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
