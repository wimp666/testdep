package com.coen6311.MovieLover.web;


import com.alibaba.fastjson.JSON;

import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.Beans.User;
import com.coen6311.MovieLover.service.MovieService;
import com.coen6311.MovieLover.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {


    private Service service = new Service();



    /*
    Query Movie by movie ID
     */
    @GetMapping("movies/id/{id}")

    public Object getMovieId(@PathVariable("id") String id) {
        Movie movie = service.getMovieById(id);
        System.out.println(id);

        return JSON.toJSONString(movie);
    }

    /*
    Query Movie by name（相比上面有问题）
     */
    @GetMapping("/movies/name/{name}")
    public Object getMoviebyName(@PathVariable("name") String movieName) {
        ArrayList<Movie> movieList= service.getMovieByName(movieName);
        System.out.println(movieList);
        return JSON.toJSONString(movieList);

    }

    /*
    Add movie
     */
    @PostMapping("/movies")

    public Object addMovie(@RequestBody Movie movie) {
        service.addMovie(movie);
        System.out.println(movie);
        return JSON.toJSONString("Add movie successfully");
    }

    /*
    Delete movie(new 11/27)（ok）
     */
    @DeleteMapping("/movies/{movieId}")
    public Object deleteMovie(@PathVariable("movieId") String movieId, HttpServletRequest request) {
        service.deleteMovie(movieId);
        System.out.println(movieId);
        return JSON.toJSONString("Delete movie successfully");

    }

    //Put要加id
    /*

    Update movie(new 11/27)(有问题)
     */
    @PutMapping("/movies/{movieId}")
    public Object updateMovie(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {
    	
        service.updateMovie(movie);
        
        return JSON.toJSONString(movie);
    }

//    
//    /*
//    Query search history
//     */
//    @GetMapping("/search/{id}")
//    public String getSearchHistory(@PathVariable("id") String id) {
//        //Movie movie = movieService.get(id);
//        System.out.println(id);
//        return "The search history is presented below";
//    }
//
//    /*
//    Clear search history
//     */
//    @DeleteMapping("/search/{id}")
//    public String deleteSearchHistory(@PathVariable("id") int id, HttpServletRequest request) {
//        //movieService.delete(id);
//        System.out.println(id);
//        return "Delete search history successfully";
//    }
//    
    

}
