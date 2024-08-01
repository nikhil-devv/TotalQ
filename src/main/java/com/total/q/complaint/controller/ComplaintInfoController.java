package com.total.q.complaint.controller;

import com.total.q.complaint.service.ComplaintInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaint/api")
public class ComplaintInfoController  {

    @Autowired
    private ComplaintInfoServiceImpl complaintInfoService;


    @GetMapping("/{id}")
    public ResponseEntity<com.total.q.entity.complaint.ComplaintInfo> getItemById(@PathVariable("id") Long id) {
        return  complaintInfoService.getComplaintById(id).map( complaint -> new ResponseEntity<>(complaint, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createComplaint")
    public ResponseEntity<com.total.q.entity.complaint.ComplaintInfo>createComplaint(@RequestBody com.total.q.entity.complaint.ComplaintInfo complaintInfo){
        if(complaintInfo != null){
            complaintInfoService.createComplaintInfo(complaintInfo);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteComplaint")
    public ResponseEntity<com.total.q.entity.complaint.ComplaintInfo>deleteComplaintInfo(@RequestParam Long id){
        HttpStatus httpStatus;
       try{
           complaintInfoService.deleteComplaint(id);
           httpStatus = HttpStatus.OK;
       }catch (Exception ignored){
           httpStatus = HttpStatus.NOT_FOUND;
       }
       return new ResponseEntity<>(httpStatus);
    }
}
