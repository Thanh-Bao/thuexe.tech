package tech.thuexe.controller.enpointAPI;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.service.ImageService;
import tech.thuexe.utility.FileHandler;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${APIVersion}/image")
public class ImageController {

    private final FileHandler fileHandler;
    private final ImageService imageService;

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageEntity> fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        try {
            String filename = fileHandler.storeFile(file);
            ImageEntity image = new ImageEntity();
            image.setLink(filename);
            image.setPost(new PostEntity());
            //// LỖI LỖI
            return new ResponseEntity(imageService.saveImage(image), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
