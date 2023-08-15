package kr.green.maven0628.stack;

import java.util.LinkedList;

public class QueueEx {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>(); // FIFO(First In First Out : 선입 선출 구조
		// 넣기
		queue.addFirst(11);
		queue.addFirst(22);
		queue.addFirst(33);
		
		System.out.println(queue.size() + "개 : " + queue);
		
		System.out.println(queue.pollLast());
		System.out.println(queue.pollLast());
		System.out.println(queue.size() + "개 : " + queue);
		System.out.println("------------------------------------------------");
		
		LinkedList<Integer> dequeue = new LinkedList<>();
		dequeue.addFirst(11);
		dequeue.addFirst(22);
		System.out.println(dequeue.size() + "개 : " + dequeue);
		dequeue.addLast(33);
		dequeue.addLast(44);
		System.out.println(dequeue.size() + "개 : " + dequeue);
		dequeue.addFirst(55);
		dequeue.addLast(66);
		System.out.println(dequeue.size() + "개 : " + dequeue);
		
		// 꺼내기
		System.out.println(dequeue.pollFirst());
		System.out.println(dequeue.pollLast());
	}

}
