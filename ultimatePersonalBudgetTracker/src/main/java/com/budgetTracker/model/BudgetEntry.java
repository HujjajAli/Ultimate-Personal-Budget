package com.budgetTracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import java.util.Date;

@Entity
@Data
public class BudgetEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	@Column(nullable = false)
	private Date   date;
	@Column(nullable = false)
	private Double amount;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Long   memberId;
	@Column(nullable = false)
	private Long monthlyBudgetId;

}