package com.coen6311.MovieLover.web;

import com.alibaba.fastjson.JSON;

import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.Beans.User;
import com.coen6311.MovieLover.service.MovieLoverService;
import com.coen6311.MovieLover.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;



@RestController
public class MovieLoverController {
    Service service = new Service();

    /*
    Query movie lover by id
     */
    @GetMapping("/movieLovers/{id}")

    public Object getMovieLover(@PathVariable("id") String id) {
        MovieLover movieLover = service.getMovieLoverById(id);
        System.out.println(id);
        return JSON.toJSONString(movieLover);

    }

    /*
    Add movie lover
     */
    @PostMapping("/movieLovers")

    public Object addMovieLover(@RequestBody MovieLover movieLover) {
        service.addMovieLover(movieLover);
        System.out.println(movieLover);
        return JSON.toJSONString("Add movie lover successfully");
    }

    /*
    Delete movie lover（new 11/27）(OK)
     */
    @DeleteMapping("/movieLovers/{userId}")
    public Object deleteMovieLover(@PathVariable("userId") String userId, HttpServletRequest request) {
        service.deleteMovieLover(userId);
        System.out.println(userId);
        return JSON.toJSONString("Delete movie lover successfully");
    }

//    
//    /*
//    Update movie lover
//     */
//    @PutMapping("/movieLovers/{id}")
//    public void updateMovieLover(@PathVariable("id") int id, @RequestBody MovieLover movieLover) {
//        //movieLoverService.update(movieLover);
//        System.out.println(id);
//        System.out.println(movieLover);
//        //return movieLover;
//    }

    

}
