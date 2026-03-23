package com.htc.ems.controller;

import com.htc.ems.entity.ExpenseItem;
import com.htc.ems.service.ExpenseItemService;
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
@RequestMapping("/api/expense-items")
public class ExpenseItemController {

    private final ExpenseItemService expenseItemService;

    public ExpenseItemController(ExpenseItemService expenseItemService) {
        this.expenseItemService = expenseItemService;
    }

    @GetMapping
    public List<ExpenseItem> findAll() {
        return expenseItemService.findAll();
    }

    @GetMapping("/{id}")
    public ExpenseItem findById(@PathVariable Integer id) {
        return expenseItemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseItem create(@RequestBody ExpenseItem expenseItem) {
        return expenseItemService.save(expenseItem);
    }

    @PutMapping("/{id}")
    public ExpenseItem update(@PathVariable Integer id, @RequestBody ExpenseItem expenseItem) {
        expenseItem.setId(id);
        return expenseItemService.save(expenseItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        expenseItemService.deleteById(id);
    }
}
