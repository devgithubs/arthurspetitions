package ie.nuigalway.ct5171;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ArthursPetitionsApplication extends SpringBootServletInitializer {

    // used when running as a WAR inside Tomcat
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ArthursPetitionsApplication.class);
    }

    // used when running from IntelliJ (fat jar)
    public static void main(String[] args) {
        SpringApplication.run(ArthursPetitionsApplication.class, args);
    }
}
