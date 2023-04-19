package ru.mpei.springdata;

import org.h2.tools.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mpei.springdata.repository.StudentRepository;
import ru.mpei.springdata.service.Service;

import java.sql.SQLException;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        Service service = context.getBean(Service.class);

        //Console.main(args);
        System.out.println(service.formatResult("E-12-24"));
    }

}
