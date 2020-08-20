package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ShelfModel;
import com.example.demo.service.ShelfService;


@RestController
public class ShelvesController {

	
	@Autowired 
	private ShelfService shelveService;
	
	
	@GetMapping(value = "/getAllShelves")
	public List<ShelfModel> findAllShelve(){
		
		return shelveService.findAllShelves();
	}
	

	@GetMapping("/getShelve/{sName}") 
    public List<ShelfModel> findBysName(@PathVariable String sName) {
   	
		return shelveService.findBysName(sName);
    
	}
	
	@PostMapping(value = "/saveShelve/{libIsbn}")
	public ShelfModel saveShelves(@RequestBody ShelfModel sm,int libIsbn) {
		
		return shelveService.saveShelf(sm, libIsbn);
	}
	

		
}
