package com.example.projektuppgift_webservice.services;

import com.example.projektuppgift_webservice.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private WebClient webClient;

    public List<Post> findAll() {
        return webClient
                .get()
                .uri("posts")
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Post.class))
                .buffer().blockLast();
    }

    public Post insertPost(Post post){
        return webClient
                .post()
                .uri("posts")
                .body(Mono.just(post), Post.class)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Post.class))
                .block();
    }

    public List<Post> findByUserId(int id) {
        return webClient
                .get()
                .uri("posts?userId="+id)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Post.class))
                .buffer().blockLast();
    }
}