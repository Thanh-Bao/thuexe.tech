package tech.thuexe.service;

import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.utility.CustomException;

import java.util.List;

public interface PostService {

    PostReadDTO save(PostWriteDTO postWriteDTO);

    List<PostReadDTO> getPosts();

    PostEntity findById(int id);

    void reRent(int id);

    List<PostEntity> findAllByUserId(String username);

    void hide(int id);

    void update(int id, PostWriteDTO post) throws CustomException;

    void delete(int id);

    //List<PostReadDTO> getPostsAreNotRent(Pageable pageable);

    //List<PostReadDTO> getPostsByProvince(int id, Pageable pageable);
}
