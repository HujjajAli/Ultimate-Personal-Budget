package com.budgetTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetTracker.model.BudgetEntry;



public interface BudgetEntryRepository extends JpaRepository<BudgetEntry, Long>{

}