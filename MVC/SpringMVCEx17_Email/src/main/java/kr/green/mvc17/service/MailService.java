package kr.green.mvc17.service;

import kr.green.mvc17.vo.MailVO;

public interface MailService {
    public void sendEmail(String emailAddress, String subject, String body);
    public void sendEmail(MailVO mailVO);
}