package com.ilya;

import com.ilya.config.SpringConfig;
import com.ilya.services.CLIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan("com.ilya")
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CLIService service = context.getBean(CLIService.class);

        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            service.execute(command);
        }
    }
}
