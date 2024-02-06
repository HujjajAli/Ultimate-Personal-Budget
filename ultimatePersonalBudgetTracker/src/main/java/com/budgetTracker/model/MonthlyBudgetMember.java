package com.budgetTracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MonthlyBudgetMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	@Column(nullable = false)
	private Long   memberId;
	@Column(nullable = false)
	private Long   budgetId;
	private Date   joinDate;
	private Double contribution;

}
