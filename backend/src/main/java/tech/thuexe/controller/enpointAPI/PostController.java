package tech.thuexe.controller.enpointAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
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
    public ResponseEntity<List<PostReadDTO>> getPosts() {
        return ResponseEntity.ok().body(postService.getPosts());
    }

    @GetMapping("/all/province/{id}")
    public ResponseEntity<List<PostReadDTO>> getPostsByProvince(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok().body(postService.getPostsByProvince(id, pageable));
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<PostReadDTO>> getPostsAreNotRent(
//            @RequestParam int page,
//            @RequestParam int size) {
//        Pageable pageable = PageRequest.of(page-1, size);
//        return ResponseEntity.ok().body(postService.getPostsAreNotRent(pageable));
//    }

    @PutMapping("/re-rent")
    public ResponseEntity<String> reRent(@RequestParam int postId) {
        postService.reRent(postId);
        return ResponseEntity.ok("Ok");
    }
}


