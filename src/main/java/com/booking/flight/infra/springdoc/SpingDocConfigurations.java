package com.booking.flight.infra.springdoc;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpingDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Booking flight")
                .description("API Rest criada contendo CRUD de reserva de viagem" +
                        "Passageiro, voo e aviao")
                .contact(new Contact()
                        .name("Jackson Santos")
                        .email("jacksonsdss@gmail.com"))
                .license(new License()
                        .name("Jackson")
                        .url("https://jacksuh.github.io/portifolio-page/")));
    }
}
