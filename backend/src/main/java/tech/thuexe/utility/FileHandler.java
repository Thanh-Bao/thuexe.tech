package tech.thuexe.utility;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileHandler {
    @Value("${FilePath}")
    private String filePath;

    public String storeFile(MultipartFile file) throws Exception {
        if (!Files.isDirectory(Paths.get(filePath))) {
            new File(filePath).mkdirs();
        }
        if (file.getSize() > (10 * 1024 * 1024)) {
            throw  new CustomException("Vui lòng chọn file dung lượng nhỏ", HttpStatus.BAD_REQUEST) ;
        }
        if (file.getSize() == 0 || file == null) {
            throw new CustomException("Bạn chưa chọn file", HttpStatus.BAD_REQUEST) ;
        }
        String originFileName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String fileName =  uuidAsString+"."+ FilenameUtils.getExtension(originFileName);
        File newFile = new File(filePath+fileName);
        newFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(file.getBytes());
        fos.close();
        return fileName;
    }
}
