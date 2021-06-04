package com.spring.di;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV - ��ü ����(1)");
	}
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - ��ü ����(2)");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - ��ü ����(3)");
		System.out.println("SamsungTV ���� -"+ this.price);
	}
	
	
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	


	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void turnOn() {
		System.out.println("SamsungTV - �Ŀ� On");
	}


	@Override
	public void turnOff() {
		System.out.println("SamsungTV - �Ŀ� Off");
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