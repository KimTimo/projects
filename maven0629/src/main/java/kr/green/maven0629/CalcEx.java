package kr.green.maven0629;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class CalcEx {

	private Object c;

	private static ArrayList<Object> splitTokens(String expr) {
		String[] exp = expr.split(""); // String -> String[]
		ArrayList<Object> tokens = new ArrayList<>();
		int value = 0; // 연속된 숫자일 경우 결합해서 숫자로 만들기 위한 변수
		String op = ""; // 연산자 저장
		boolean flag = false; // 판별
		for (String c : exp) { // 배열 반복
			if (c.equals(" "))
				continue; // 빈칸이면 무시

			if ("0123456789".contains(c)) { // 숫자면
				value = value * 10 + Integer.parseInt(c); // 앞자리에 10을 곱하고 자신을 숫자로 더한다.
				flag = true; // 숫자라고 표시하고
			} else { // 숫자가 아니라면
				if (flag) { // 이전이 숫자라면
					tokens.add(value); // 숫자를 리스트에 저장하고
					value = 0; // 다음에 나올 숫자를 위해 초기화
				}
				flag = false; // 숫자가 아니라고 표시
				tokens.add(c); // 숫자가 아닌것을 리스트에 추가
			}
		}
		// 마지막은 숫자나 ")"로 끝난다.
		if (flag) {
			tokens.add(value);
		}
		return tokens;
	}

	// 중위 표현식을 후위 표현식으로 변환하는 메소드가 필요하다.
	private ArrayList<Object> infixToPostfix(ArrayList<Object> tokens) {
		ArrayList<Object> result = new ArrayList<>();
		HashMap<String, Integer> prec = new HashMap<>();
		prec.put("*", 3);
		prec.put("/", 3);
		prec.put("+", 2);
		prec.put("-", 2);
		prec.put("(", 1);

		Stack<Object> opStack = new Stack<>();
		for (Object c : tokens) {
			if (c.equals("(")) {
				opStack.push(c);
			} else if (c.equals(")")) {
				while (!opStack.peek().equals("(")) {
					Object val = opStack.pop();
					if (!val.equals("(")) {
						result.add(val);
					}
				}
				opStack.pop();
			} else if (prec.containsKey(c)) {
				if (opStack.isEmpty()) {
					opStack.push(c);
				} else {
					if (prec.get(opStack.peek()) >= prec.get(c)) {
						result.add(opStack.pop());
						opStack.push(c);
					} else {
						opStack.push(c);
					}
				}
			} else {
				result.add(c);
			}
		}
		while (!opStack.isEmpty()) {
			result.add(opStack.pop());
		}
		return result;
	}
}
