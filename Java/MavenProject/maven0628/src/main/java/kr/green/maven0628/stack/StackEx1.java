package kr.green.maven0628.stack;

import java.util.Stack;

public class StackEx1 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		// 넣기
		stack.push("머현");
		stack.push("곤듀");
		stack.push("자몽");
		stack.push("상어");
		stack.push("몽쉘");
		
		System.out.println(stack);
		System.out.println(stack.size());
		// 꺼내기
		System.out.println(stack.peek()); // 맨위의 것을 확인만 함. 제거 X
		
		System.out.println(stack.pop());  // 맨위의 것을 확인한다. 제거 O
		System.out.println(stack.size() + "개");
		System.out.println(stack.pop());
		System.out.println(stack.size() + "개");
		
		// 반복
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.isEmpty());
		System.out.println(stack.size() + "개");
	}

}
