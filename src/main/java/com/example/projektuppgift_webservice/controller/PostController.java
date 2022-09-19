package com.example.projektuppgift_webservice.controller;

import com.example.projektuppgift_webservice.dto.Post;
import com.example.projektuppgift_webservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @PostMapping
    public Post insertPost(@RequestBody Post post){
        return postService.insertPost(post);
    }

}
