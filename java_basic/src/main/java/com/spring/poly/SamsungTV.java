package com.spring.poly;

public class SamsungTV implements TV {
	
	//멤버 변수, property, 인스턴스 변수 =>속성(기본타입, 클래스타입, 배열, 인터페이스, Enum)
	//멤버변수는 초기화를 해줌
	
	//private SonySpeaker speaker; //null
	//private SamsungSpeaker speaker;
	private Speaker speaker;
	//private int num; //기본타입 0(int), 0.0(float), false(boolean)
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	

	@Override
	public void turnOn() {
		System.out.println("SamsungTV - 파워 On");
	}


	@Override
	public void turnOff() {
		System.out.println("SamsungTV - 파워 Off");
	}

	@Override
	public void soundUp() {
		//System.out.println("SamsungTV - volumeUp");
		speaker.volumeUp(); 
		//System.out.println(speaker);
	}

	@Override
	public void soundDown() {
		//System.out.println("SamsungTV - volumeDown");
		speaker.volumeDown();
	}

}
