package com.example.springboot.repository;

import com.example.springboot.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Long> {

}
