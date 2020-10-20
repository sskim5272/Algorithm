package ws.step08;

import java.util.Arrays;
import java.util.Comparator;

//구현이 아닌 규칙을 정하는것, 규격을 만든다 , 설계
interface inter
{
	public void print(); // n
}
//클래스와 인터패이스의 관계 만들기 : 상속(implements)
//부모 타입은 자식 타입을 받을수 있다.(부모타입=자식 타입, inter=A) 형변환 (like int=byte)
//인터페이스를 상속하게 되면 인터페이스에 있는 메소드를 재정의 해야한다. overriding
//외부 클래스
class MyArray{
	public void call(inter i)
	{
		
	}
}

class A implements inter
{
	// meta data
	@Override
	public void print()
	{
		System.out.println("new implement : A");
	}
}

class B implements inter
{
	// meta data
	@Override
	public void print()
	{
		System.out.println("new implement : B");
	}
}

public class Test01
{
	public static void main(String[] args)
	{
//		A a = new A();
//		inter i = new A();
//		inter j = new B();
//		i.print();
//		j.print();
		MyArray ma =new MyArray();
		inter i=new A();
		ma.call(i);
		
		inter a= new inter()
		{			
			@Override
			public void print()
			{				
				
			}
		};
		
		ma.call(a);
		ma.call(new inter()
		{			
			@Override
			public void print()
			{				
				
			}
		});
		
		Arrays.sort(new String[] {"1","2"},new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2)
			{
				return 0;
			}
		});
		
		
		//내부 클래스를 이용한 인터패이스 사용하기(내부클래스의 종류중에서 익명 클래스르 많이 사용함)
		/*
		 	익명 클래스 형태: 객체생성 + 클래스 정의
		 	new 상속할 객체타입명( ){
		 		//메서드 정의
		 		//멤버 변수의 정의
		 	}	 	
		 	
		 	//정의하는 익명 클래스가 inter를 상속합니다.
		 	// inter를 상속 받기 때문에 메소드를 재 정의 해야한다.
		 	new inter(){
		 		public vodi print(){
		 			System.out.println("")
		 		}
		 	};
		*/
		
		
	}
}
