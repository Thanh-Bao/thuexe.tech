package tech.thuexe.service;

import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.entity.PostEntity;

import java.util.List;

public interface PostService {
    PostReadDTO save(PostWriteDTO postWriteDTO);
    List<PostReadDTO> getPosts();
    ImageEntity getImage(int id);
}
