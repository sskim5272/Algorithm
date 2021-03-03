package ws.step09;
import java.util.Arrays;
import java.util.Comparator;

import javax.xml.crypto.Data;

/**
 * 
 * @author taeheekim
 *
 */
public class S02_ComparableTest {

	static class Student 
	{
		int no, score;

		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

//		//@Override
//		public int compareTo(Student o) {
//			return this.no - o.no;
//		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", score=" + score + "]";
		}

	}

	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			if(o2.score == o1.score) return o2.no - o1.no;
			return o2.score - o1.score;
		}

	}
	
	static class Data1 implements Comparable<Data1>{
		int num;
		Data1(){}
		Data1(int num){
			this.num=num;
		}
		
		@Override
		public int compareTo(Data1 o)
		{
			System.out.println("call compareTo");
			System.out.println(this.num);
			return (this.num-o.num)*-1;
		}
	}

	public static void main(String[] args) {
		
		Data1[]a= new Data1[3];
		int index=0;
		a[index++]=new Data1(3);		
		a[index++]=new Data1(10);
		a[index++]=new Data1(7);
		Arrays.sort(a); //Data1 클래스는 반드시 comparable 타입이어야 한다.
		for(Data1 d:a) {
			System.out.println(d.num);
		}
		System.out.println("-------------------------------------");
		
		
		
//
//		Student[] arr = new Student[] { new Student(1, 10), new Student(3, 50), new Student(2, 80),
//				new Student(4, 10) };
//		System.out.println("=========정렬 전=============");
//		print(arr);
//		Arrays.sort(arr);
//		System.out.println("=========번호 오름차순=============");
//		print(arr);

		Student[] arr2 = new Student[] { new Student(1, 10), new Student(3, 50), new Student(2, 80),
				new Student(4, 10) };
		System.out.println("=========정렬 전=============");
		print(arr2);
		Arrays.sort(arr2, new StudentComparator()); //정렬 클래스를 따로 넣어 주면 student를 정렬하지 않아도 된다.
		System.out.println("=========번호 오름차순=============");
		print(arr2);
	}
	private static void print(Student[] arr) {
		for (Student student : arr) {
			System.out.println(student);
		}
	}

}