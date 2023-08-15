package kr.green.core.vo;

// ActiveMQ를 이용한 메세지 전송
public class ActiveMQMessaging implements Messaging{
    public void sendMessage() {
        System.out.println("Active MQ를 이용하여 메세지를 보냅니다.");
    }
}