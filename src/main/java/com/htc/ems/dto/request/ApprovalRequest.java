package com.htc.ems.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class ApprovalRequest {

    @Positive
    private Integer expenseId;

    @Positive
    private Integer expenseItemId;

    @NotNull
    @Positive
    private Integer approverId;

    @NotBlank
    @Size(max = 50)
    private String role;

    @Size(max = 50)
    private String status;

    private String remarks;

    private LocalDateTime actionDate;

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getExpenseItemId() {
        return expenseItemId;
    }

    public void setExpenseItemId(Integer expenseItemId) {
        this.expenseItemId = expenseItemId;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
