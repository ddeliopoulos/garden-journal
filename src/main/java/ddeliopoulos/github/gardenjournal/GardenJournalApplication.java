package ddeliopoulos.github.gardenjournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

public class GardenJournalApplication {

    public static void main(final String... args) {
        SpringApplication.run(GardenJournalApplication.class, args);
    }
}
