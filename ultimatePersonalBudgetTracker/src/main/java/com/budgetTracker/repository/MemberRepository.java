package com.budgetTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetTracker.model.Member;




public interface MemberRepository extends JpaRepository<Member, Long>{

}
