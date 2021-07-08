package Argonden.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Argonden.aop.entity.Exam;
import Argonden.aop.entity.NewlecExam;
import Argonden.di.DIConfig;

public class Program {

	/*
	 * 선선언 후사용을 하지 않으면 resource leak이라는 경고가 나온다
	 */
	private static ApplicationContext   context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * day 11
		 * AOP : Aspect Oriented Programming
		 * #ifdef _DEBUG와 같이 테스트용 코드를 넣을 경우 사용할 수 있다
		 * 주석 처리한 것처럼 작성을 하지 않고, proxy를 이용해서 객체를 사용한다
		 * 헐...프로젝트 익스플로러에서 ctrl+c, ctrl+v 하면 클래스, 패키지가 복사가 된다...
		 * 이건 순수 java를 이용한 AOP
		 */
		
//		Exam exam = new NewlecExam(1, 2, 3, 4);
//		System.out.println(exam.toString());
//		System.out.printf("total is %d\n", exam.total());
		
		/*
		 * InvocationHandler()를 사용하기 위해서 익명클래스를 만들어서 
		 * 사이드업무를 하기 위한 객체의 정보를 주면 거기에 맞는 proxy instance가 만들어진다
		 * invoke(함수포인터인가...?)에 사이드업무를 구현한다
		 * 사용할 클래스는 getClassLoader()를 붙여주고, 
		 * 인터페이스 클래스를 배열로 주고, 
		 * method.invoke()에서 인터페이스 클래스를 지정하고 오브젝트 배열을 넣어주면
		 * 클래스 내의 함수가 매핑이 된다. 전부 최상위 클래스인 오브젝트 클래스 소속이니까...
		 * 그렇게 함수 포인터가 만들어지므로 똑같이 호출 해서 쓰면 된다
		 */
//		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), 
//				new Class[] {Exam.class}, 
//				new InvocationHandler() {
//					
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						// TODO Auto-generated method stub
//						long start = System.currentTimeMillis();
//						
//						Object result = method.invoke(exam, args);
//						
//						long end = System.currentTimeMillis();
//						
//						String message = "calculated time is " + (end - start) + " ms";
//						System.out.println(message);
//
//						return result;
//					}
//				}
//			);
//		
//		System.out.printf("total is %d\n", proxy.total());
//		System.out.printf("avg is %f\n", proxy.avg());

		/*
		 * AOP of Spring
		 * 1. Before Advice : 사이드업무를 앞에 끼운다
		 * 2. After returning Advice : 사이드업무를 뒤에 끼운다
		 * 3. After throwing Advice : 사이드업무를 예외처리 후에 끼운다
		 * 4. Around Advice : 사이드업무를 앞뒤로 끼운다. 위의 예제처럼
		 * 스프링을 이용해서 AOP를 구현한다. DI 할 때와 마찬가지로 xml에 구현한다
		 * 익명클래스로 proxy를 구현 했던 것을 LogAroundAdvice 클래스와 xml로 정의한다
		 * 그러면 소스 수정 없이 xml에서 객체의 이름과 설정만 바꿈으로 다른 기능을 추가 할 수 있다
		 * PointCut 기능을 이용해서 특정 함수만 기능을 수행 하도록 할 수도 있다 (xml 참조)
		 * classicadvisor를 이용하는 방법. 기능은 좋은데 복잡하다
		 */
		context = new ClassPathXmlApplicationContext("Argonden/aop/setting.xml");
//		context = new AnnotationConfigApplicationContext(DIConfig.class);

		Exam exam = (Exam) context.getBean("exam");

		System.out.printf("total is %d\n", exam.total());
		System.out.printf("avg is %f\n", exam.avg());

		
		/*
		 * 이클립스가...git 저장 정보에 가끔씩 오류가 난다. 당황하지 말고
		 * preferences > general > security > secure storage > contents 에서 git을 삭제하고 다시 커밋하자
		 */
	}

}
