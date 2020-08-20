package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Shelves;

@Repository
public interface ShelfRepo extends JpaRepository<Shelves, Integer>{

	List<Shelves> findBysName(String sName);

}