package lambda;

public class LambdaEx5 {

	public static void main(String[] args) {
		

		//Thread => 람다의 형태로 ㄱㄴ
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				for(int i=1;i<11;i++) {
//					System.out.print(i+" ");
//				}
//				
//			}
//		};
//		
//		Thread thread=new Thread(r);
//		thread.start();
//		
//		
//		for(int i=100;i<200;i++) {
//			System.out.print(i+" ");
//		}
		
		//람다식
		Runnable r =() ->  {
			for(int i=1;i<11;i++) {
			System.out.print(i+" ");
		}

	};
	Thread thread=new Thread(r);
	thread.start();
	
	}
}
