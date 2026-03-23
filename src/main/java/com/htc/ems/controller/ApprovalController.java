package com.htc.ems.controller;

import com.htc.ems.entity.Approval;
import com.htc.ems.service.ApprovalService;
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
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping
    public List<Approval> findAll() {
        return approvalService.findAll();
    }

    @GetMapping("/{id}")
    public Approval findById(@PathVariable Integer id) {
        return approvalService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Approval create(@RequestBody Approval approval) {
        return approvalService.save(approval);
    }

    @PutMapping("/{id}")
    public Approval update(@PathVariable Integer id, @RequestBody Approval approval) {
        approval.setId(id);
        return approvalService.save(approval);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        approvalService.deleteById(id);
    }
}
