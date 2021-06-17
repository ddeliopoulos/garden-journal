package ddeliopoulos.github.gardenjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

public class GardenJournalApplication {

    public static void main(final String... args) {
        ConfigurableApplicationContext run = SpringApplication.run(GardenJournalApplication.class, args);
    }

}
