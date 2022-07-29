package tech.thuexe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.repositoryDAO.PostRepo;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;
import tech.thuexe.utility.CustomException;
import tech.thuexe.utility.DataMapperUtils;

import javax.transaction.Transactional;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserService userService;
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
    public List<PostReadDTO> getPosts(Pageable pageable) {
        List<PostEntity> postEntities = postRepo.findAll(pageable).getContent();
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
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
    public List<PostEntity> findAllByUserId(String username) {
        return postRepo.findByUsername(username);
    }

    @Override
    public void hide(int id) {
        PostEntity postEntity = findById(id);
        postEntity.setRented(true);
    }

    @Override
    public void update(int id, PostWriteDTO post) throws CustomException {
//        PostEntity postEntity = findById(id);
//        postEntity.setDescription(post.getDescription());
//        postEntity.setImages(post.getImages());
//        postEntity.setLocation(post.getLocation());
//        postEntity.setTitle(post.getTitle());
//        postEntity.setPrice(post.getPrice());
        throw new CustomException("chua xong", HttpStatus.BAD_REQUEST);

    }

    @Override
    public void delete(int id) {
        try {
            PostEntity postEntity = findById(id);
            postRepo.delete(postEntity);
        } catch (Exception e) {
            hide(id);
        }
    }

    @Override
    public int count() {
        return postRepo.countByRented(false);
    }


    @Override
    public List<PostReadDTO> getPostsAreNotRent(Pageable pageable) {
        List<PostEntity> postEntities = postRepo.findAllByRented(false, pageable).getContent();
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
    }

    @Override
    public List<PostReadDTO> findAllByName(String value) {
        try {
            List<PostEntity> postEntities = postRepo.findAllByTitleContains(value);
            return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
        } catch (Exception e) {
            return new ArrayList<PostReadDTO>();
        }
    }

    @Override
    public List<PostReadDTO> findAllByTitleDesc(Pageable pageable) {
        List<PostEntity> postEntities = postRepo.findAllByRentedOrderByTitleDesc(false, pageable);
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
    }

    @Override
    public List<PostReadDTO> findAllByTitleAsc(Pageable pageable) {
        List<PostEntity> postEntities = postRepo.findAllByRentedOrderByTitleAsc(false, pageable);
        return dataMapperUtils.mapAll(postEntities, PostReadDTO.class);
    }

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

//    private boolean isOwner(PostEntity postEntity) {
//        if (userService.getUsername().equals(postEntity.getUser().getUsername())) {
//            return true;
//        } else {
//            return false;
//        }
//    }

}
