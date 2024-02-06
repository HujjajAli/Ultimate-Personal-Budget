package com.budgetTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetTracker.dto.MemberDTO;
import com.budgetTracker.service.MemberService;
import com.budgetTracker.util.Util;


@RestController
@RequestMapping("member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
    @PostMapping("/save/member")
    public ResponseEntity<?> saveMember(@RequestBody MemberDTO memberDto) {
        try {
        	return memberService.saveMember(memberDto);
        }catch (Exception e) {
			e.printStackTrace();
			return Util.getCustomeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
    }

}
