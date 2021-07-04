package Argonden.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Argonden.di.ui.ExamConsole;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("테스트");

		/*
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole();
//		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		console.print();
		 */

//		System.out.println(exam.toString());
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("Argonden/di/setting.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
//		ExamConsole lpConsole = (ExamConsole) context.getBean("console");
		ExamConsole lpConsole = context.getBean(ExamConsole.class);
		lpConsole.print();
//		System.out.println(lpConsole.toString());

	}

}
