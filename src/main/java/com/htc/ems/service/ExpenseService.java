package com.htc.ems.service;

import com.htc.ems.entity.Expense;
import com.htc.ems.repository.ExpenseRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Transactional(readOnly = true)
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Expense findById(Integer id) {
        return expenseRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Expense not found with id: " + id));
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteById(Integer id) {
        expenseRepository.deleteById(id);
    }
}
