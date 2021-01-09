package com.practice.repository;


import com.practice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Temporal;
import javax.transaction.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {


    @Transactional
    Project findByProjectCode(String projectCode);
}
