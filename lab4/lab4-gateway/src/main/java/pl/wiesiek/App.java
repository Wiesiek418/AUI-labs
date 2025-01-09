package pl.wiesiek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${pl.wiesiek.drivers.url}") String driversUrl,
            @Value("${pl.wiesiek.f1teams.url}") String formulaTeamsUrl,
            @Value("${pl.wiesiek.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("f1teams", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/formulaTeams",
                                "/api/formulaTeams/{id}"

                        )
                        .uri(formulaTeamsUrl)
                )
                .route("drivers", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/drivers",
                                "/api/drivers/**",
                                "/api/formulaTeams/{id}/drivers",
                                "/api/formulaTeams/{id}/drivers/**"
                        )
                        .uri(driversUrl)
                )
                .build();
    }

}
