package cass.creditanalysis;

import cass.creditanalysis.service.CreditAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class CreditAnalysisApplication {

    private CreditAnalysisService creditAnalysisService;

    public static void main(String[] args) {
        SpringApplication.run(CreditAnalysisApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            creditAnalysisService.analyze();
        };
    }

}
