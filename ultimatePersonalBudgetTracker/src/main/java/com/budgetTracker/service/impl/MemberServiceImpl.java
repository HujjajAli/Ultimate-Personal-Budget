package com.budgetTracker.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.budgetTracker.dto.MemberDTO;
import com.budgetTracker.model.Member;
import com.budgetTracker.repository.MemberRepository;
import com.budgetTracker.service.MemberService;
import com.budgetTracker.util.Util;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public ResponseEntity<?> saveMember(MemberDTO memberDto) {
		Member member = new Member();
		BeanUtils.copyProperties(memberDto, member);
		member.setId(null);
		memberRepository.save(member);
		return Util.getCustomeResponse(HttpStatus.CREATED, "Member saved successfully.", member);
	}

	@Override
	public Optional<Member> findMemberById(Long memberid) {
		return memberRepository.findById(memberid);
	}

}
