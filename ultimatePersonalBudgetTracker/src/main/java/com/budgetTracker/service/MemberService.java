package com.budgetTracker.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.budgetTracker.dto.MemberDTO;
import com.budgetTracker.model.Member;



public interface MemberService {
	
	ResponseEntity<?> saveMember(MemberDTO memberDto);
	Optional<Member> findMemberById(Long memberid);

}
