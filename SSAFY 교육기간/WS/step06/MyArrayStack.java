/**
 *   pop()  : 꺼내값 삭제
 *   peek() : 꺼내기
 *   push() : 입력
 *   isEmpty(): 비어있는지 체크
 *   isFull() : 다찾는지 체크
 */
package ws.step06;

import java.util.Arrays;

public class MyArrayStack {
	
	int top = -1;
	String [] elements = new String[2];
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	
	public void push(String item) {
		
		
	}
	
	public String peek() {
		return elements[top];
	}
	
	public String pop() {
		String item = peek();
		elements[top--] = null;
		return item;
	}
	
	public String toString() {
		
		
		return "Stack" + Arrays.toString(elements);
	}
	
}