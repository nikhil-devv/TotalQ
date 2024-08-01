package com.total.q.entity.complaint;

import com.total.q.Utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "TOTAL_Q_COMPLAINT_INFO")
@Entity
public class ComplaintInfo extends BaseEntity {

    @Column(name = "CUSTOMER_NAME",nullable = false)
    String customerName;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "batch_lot_number")
    private String batchLotNumber;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private ComplaintPriority priority;

    @Column(name = "severity")
    @Enumerated(EnumType.STRING)
    private ComplaintSeverity severity;

    @Column(name = "resolution_date")
    private LocalDateTime resolutionDate;

    @Column(name = "resolution_details", columnDefinition = "TEXT")
    private String resolutionDetails;

    @Column(name = "feedback")
    private String feedback;

    enum ComplaintStatus {
        NEW,
        IN_REVIEW,
        UNDER_INVESTIGATION,
        RESOLVED,
        CLOSED
    }

    enum ComplaintPriority {
        LOW,
        MEDIUM,
        HIGH
    }

    enum ComplaintSeverity {
        MINOR,
        MAJOR,
        CRITICAL
    }

}
