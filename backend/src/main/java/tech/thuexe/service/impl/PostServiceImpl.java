package tech.thuexe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repositoryDAO.PostRepo;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;
import tech.thuexe.utility.DataMapperUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private  UserService userService;
    @Autowired
    private DataMapperUtils dataMapperUtils;


    @Override
    public PostReadDTO save(PostWriteDTO postWriteDTO) {
        postWriteDTO.setRented(false);
        PostEntity postEntity = postRepo.save(mapDTOtoEntity(postWriteDTO));
        if (postEntity == null) {
            return null;
        }
        return dataMapperUtils.map(postEntity, PostReadDTO.class);
    }

    @Override
    public List<PostReadDTO> getPosts() {
        List<PostEntity> post = postRepo.findAllByOrderByCreatedAtDesc();
        return dataMapperUtils.mapAll(post, PostReadDTO.class);
    }


    @Override
    public PostEntity findById(int id) {
        return postRepo.findById(id).get();
    }
    @Override
    public void reRent(int id) {
        PostEntity postEntity = findById(id);
        postEntity.setRented(false);
    }

    @Override
    public List<PostEntity> findAllByUserId(int id) {
        return postRepo.findAllByUserId(id);
    }



    /*@Override
    public List<PostReadDTO> getPostsAreNotRent(Pageable pageable) {
        List<PostEntity> postEntities = postRepo.findAllByRented(false, pageable).getContent();
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
    }*/

    /*@Override
    public List<PostReadDTO> getPostsByProvince(int id, Pageable pageable) {
        List<LocationEntity> locationEntities = locationService
                .findAllByLocationId(id);
        List<PostEntity> postEntities = postRepo.findByRentedAndLocationIn(
                false, locationEntities, pageable).getContent();
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
    }*/

    private PostEntity mapDTOtoEntity(PostWriteDTO postWriteDTO) {
        UserEntity user = userService.getUser(userService.getUsername());
        PostEntity postEntity = new PostEntity();
        postWriteDTO.getImages().forEach(image -> postEntity.addImage(image));
        postEntity.setPrice(postWriteDTO.getPrice());
        postEntity.setTitle(postWriteDTO.getTitle());
        postEntity.setLocation(postWriteDTO.getLocation());
        postEntity.setDescription(postWriteDTO.getDescription());
        postEntity.setUser(user);
        return postEntity;
    }

}
