package kr.green.maven0629;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import kr.green.maven0629.PersonVO.Gender;

/*
 * 우선 순위 큐
 * ------------
 * PriorityQueue는 먼저 들어온 순서대로 데이터가 나가는 것이 아닌 
 * 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조입니다. 
 */
public class PQueueEx {
	public static void main(String[] args) {
		// int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
		// 일반 큐였다면 3 1 2 순서로 꺼내져야 한다.
		// 우선순위 큐이므로 1 2 3 순서로 꺼내진다.
		priorityQueue1.offer(3);
		priorityQueue1.offer(1);
		priorityQueue1.offer(2);
		System.out.println(priorityQueue1.poll());
		System.out.println(priorityQueue1.poll());
		System.out.println(priorityQueue1.poll());
		System.out.println();
		
		// int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
		// Collections.reverseOrder() : 역순이다.
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
		// 일반 큐였다면 3 1 2 순서로 꺼내져야 한다.
		// 우선순위 큐 역순이므로 3 2 1 순서로 꺼내진다.
		priorityQueue2.offer(3);
		priorityQueue2.offer(1);
		priorityQueue2.offer(2);
		System.out.println(priorityQueue2.poll());
		System.out.println(priorityQueue2.poll());
		System.out.println(priorityQueue2.poll());
		System.out.println();
		
		// String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
		PriorityQueue<String> priorityQueue3 = new PriorityQueue<>();
		priorityQueue3.offer("하나");
		priorityQueue3.offer("두울");
		priorityQueue3.offer("세엣");
		System.out.println(priorityQueue3.poll());
		System.out.println(priorityQueue3.poll());
		System.out.println(priorityQueue3.poll());
		System.out.println();
		

		// String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
		PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue4.offer("하나");
		priorityQueue4.offer("두울");
		priorityQueue4.offer("세엣");
		System.out.println(priorityQueue4.poll());
		System.out.println(priorityQueue4.poll());
		System.out.println(priorityQueue4.poll());
		System.out.println();
		
		// 사용자가 만든 클래스도 가능할까?
		// PriorityQueue<PersonVO> priorityQueue5 = new PriorityQueue<>();
		PriorityQueue<PersonVO> priorityQueue5 = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue5.offer(new PersonVO("한사람", 23, Gender.MALE));
		priorityQueue5.offer(new PersonVO("한인간", 43, Gender.MALE));
		priorityQueue5.offer(new PersonVO("이웬수", 58, Gender.MALE));
		System.out.println(priorityQueue5);
		System.out.println(priorityQueue5.poll());
		System.out.println(priorityQueue5.poll());
		System.out.println(priorityQueue5.poll());
		System.out.println();
		
		List<Integer> list = new ArrayList<>();
		list.add(33);
		list.add(44);
		list.add(51);
		list.add(23);
		list.add(12);
		System.out.println(list);
		list.sort(Collections.reverseOrder());
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		
	}
}
