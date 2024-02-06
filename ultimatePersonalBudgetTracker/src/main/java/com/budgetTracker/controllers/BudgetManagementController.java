package com.budgetTracker.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetTracker.dto.BudgetEntryDTO;
import com.budgetTracker.dto.MonthlyBudgetDTO;
import com.budgetTracker.dto.MonthlyBudgetMemberDTO;
import com.budgetTracker.service.BudgetManagmentService;
import com.budgetTracker.service.MemberService;
import com.budgetTracker.util.Util;

@RestController
@RequestMapping("budgetmanagement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BudgetManagementController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BudgetManagmentService budgetManagmentService;
	
	
    @PostMapping("monthly-budget-id/{monthlyBudgetId}/member-id/{memberId}/save/budget-entry")
    public ResponseEntity<?> saveBudgetEntry(@PathVariable("monthlyBudgetId") Long monthlyBudgetId,@PathVariable("memberId") Long memberId, @RequestBody BudgetEntryDTO budgetEntryDTO) {
        
    	try {
    		// Check if the monthly budget exists
    		if(budgetManagmentService.findMonthlyBudgetById(monthlyBudgetId).isEmpty()){
    			return Util.getCustomeResponse(HttpStatus.NOT_FOUND, "Monthly Budget Not Found", null);
    		}
    		System.out.println("test");
    		// Check if the member exists
    		if (budgetManagmentService.findMonthlyBudgetMemberByMonthlyBudgetIdAndMemberId(monthlyBudgetId, memberId).isEmpty()) {
    			System.out.println("test");
    			return Util.getCustomeResponse(HttpStatus.NOT_FOUND, "Member Not Found", null);
    		}
    		
    		budgetEntryDTO.setMemberId(memberId);
    		budgetEntryDTO.setMonthlyBudgetId(monthlyBudgetId);
    		budgetEntryDTO.setDate(new Date());
    		
    		return budgetManagmentService.saveBudgetEntry(budgetEntryDTO);

    	}catch (Exception e) {
    		e.printStackTrace();
    		return Util.getCustomeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    	}
    }
    
    @PostMapping("/save/monthly-budget")
    public ResponseEntity<?> saveMonthlyBudget(@RequestBody MonthlyBudgetDTO monthlyBudgetDTO) {
    	try {
    		return budgetManagmentService.saveMonthlyBudget(monthlyBudgetDTO);
    	}catch (Exception e) {
    		e.printStackTrace();
    		return Util.getCustomeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    	}
    }
    
    @PostMapping("/add/member/{memberId}/monthly-budget/{monthlyBudgetId}")
    public ResponseEntity<?> addMembersInMonthlyBudget(@PathVariable("monthlyBudgetId") Long monthlyBudgetId,@PathVariable("memberId") Long memberId,@RequestBody MonthlyBudgetMemberDTO monthlyBudgetMemberDTO) {
    	try {
    		// Check if the monthly budget exists
    		if(budgetManagmentService.findMonthlyBudgetById(monthlyBudgetId).isEmpty()){
    			return Util.getCustomeResponse(HttpStatus.NOT_FOUND, "Monthly Budget Not Found", null);
    		}
    		// Check if the member exists
    		if (memberService.findMemberById(memberId).isEmpty()) {
    			return Util.getCustomeResponse(HttpStatus.NOT_FOUND, "Member Not Found", null);
    		}
    		
    		monthlyBudgetMemberDTO.setBudgetId(monthlyBudgetId);
    		monthlyBudgetMemberDTO.setMemberId(memberId);
    		monthlyBudgetMemberDTO.setJoinDate(new Date());
    		
    		return budgetManagmentService.addMemberInMonthBudgetEntry(monthlyBudgetMemberDTO);
    	}catch (Exception e) {
    		e.printStackTrace();
    		return Util.getCustomeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    	}
    }
    
    
    @GetMapping("/budget-entries/all")
    public ResponseEntity<?> getAllBudgetEntries() {
        try {
        	return budgetManagmentService.getAllBudgetEntries();
        }catch (Exception e) {
			e.printStackTrace();
    		return Util.getCustomeResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
    }
}