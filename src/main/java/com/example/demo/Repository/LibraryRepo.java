package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer>{
	

}
