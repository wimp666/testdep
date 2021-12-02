package com.coen6311.MovieLover.web;


import com.alibaba.fastjson.JSON;
import com.coen6311.MovieLover.Beans.Comment;
import com.coen6311.MovieLover.service.Service;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class CommentController {

    private Service service = new Service();


    /*
    Query comments by movie ID
     */
    @GetMapping("/comments/movieId/{movieId}")

    public Object getCommentByMovieId(@PathVariable("movieId") String movieId) {
    	ArrayList<Comment> commentList = service.getCommentsByMovieId(movieId);
    	System.out.println(commentList);
        return JSON.toJSONString(commentList);
    }

    /*
    Query comments by user ID
     */
    @GetMapping("/comments/userId/{userId}")

    public Object getCommentByUserId(@PathVariable("userId") String userId) {
    	ArrayList<Comment> commentList = service.getCommentsByUserId(userId);
        System.out.println(commentList);
        return JSON.toJSONString(commentList);

    }

    /*
    Add comments
     */
    @PostMapping("/comments")

    public Object addComment(@RequestBody Comment comment) {
        service.addComment(comment);
        System.out.println(comment);
        return JSON.toJSONString("Add comment successfully");
    }

    /*
    Delete comments(new 11/27)(OK)
     */
    @DeleteMapping("/comments/{userId}/{movieId}")
    public Object deleteComment(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId, HttpServletRequest request) {
        service.deleteComment(userId, movieId);
        System.out.println(userId);
        System.out.println(movieId);
        return JSON.toJSONString("Delete comment successfully");
    }

    /*
    Update comments(new 11/27)(有问题)
     */
    @PutMapping("/comments/{userId}/{movieId}")
    public Object updateComment(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId, @RequestBody Comment comment) {

        service.updateComment(comment);
        System.out.println(comment);
        return JSON.toJSONString("Update comment successfully");

    }

}
