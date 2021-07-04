package Argonden.di.ui;

import Argonden.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

	private Exam exam;
	
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}

	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("╔════════════╦═════════╗");
		System.out.println("║  total  ║  avg  ║");
		System.out.println("╠════════════╬══════════╣");
		System.out.printf("║    %d   ║   %f   ║\n", exam.total(), exam.avg());
		System.out.println("╚════════════╩═══════════╝");

	}

	@Override
	public void setExam(Exam exam) {
		// TODO Auto-generated method stub
		this.exam = exam;

	}

}
