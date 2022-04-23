package tech.thuexe.service;

import tech.thuexe.dto.post.PostReadDTO;
import tech.thuexe.dto.post.PostWriteDTO;
import tech.thuexe.entity.PostEntity;

import java.util.List;

public interface PostService {
    PostReadDTO save(PostWriteDTO postWriteDTO);
    List<PostReadDTO> getPosts();
    PostEntity findById(int id);
}
