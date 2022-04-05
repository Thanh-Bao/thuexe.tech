package tech.thuexe.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
public class PostController {

    @GetMapping
    public Object getNewest() {
        return "Hello";
    }

    @GetMapping("/content/{postId}")
    public Object getDetail(@PathVariable(name = "postId") String postId) {
        return "Hello";
    }

    @GetMapping("/photo/{id}")
    public Object getPhoto(@PathVariable(name = "ìd") String id){
        return "Hello";
    }

    @GetMapping("/user/{userId}")
    public Object getByUser(@PathVariable(name="userId") String userId){
        return "Hello";
    }

    /** Create post */
    @PostMapping()
    public Object create(@RequestBody Object postDTO){
        return "Hello";
    }

    /** React post */
    @PostMapping("/react/{postId}")
    public Object reactPost(@RequestBody Object id){
        return "Hello";
    }

    @PostMapping("/unreact")
    public Object unReactPost(@RequestBody Object id){
        return "Hello";
    }

    /** Save post */
    @PostMapping("/save")
    public Object savePost(@RequestBody Object id){
        return "Hello";
    }

    @PostMapping("unsave")
    public Object unsavePost(@RequestBody Object id){
        return "Hello";
    }
}

