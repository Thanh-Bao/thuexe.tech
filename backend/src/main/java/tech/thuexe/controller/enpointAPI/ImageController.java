package tech.thuexe.controller.enpointAPI;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.service.PostService;
import tech.thuexe.utility.FileHandler;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${APIVersion}/image")
public class ImageController {

    private final FileHandler fileHandler;
    private final PostService postService;

    @GetMapping(value="/id/{id}")
    public ResponseEntity<ImageEntity> getImage(@PathVariable int id){
       return ResponseEntity.ok().body(postService.getImage(id));
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> fileUpload(@RequestParam("media") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        try {
            String filename = fileHandler.storeFile(file);
            return new ResponseEntity(filename, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
