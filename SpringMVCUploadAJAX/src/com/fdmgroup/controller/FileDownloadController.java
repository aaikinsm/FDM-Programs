package com.fdmgroup.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileDownloadController {
	
	@Autowired
	HttpServletRequest request;
	
	private final String FILE_NAME = "landscape.jpg";
	private final String DIRECTORY = "/Uploaded Files/";
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {
 
        String dataDirectory = request.getServletContext().getRealPath(DIRECTORY);
        Path file = Paths.get(dataDirectory, FILE_NAME);
        
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + FILE_NAME + "\"");
        
        try
        {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } 
        catch (IOException ex) {
        	System.err.println(ex.getMessage());
        }
    }
}
