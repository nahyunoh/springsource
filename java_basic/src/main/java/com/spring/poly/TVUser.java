package com.spring.poly;

public class TVUser {
	public static void main(String[]args) {
	//SamsungTV samsung=new SamsungTV();
	//samsung.turnOn();
	//samsung.turnOn();
	
	//������ ���̰�, ���յ� ���߱�
	//�θ� = new �ڽ�(extend, implements)=>������
	TV tv=new SamsungTV(new SamsungSpeaker());
	tv.turnOn(); //SamsungTV - �Ŀ�On
	tv.soundUp();
	tv.soundDown();
	//((SamsungTV)tv).setSpeaker(new SonySpeaker()); 
	//Ŭ���� ��ȭ ��Ű�� ���� ���Ѽ� ClassCastExceptionȮ��
	
	tv.turnOff();
	
//	tv=new LgTV();
//	tv.turnOn(); //LG TV - ���� On
	
	}

	
}