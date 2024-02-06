package com.budgetTracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.budgetTracker.dto.BudgetEntryDTO;
import com.budgetTracker.dto.MonthlyBudgetDTO;
import com.budgetTracker.dto.MonthlyBudgetMemberDTO;
import com.budgetTracker.model.BudgetEntry;
import com.budgetTracker.model.MonthlyBudget;
import com.budgetTracker.model.MonthlyBudgetMember;
import com.budgetTracker.repository.BudgetEntryRepository;
import com.budgetTracker.repository.MonthlyBudgetMemberRepository;
import com.budgetTracker.repository.MonthlyBudgetRepository;
import com.budgetTracker.service.BudgetManagmentService;
import com.budgetTracker.util.Util;



@Service
public class BudgetManagmentServiceImpl implements BudgetManagmentService{
	
	@Autowired
	private BudgetEntryRepository budgetEntryRepository;
	@Autowired
	private MonthlyBudgetRepository monthlyBudgetRepository;
	@Autowired
	private MonthlyBudgetMemberRepository monthlyBudgetMemberRepository;
	
	@Override
	public ResponseEntity<?> saveBudgetEntry(BudgetEntryDTO budgetEntryDto) {
		BudgetEntry budgetEntry = new BudgetEntry();
		budgetEntry.setId(null);
		BeanUtils.copyProperties(budgetEntryDto, budgetEntry);
		budgetEntryRepository.save(budgetEntry);
		return Util.getCustomeResponse(HttpStatus.CREATED, "Budget Entry saved successfully.", budgetEntry);
	}



	@Override
	public ResponseEntity<?> saveMonthlyBudget(MonthlyBudgetDTO monthlyBudgetDTO) {
		MonthlyBudget monthlyBudget = new MonthlyBudget();
		monthlyBudget.setId(null);
		BeanUtils.copyProperties(monthlyBudgetDTO, monthlyBudget);
		monthlyBudgetRepository.save(monthlyBudget);
		return Util.getCustomeResponse(HttpStatus.CREATED, "New Monthly Budget Created successfully.", monthlyBudget);
	}


	@Override
	public ResponseEntity<?> addMemberInMonthBudgetEntry(MonthlyBudgetMemberDTO monthlyBudgetMemberDTO) {
		MonthlyBudgetMember monthlyBudgetMember = new MonthlyBudgetMember();
		monthlyBudgetMember.setId(null);
		BeanUtils.copyProperties(monthlyBudgetMemberDTO, monthlyBudgetMember);
		monthlyBudgetMemberRepository.save(monthlyBudgetMember);
		return Util.getCustomeResponse(HttpStatus.CREATED, "New Monthly Budget Member Added successfully.", monthlyBudgetMember);
	}
	
	@Override
	public ResponseEntity<?> getAllBudgetEntriesByMember(Long memberId) {
		return null;
	}
	
	@Override
	public ResponseEntity<?> getAllBudgetEntries() {
		List<BudgetEntryDTO> allBudgetEntryDTOs = new ArrayList<BudgetEntryDTO>();
		List<BudgetEntry>    allBudgetEntries   = budgetEntryRepository.findAll();
		for(BudgetEntry budgetEntry:allBudgetEntries){
			BudgetEntryDTO budgetEntryDTO = new BudgetEntryDTO();
			BeanUtils.copyProperties(budgetEntry, budgetEntryDTO);
			allBudgetEntryDTOs.add(budgetEntryDTO);
		}
		return Util.getCustomeResponse(HttpStatus.OK, "Record Found!", allBudgetEntryDTOs);
	}
	
	@Override
	public Optional<MonthlyBudget> findMonthlyBudgetById(Long id) {
		return monthlyBudgetRepository.findById(id);
	}



	@Override
	public Optional<MonthlyBudgetMember> findMonthlyBudgetMemberByMonthlyBudgetIdAndMemberId(Long budgetId,Long memberId) {
		System.out.println("test");
		return monthlyBudgetMemberRepository.findByBudgetIdAndMemberId(budgetId, memberId);
	}



	



	

}

