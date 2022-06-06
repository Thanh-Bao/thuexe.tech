package tech.thuexe.service;

import org.springframework.data.domain.Pageable;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;

import java.util.List;

public interface PostService {
    PostReadDTO save(PostWriteDTO postWriteDTO);

    List<PostReadDTO> getPosts();

    PostEntity findById(int id);

    void reRent(int id);

    //List<PostReadDTO> getPostsAreNotRent(Pageable pageable);

    //List<PostReadDTO> getPostsByProvince(int id, Pageable pageable);
}
