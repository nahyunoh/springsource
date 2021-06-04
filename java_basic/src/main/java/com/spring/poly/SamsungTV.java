package com.spring.poly;

public class SamsungTV implements TV {
	
	//��� ����, property, �ν��Ͻ� ���� =>�Ӽ�(�⺻Ÿ��, Ŭ����Ÿ��, �迭, �������̽�, Enum)
	//��������� �ʱ�ȭ�� ����
	
	//private SonySpeaker speaker; //null
	//private SamsungSpeaker speaker;
	private Speaker speaker;
	//private int num; //�⺻Ÿ�� 0(int), 0.0(float), false(boolean)
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - ��ü ����");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
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