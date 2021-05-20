package com.example.nashta_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nashta_test.dtos.DataDto;
import com.example.nashta_test.models.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{

	

}
