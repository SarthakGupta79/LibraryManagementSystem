package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.LibraryRepo;
import com.example.demo.entity.Library;
import com.example.demo.model.LibraryModel;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;
	
	@Transactional public List<LibraryModel> findAllLib(){
		
		List<Library> libraryList=libraryRepo.findAll();
		List<LibraryModel> modelList=new ArrayList<>();
		for(Library lib:libraryList) {
			LibraryModel lm=new LibraryModel();
			lm.setLibIsbn(lib.getLibIsbn());
			lm.setLibName(lib.getLibName());
			modelList.add(lm);
		}
		return modelList;
	}
	
	@Transactional public LibraryModel saveLibrary(LibraryModel lm){
		
		Library lib=new Library();
		lib.setLibIsbn(lm.getLibIsbn());
		lib.setLibName(lm.getLibName());
		libraryRepo.save(lib);
		return lm;
		
	}

}
