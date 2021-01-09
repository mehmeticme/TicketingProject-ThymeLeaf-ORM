package com.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,updatable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date insertDateTime;

    @Column(nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;

    private Boolean isDeleted=false;
    private Long insertUserId;
    @Column(nullable = false)
    private Long lastUpdateUserId;


    @PrePersist
    private void onPrePersist(){

        this.insertDateTime= new Date();
        this.lastUpdateDateTime = new Date();
        this.insertUserId=1L;
        this.lastUpdateUserId=1L;
    }

    @PreUpdate
    private void onPreUpdate(){
        this.lastUpdateDateTime=new Date();
        this.lastUpdateUserId = 1L;
    }
}
