package bootiful.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    DefaultSecurityFilterChain webSecurityConfigurer(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(e -> e.anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .build();
    }

/*    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .GET("/api/**", http("https://httpbin.org/uuid"))
                .filter(FilterFunctions.rewritePath("/api/(?<segment>.*)", "/$\\{segment}"))
                .build();
    }*/
}
