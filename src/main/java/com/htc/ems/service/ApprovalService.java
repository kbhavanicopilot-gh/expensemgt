package com.htc.ems.service;

import com.htc.ems.entity.Approval;
import com.htc.ems.repository.ApprovalRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApprovalService {

    private final ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    @Transactional(readOnly = true)
    public List<Approval> findAll() {
        return approvalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Approval findById(Integer id) {
        return approvalRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Approval not found with id: " + id));
    }

    public Approval save(Approval approval) {
        return approvalRepository.save(approval);
    }

    public void deleteById(Integer id) {
        approvalRepository.deleteById(id);
    }
}
