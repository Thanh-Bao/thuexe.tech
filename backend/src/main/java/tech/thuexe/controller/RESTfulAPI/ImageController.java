package tech.thuexe.controller.RESTfulAPI;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.thuexe.utility.FileHandler;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/image")
public class ImageController {

    @Autowired
    private FileHandler fileHandler;

    @PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> fileUpload(@RequestParam("media") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        try {
            String filename = fileHandler.storeFile(file);
            return new ResponseEntity(filename, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
