package gatiiatullin_dinar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan({"gatiiatullin_dinar"})
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);

        //final String url = "https://dombulgakova.ru/";

        // new ForkJoinPool().invoke(new ParserSite(url));

    }
}
