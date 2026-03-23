package com.htc.ems.controller;

import com.htc.ems.entity.Expense;
import com.htc.ems.service.ExpenseService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/{id}")
    public Expense findById(@PathVariable Integer id) {
        return expenseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense create(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Integer id, @RequestBody Expense expense) {
        expense.setId(id);
        return expenseService.save(expense);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        expenseService.deleteById(id);
    }
}
