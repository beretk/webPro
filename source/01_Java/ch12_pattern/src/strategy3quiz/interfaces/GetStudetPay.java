package strategy3quiz.interfaces;

public class GetStudetPay implements GetImpl {
	@Override
	public void get() {
		System.out.println("교육 급여를 받습니다");
	}
}