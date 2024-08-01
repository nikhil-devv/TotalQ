package com.total.q.complaint.service;

import com.total.q.complaint.repository.ComplaintRepository;
import com.total.q.entity.complaint.ComplaintInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintInfoServiceImpl  {

    @Autowired
    private  ComplaintRepository complaintRepository;

    public List<ComplaintInfo> getAllComplaint(){
        return complaintRepository.findAll();
    }

    public Optional<ComplaintInfo> getComplaintById(Long recId){
        return complaintRepository.findById(recId);
    }

    public void createComplaintInfo(ComplaintInfo complaintInfo){
        complaintRepository.save(complaintInfo);
    }
    public void deleteComplaint(Long complaintInfo){
        complaintRepository.deleteById(complaintInfo);
    }
}
