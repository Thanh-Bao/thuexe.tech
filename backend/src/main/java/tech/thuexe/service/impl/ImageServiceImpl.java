package tech.thuexe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.repository.ImageRepo;
import tech.thuexe.service.ImageService;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${FilePath}")
    private String imagePath;
    private final ImageRepo imageRepo;

    @Override
    public ImageEntity saveImage(ImageEntity image) {
        image.setLink(imagePath+image.getLink());
        return imageRepo.save(image);
    }
}
