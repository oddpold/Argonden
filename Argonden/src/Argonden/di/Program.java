package Argonden.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Argonden.di.ui.ExamConsole;


public class Program {

	/*
	 * 선선언 후사용을 하지 않으면 resource leak이라는 경고가 나온다
	 */
	private static ApplicationContext   context;

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
		context = new AnnotationConfigApplicationContext(DIConfig.class);
//		ExamConsole lpConsole = (ExamConsole) context.getBean("console");
		ExamConsole lpConsole =   context.getBean(ExamConsole.class);
		lpConsole.print();
//		System.out.println(lpConsole.toString());

	}

}
