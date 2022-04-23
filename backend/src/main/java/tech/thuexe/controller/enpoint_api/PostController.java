package tech.thuexe.controller.enpoint_api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.thuexe.dto.post.PostReadDTO;
import tech.thuexe.dto.post.PostWriteDTO;
import tech.thuexe.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${APIVersion}/post")
@Validated
public class PostController {
    private final PostService postService;

    @PostMapping("/save")
    public ResponseEntity<PostReadDTO> save(@RequestBody PostWriteDTO post) {
        return ResponseEntity.ok().body(postService.save(post));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostReadDTO>> getPosts(){
        return  ResponseEntity.ok().body(postService.getPosts());
    }
}


