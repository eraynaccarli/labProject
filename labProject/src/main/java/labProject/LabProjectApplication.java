package labProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import labProject.controller.PatientController;

@SpringBootApplication
public class LabProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabProjectApplication.class, args);
	}

}
