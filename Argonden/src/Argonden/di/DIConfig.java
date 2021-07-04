package Argonden.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import Argonden.di.entity.Exam;
import Argonden.di.entity.NewlecExam;


@ComponentScan({"Argonden.di.ui", "Argonden.di.entity"})
@Configuration
public class DIConfig {

	@Bean
	public Exam exam() {
		System.out.println("DIConfig:exam()");
		return new NewlecExam();
	}
}
