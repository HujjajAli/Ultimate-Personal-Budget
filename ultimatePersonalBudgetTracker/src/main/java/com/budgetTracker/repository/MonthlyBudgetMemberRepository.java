package com.budgetTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetTracker.model.MonthlyBudgetMember;


public interface MonthlyBudgetMemberRepository extends JpaRepository<MonthlyBudgetMember, Long>{
	Optional<MonthlyBudgetMember> findByBudgetIdAndMemberId(Long budgetId,Long memberId);
}
