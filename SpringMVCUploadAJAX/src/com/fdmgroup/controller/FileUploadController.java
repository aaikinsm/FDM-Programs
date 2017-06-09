package com.fdmgroup.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.model.UploadForm;

import net.coobird.thumbnailator.Thumbnails;
 
@Controller
public class FileUploadController {
 
	final String SAVE_DIRECTORY = "Uploaded Files";
	final String THUMBNAIL_SAVE_DIRECTORY = "Thumbnails";
	
	@Autowired
	private HttpServletRequest request;
	
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String displayForm(Model model) {
    	//model.addAttribute("uploadForm", new UploadForm());
        return "uploadForm";
    }
    
    @RequestMapping(value = "/createThumbnail", method = RequestMethod.GET)
    public String displayUploaImageForm(Model model) {
        return "uploadImageForm";
    }
 
    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String saveFiles(UploadForm uploadForm, Model model) throws IllegalStateException, IOException {
 
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
 
        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
//                	multipartFile.getInputStream(); //Handle file content 
                	String path = request.getServletContext().getRealPath("/");
                    multipartFile.transferTo(new File(path + SAVE_DIRECTORY + "/" + fileName));
                    fileNames.add(fileName);
                }
            }
        }
 
        model.addAttribute("files", fileNames);
        return "displayUploaded";
    }
    
    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String saveImage(UploadForm uploadForm, Model model) throws IllegalStateException, IOException {
 
        List<MultipartFile> files = uploadForm.getFiles();
 
        String fileName = "";
 
        if (null != files && files.size() == 1) {
            fileName = files.get(0).getOriginalFilename();
            if (!"".equalsIgnoreCase(fileName)) {
            	String path = request.getServletContext().getRealPath("/");
            	File imageFile = new File(path + SAVE_DIRECTORY + "/" + fileName);
            	files.get(0).transferTo(imageFile);
            	Thumbnails.of(imageFile)
                .size(160, 160)
                .toFile(new File(path + THUMBNAIL_SAVE_DIRECTORY + "/" + fileName));
            }
        }
 
        model.addAttribute("imageFile", fileName);
        return "displayUploadedImage";
    }
}