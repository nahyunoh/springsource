package com.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileCheckTask {
	
	/* @Scheduled
	 * 리턴 타입은 void여야 하고 파라미터를 갖지 않는 메소드에 적용
	 * 
	 * 
	 * cron : CronTab 설정 방식과 동일하게 설정
	 * "0 * * * * *" : second, minute, hour, day of month, day of week
	 * "0 0 * * * *" : 매일 매시 정각
	 * 
	 * fixedDelay : 이전에 실행된 Task의 종료 시간으로부터 정의된 시간만큼 지난 후 Task 실행(밀리세컨드 단위)
	 * fixedRate : 이전에 실행된 Task의 시작 시간으로부터 정의된 시간만큼 지난 후 Task 실행(밀리세컨드 단위)
	 */
	
	@Scheduled(cron="0 * * * * *")
	public void schedulerTest() {
		System.out.println("매 분 1초 마다 스케쥴링 테스트");
	}
	
	@Scheduled(fixedDelay = 10000)
	public void schedulerTest2() {
		System.out.println("10초 마다 스케쥴링 테스트");
	}
}
