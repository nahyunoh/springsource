package lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		// �߰����� - 1.map : ��Ʈ�� ��ҿ� ����� �� �߿��� ���ϴ� �ʵ常 ���� or Ư�� ���·� ��ȯ
		Stream<File> stream=Stream.of(new File("file1.txt"), new File("file2.txt"),
				new File("file3.txt"), new File("file4.txt"));
		
		//���ϸ� ����
		//new File("file1.txt").getName();	File f=new File("file2.txt"); f.getName();
		
		//���ϸ� ����
		stream.map(File::getName).forEach(f -> System.out.println(f));
		
		List<String> list=Arrays.asList("abc","def","apple","melon","text");
		
		//�빮�� ���� => ��� 
		List<String> upperList=new ArrayList<String>();
		for(String str:list) {
			upperList.add(str.toUpperCase()); //�빮�� ���� �� ���ο� ����Ʈ�� ���
		}
		System.out.println(upperList);
		
		Stream<String> stream2=list.stream();
		Stream<String> alpha=stream2.map(String::toUpperCase);
		alpha.forEach(c -> System.out.println(c));
	}

}