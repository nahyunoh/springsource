package com.spring.scan;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("samsung")
public class SamsungTV implements TV {
	//생성된 객체 주입
	//@Autowired
	@Inject
	@Qualifier("speaker2") //이름으로 주입 대상을 결정할 뿐 실제 주입을 해주는 것은 아님
	private Speaker speaker; //SonySpeaker or SamsungSpeaker

	
	public SamsungTV() {
		System.out.println("SamsungTV - 객체 생성(1)");
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
		speaker.volumeUp(); 
	}

	@Override
	public void soundDown() {
		speaker.volumeDown();
	}

}
