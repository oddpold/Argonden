package Argonden.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Argonden.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	@Autowired
	private Exam exam;

	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
		System.out.println("InlineExamConsole:basic constructor");
	}

	public InlineExamConsole(Exam exam) {
		System.out.println("InlineExamConsole:overoaded constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("print");
		if (exam == null)
			System.out.printf("total = %d, avg = %f\n", 0, 0.0);
		else
			System.out.printf("total = %d, avg = %f\n", exam.total(), exam.avg());

	}

	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		System.out.println("InlineExamConsole:setter");
		this.exam = exam;

	}

	
}
