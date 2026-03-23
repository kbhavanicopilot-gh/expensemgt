package com.htc.ems.service;

import com.htc.ems.entity.ExpenseItem;
import com.htc.ems.repository.ExpenseItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseItemService {

    private final ExpenseItemRepository expenseItemRepository;

    public ExpenseItemService(ExpenseItemRepository expenseItemRepository) {
        this.expenseItemRepository = expenseItemRepository;
    }

    @Transactional(readOnly = true)
    public List<ExpenseItem> findAll() {
        return expenseItemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ExpenseItem findById(Integer id) {
        return expenseItemRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Expense item not found with id: " + id));
    }

    public ExpenseItem save(ExpenseItem expenseItem) {
        return expenseItemRepository.save(expenseItem);
    }

    public void deleteById(Integer id) {
        expenseItemRepository.deleteById(id);
    }
}
