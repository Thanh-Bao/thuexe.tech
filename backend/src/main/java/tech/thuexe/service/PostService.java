package tech.thuexe.service;

import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;

public interface PostService {
    PostReadDTO save(PostWriteDTO postWriteDTO);
}
