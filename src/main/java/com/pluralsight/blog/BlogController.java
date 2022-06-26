package com.pluralsight.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;

@Controller
public class BlogController {
    
    private PostRepository postRepository;
    
    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    
    @RequestMapping("/")
    public String listPosts(ModelMap data) {
        // data.put("title", "Blog Post 1");

        List<Post> allPosts = this.postRepository.getAllPosts();

        data.put("posts", allPosts);
    
        return "home";
    }
}
