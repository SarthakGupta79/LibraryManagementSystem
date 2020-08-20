package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LibraryModel;
import com.example.demo.service.LibraryService;


@RestController
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@GetMapping(value = "/getLibrary")
	public List<LibraryModel> findAllLibrary(){
		
		return libraryService.findAllLib();
	}
	
	
	@PostMapping(value = "/addLibrary")
	public LibraryModel saveLibrary(@RequestBody LibraryModel lm) {
		return libraryService.saveLibrary(lm);
	}
	
}
