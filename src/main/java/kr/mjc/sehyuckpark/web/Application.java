package kr.mjc.sehyuckpark.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // Scan WebServlet
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}