package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	List<Student> findByUserName(String userName);
	
}
