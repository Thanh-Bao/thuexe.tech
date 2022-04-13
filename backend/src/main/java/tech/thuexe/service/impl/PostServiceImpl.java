package tech.thuexe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repository.ImageRepo;
import tech.thuexe.repository.PostRepo;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;
import tech.thuexe.utility.DataMapperUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ImageRepo imageRepo;
    private final UserService userService;
    private final DataMapperUtils dataMapperUtils;

    @Override
    public PostReadDTO save(PostWriteDTO postWriteDTO) {
        PostEntity postEntity = postRepo.save(mapDTOtoEntity(postWriteDTO));
        if (postEntity == null) {
            return null;
        }
        return dataMapperUtils.map(postEntity,PostReadDTO.class);
    }

    @Override
    public List<PostReadDTO> getPosts() {
        List<PostEntity> post = postRepo.findAllByOrderByCreatedAtDesc();
        return dataMapperUtils.mapAll(post,PostReadDTO.class);
    }

    @Override
    public ImageEntity getImage(int id) {
        return imageRepo.findById(id);
    }

    private PostEntity mapDTOtoEntity(PostWriteDTO postWriteDTO) {
        UserEntity user = userService.getUser(userService.getUsername());
        PostEntity postEntity = new PostEntity();
        postWriteDTO.getImages().forEach(image -> postEntity.addImage(image));
        postEntity.setTitle(postWriteDTO.getTitle());
        postEntity.setLocation(postWriteDTO.getLocation());
        postEntity.setDescription(postWriteDTO.getDescription());
        postEntity.setUser(user);
        return postEntity;
    }


   /* private PostReadDTO mapEntityToDTO(PostEntity postEntity) {
        PostReadDTO postReadDTO = new PostReadDTO();
        postReadDTO.setId(postEntity.getId());
        postReadDTO.setImages(postEntity.getImages());
        postReadDTO.setTitle(postEntity.getTitle());
        postReadDTO.setDescription(postEntity.getDescription());
        postReadDTO.setLocation(postEntity.getLocation());
        postReadDTO.setUser(postEntity.getUser());
        return postReadDTO;
    }*/
}
