package com.htc.ems.repository;

import com.htc.ems.entity.ExpenseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseItemRepository extends JpaRepository<ExpenseItem, Integer> {
}
