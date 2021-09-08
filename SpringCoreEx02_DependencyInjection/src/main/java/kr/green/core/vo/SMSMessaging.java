package kr.green.core.vo;

// ActiveMQ를 이용한 메세지 전송
public class SMSMessaging implements Messaging{
    public void sendMessage() {
        System.out.println("SMS을 이용하여 메세지를 보냅니다.");
    }
}