package com.example.nashta_test.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.nashta_test.dtos.DataDto;
import com.example.nashta_test.models.Data;
import com.example.nashta_test.properties.FileStorageProperty;
import com.example.nashta_test.repositories.DataRepository;
import com.example.nashta_test.services.FileStorageImpl;
import com.io.iona.springboot.controllers.HibernateCRUDController;

@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://localhost:3000")
public class DataController extends HibernateCRUDController<Data, DataDto>{
	
	
	@Autowired
	FileStorageImpl fileStorage;
	
	@Autowired
	DataRepository dataRepo;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@PostMapping("/createData")
	public Map<String, Object> createDate(@RequestParam(required = false) String title,
			@RequestParam(required = false) String location,
			@RequestParam(required = false) String participant,
			@RequestParam(required = false) String date,
			@RequestParam(required = false) String note,
			@RequestParam(required = false) MultipartFile image) throws ParseException{
		Map<String, Object> result = new HashMap<>();
		System.out.println("Belum leat");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		
		String uploadImage = fileStorage.storeFile(image);
		
		Data data = new Data();
		data.setDate(format.parse(date));
		data.setLocation(location);
		data.setNote(note);
		data.setParticipant(participant);
		data.setTitle(title);
		data.setImage(uploadImage);
		 
		dataRepo.save(data);
		
		result.put("Data", data);
		
		return result;
	}
}
