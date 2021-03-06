package tech.thuexe.controller.RESTfulAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.thuexe.DTO.post.PostReadDTO;
import tech.thuexe.DTO.post.PostWriteDTO;
import tech.thuexe.service.LikeService;
import tech.thuexe.service.PostService;
import tech.thuexe.utility.CustomException;
import tech.thuexe.utility.DataMapperUtils;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@Validated
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private DataMapperUtils mapperUtils;
    @Autowired
    private LikeService likeService;
    @PostMapping()
    public ResponseEntity<PostReadDTO> save(@RequestBody PostWriteDTO post) {
        return ResponseEntity.ok().body(postService.save(post));
    }

    @GetMapping()
    public ResponseEntity<List<PostReadDTO>> getPosts() {
        return ResponseEntity.ok().body(postService.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostReadDTO> getPostDetail(@PathVariable int id){
        return ResponseEntity.ok().body(mapperUtils.map(postService.findById(id),PostReadDTO.class));
    };


    @PutMapping("/{id}/re-rent")
    public ResponseEntity<String> reRent(@PathVariable int id) {
        postService.reRent(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/{id}/hide")
    public ResponseEntity<String> hide(@PathVariable int id) {
        postService.hide(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody PostWriteDTO post) throws CustomException {
        return ResponseEntity.ok("Chua lam");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        postService.delete(id);
        return ResponseEntity.ok(""+id);
    }

    @PostMapping("/{id}/like")
    public void likePost(@PathVariable Integer id) {
        likeService.modifyUserLiked(id);
    }

    /* @GetMapping("/all/province/{id}")
    public ResponseEntity<List<PostReadDTO>> getPostsByProvince(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok().body(postService.getPostsByProvince(id, pageable));
    }*/

  /*      @GetMapping("/all")
    public ResponseEntity<List<PostReadDTO>> getPostsAreNotRent(
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return ResponseEntity.ok().body(postService.getPostsAreNotRent(pageable));
    }*/
}


