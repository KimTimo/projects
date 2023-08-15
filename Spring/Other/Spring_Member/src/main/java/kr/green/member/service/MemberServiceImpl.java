package kr.green.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.green.member.dao.MemberDAO;
import kr.green.member.dao.MemberRoleDAO;
import kr.green.member.vo.MemberRoleVO;
import kr.green.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	MemberRoleDAO memberRoleDAO;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void insert(MemberVO memberVO) {
		log.info("{}의 insert호출 : {}", this.getClass().getName(), memberVO);
		String uuid = UUID.randomUUID().toString();
		log.info("{}의 insert UUID : {}", this.getClass().getName(), uuid);
		memberVO.setUuid(uuid);
		
		// 비번을 암호화 해서  넣는다.
		String newPassword = bCryptPasswordEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(newPassword);
		
		memberDAO.insert(memberVO); // 회원정보 저장
		// 권한을 저장해야 한다.
		MemberRoleVO memberRoleVO = new MemberRoleVO(0,memberVO.getUserid(),"ROLE_USER");
		memberRoleDAO.insert(memberRoleVO);
		// 이것은 귀찮아서 해본다. 원래 최고관리자가 관리자 모드에서 권한을 추가/삭제/수정하는 내용을 만들어야 한다.
		if(memberVO.getUserid().startsWith("admin") || memberVO.getUserid().startsWith("root")) {
			memberRoleVO = new MemberRoleVO(0,memberVO.getUserid(),"ROLE_ADMIN");
			memberRoleDAO.insert(memberRoleVO);
		}
		// 인증 요청 이메일도 발송해야 한다.
		mailService.sendMail(memberVO);
	}

	@Override
	public void update(MemberVO memberVO) {
		log.info("{}의 update호출 : {}", this.getClass().getName(), memberVO);
		
	}

	@Override
	public void delete(MemberVO memberVO) {
		log.info("{}의 delete호출 : {}", this.getClass().getName(), memberVO);
		
	}

	@Override
	public void login(MemberVO memberVO) {
		log.info("{}의 login호출 : {}", this.getClass().getName(), memberVO);
		
	}

	@Override
	public void logout() {
		log.info("{}의 logout호출", this.getClass().getName());
		
	}

	@Override
	public List<MemberVO> selectList() {
		List<MemberVO> list = null;
		log.info("{}의 selectList 호출", this.getClass().getName());
		
		log.info("{}의 selectList 리턴 : {}", this.getClass().getName(), list);
		return list;
	}

	@Override
	public int idCheck(String userid) {
		log.info("{}의 idCheck 호출 : {}", this.getClass().getName(), userid);
		int count = memberDAO.selectCountByUserid(userid);
		log.info("{}의 idCheck 리턴 : {}", this.getClass().getName(), count);
		return count;
	}

	@Override
	public MemberVO passwordSearch(MemberVO memberVO) {
		log.info("{}의 passwordSearch 호출 : {}", this.getClass().getName(), memberVO);
		MemberVO memberVO2 = null;
		
		log.info("{}의 passwordSearch 리턴 : {}", this.getClass().getName(), memberVO2);
		return memberVO2;
	}

	@Override
	public MemberVO useridSearch(MemberVO memberVO) {
		log.info("{}의 useridSearch 호출 : {}", this.getClass().getName(), memberVO);
		MemberVO memberVO2 = null;
		
		log.info("{}의 useridSearch 리턴 : {}", this.getClass().getName(), memberVO2);
		return memberVO2;
	}

	@Override
	public MemberVO emailConfirm(MemberVO memberVO) {
		log.info("{}의 emailConfirm 호출 : {}", this.getClass().getName(), memberVO);
		MemberVO memberVO2 = null;
		// 1. DB에서 해당 회원의 정보를 가져온다.
		memberVO2 = memberDAO.selectByUserid(memberVO.getUserid());
		// 2. 해당 아이디에 UUID값이 같다면 인증처리를 한다.
		log.info("{}의 emailConfirm uuid : {}", this.getClass().getName(), memberVO.getUuid());
		log.info("{}의 emailConfirm uuid : {}", this.getClass().getName(), memberVO2.getUuid());
		if(memberVO2!=null && memberVO2.getUuid().equals(memberVO.getUuid() )) {
			HashMap<String, String> map = new HashMap<>();
			map.put("userid", memberVO.getUserid());
			map.put("enabled", "1");
			memberDAO.updateEnabled(map);
			memberVO2 = memberDAO.selectByUserid(memberVO.getUserid());
		}
		log.info("{}의 emailConfirm 리턴 : {}", this.getClass().getName(), memberVO2);
		return memberVO2;
	}

	@Override
	public MemberVO selectByIdx(int idx) {
		log.info("{}의 selectByIdx 호출 : {}", this.getClass().getName(), idx);
		MemberVO memberVO = memberDAO.selectByIdx(idx);
		log.info("{}의 selectByIdx 리턴 : {}", this.getClass().getName(), memberVO);
		return memberVO;
	}

	@Override
	public MemberVO selectByUserid(String userid) {
		log.info("{}의 selectByIdx 호출 : {}", this.getClass().getName(), userid);
		MemberVO memberVO = memberDAO.selectByUserid(userid);
		log.info("{}의 selectByIdx 리턴 : {}", this.getClass().getName(), memberVO);
		return memberVO;
	}

}
