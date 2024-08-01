package com.total.q.complaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<com.total.q.entity.complaint.ComplaintInfo,Long> {

}
