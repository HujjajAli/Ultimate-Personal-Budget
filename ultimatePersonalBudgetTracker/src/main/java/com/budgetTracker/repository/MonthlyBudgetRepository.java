package com.budgetTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetTracker.model.MonthlyBudget;

public interface MonthlyBudgetRepository extends JpaRepository<MonthlyBudget, Long>{

}
