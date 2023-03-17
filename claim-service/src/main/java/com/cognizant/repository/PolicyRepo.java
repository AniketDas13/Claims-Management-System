package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.utility.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {

}
