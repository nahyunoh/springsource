package lambda;

public class LambdaTest {
	
	int max(int a, int b) {
		return a > b ? a : b;
	}

	//(int a, int b) -> {return a > b ? a : b;}
	
	//(int a, int b) -> return a > b ? a : b;
	
	//(a,b) -> return a > b ? a : b;
	
	void printVar(String name, int i) {
		System.out.println(name + "=" + i);
	}
	
	//람다식
//	(String name, int i) -> System.out.println(name + "=" + i);
//	(name, i) -> System.out.println(name + "=" + i);
							
	int roll() {
		return (int) (Math.random() * 6);
	}
	
//	//람다식
//	() -> {return (int) (Math.random() * 6);}
//	() -> return (int) (Math.random() * 6);
//	() -> (int) (Math.random() * 6);
	
	
	int square(int x) {
		return x*x;
	}
	
//	(int x) => {return x*x;}
//	(int x) => return x*x;
//	(x) =>  x*x;
	
}
