package com.spring.poly;

public class TVUser {
	public static void main(String[]args) {
	//SamsungTV samsung=new SamsungTV();
	//samsung.turnOn();
	//samsung.turnOn();
	
	//응집도 높이고, 결합도 낮추기
	//부모 = new 자식(extend, implements)=>다형성
	TV tv=new SamsungTV(new SamsungSpeaker());
	tv.turnOn(); //SamsungTV - 파워On
	tv.soundUp();
	tv.soundDown();
	//((SamsungTV)tv).setSpeaker(new SonySpeaker()); 
	//클래스 변화 시키면 실행 시켜서 ClassCastException확인
	
	tv.turnOff();
	
//	tv=new LgTV();
//	tv.turnOn(); //LG TV - 전원 On
	
	}

	
}
