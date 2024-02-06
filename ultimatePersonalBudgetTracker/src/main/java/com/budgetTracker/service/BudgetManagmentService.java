package com.budgetTracker.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.budgetTracker.dto.BudgetEntryDTO;
import com.budgetTracker.dto.MonthlyBudgetDTO;
import com.budgetTracker.dto.MonthlyBudgetMemberDTO;
import com.budgetTracker.model.MonthlyBudget;
import com.budgetTracker.model.MonthlyBudgetMember;



public interface BudgetManagmentService {
	
	ResponseEntity<?> saveBudgetEntry(BudgetEntryDTO budgetEntry);
	ResponseEntity<?> getAllBudgetEntriesByMember(Long memberId);
	ResponseEntity<?> getAllBudgetEntries();
	ResponseEntity<?> saveMonthlyBudget(MonthlyBudgetDTO monthlyBudgetDTO);
	ResponseEntity<?> addMemberInMonthBudgetEntry(MonthlyBudgetMemberDTO monthlyBudgetMemberDTO);
	
	
	Optional<MonthlyBudget>    findMonthlyBudgetById(Long id);
	Optional<MonthlyBudgetMember>  findMonthlyBudgetMemberByMonthlyBudgetIdAndMemberId(Long budgetId,Long memberId);

}