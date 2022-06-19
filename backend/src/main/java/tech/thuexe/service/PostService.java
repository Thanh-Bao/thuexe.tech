package tech.thuexe.service;

import org.springframework.data.domain.Pageable;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;
import tech.thuexe.utility.Config;

import javax.annotation.security.RolesAllowed;
import java.util.List;

public interface PostService {

    @RolesAllowed(Config.ROLE.Names.USER)
    PostReadDTO save(PostWriteDTO postWriteDTO);

    List<PostReadDTO> getPosts();

    PostEntity findById(int id);

    @RolesAllowed(Config.ROLE.Names.USER)
    void reRent(int id);

    List<PostEntity> findAllByUserId(String username);

    //List<PostReadDTO> getPostsAreNotRent(Pageable pageable);

    //List<PostReadDTO> getPostsByProvince(int id, Pageable pageable);
}
