package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Repository.LibraryRepo;
import com.example.demo.Repository.ShelfRepo;
import com.example.demo.entity.Library;
import com.example.demo.entity.Shelves;
import com.example.demo.model.ShelfModel;

@Service
public class ShelfService {
	@Autowired
	private ShelfRepo shelveRepo;
	@Autowired
	private LibraryRepo libraryRepo;
	
	@Transactional public List<ShelfModel> findAllShelves(){
		 List<Shelves> shelveList=shelveRepo.findAll();
		 List<ShelfModel>modelList=new ArrayList<>();
		 for( Shelves s:shelveList) {
			ShelfModel sm=new ShelfModel();
			 sm.setShelfId(s.getShelfId());
			 sm.setsName(s.getShelfName());
			 sm.setBookCount(s.getBookCount());
			 modelList.add(sm);
			 
		     }
		         return modelList;
  }

	@Transactional public List<ShelfModel> findBysName( String sName){
		 List<Shelves> shelveList=shelveRepo.findBysName(sName);
		 List<ShelfModel>modelList=new ArrayList<>();
		 for( Shelves s:shelveList) {
			ShelfModel s1=new ShelfModel();
			 s1.setShelfId(s.getShelfId());
			 s1.setBookCount(s.getBookCount());
			 s1.setsName(s.getShelfName());
			 modelList.add(s1);
			 
		     }
		         return modelList;
	}
	
	

	/////create/////

	@Transactional public ShelfModel saveShelf(ShelfModel sm , int libIsbn) {
		Library lib=libraryRepo.getOne(libIsbn);
		Shelves shelf=new Shelves();
		shelf.setShelfName(sm.getsName());
		int count=sm.getBookCount();
		shelf.setBookCount(count);
		
		shelveRepo.save(shelf);
		lib.getShelve().add(shelf);
		libraryRepo.save(lib);
	   return sm;
	}
	
	public String addShelveToLib(int shelfId, int libIsbn) {
		Shelves shelf=shelveRepo.getOne(shelfId);
		Library lib=libraryRepo.getOne(libIsbn);
		List<Shelves>shelves=new ArrayList<>();
		shelves.add(shelf);
		lib.setShelve(shelves);;
		
		shelveRepo.save(shelf);
		libraryRepo.save(lib);
			
		return"added";
		
	}
	
}
