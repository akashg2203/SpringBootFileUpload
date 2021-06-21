package com.example.demo.app;

import java.io.*;
import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileUploadService;





@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	FileUploadService fileUploadService;
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file)
	{
		Map<String,Object> map = new LinkedHashMap<>();
		try {
			fileUploadService.uploadFile(file);
			map.put("result", "file uploaded");
			}
	catch(IOException e) {
		map.put("result", "While uploading:"+e.getMessage());
		
	}
	return map;
	
	
	}
	
}
