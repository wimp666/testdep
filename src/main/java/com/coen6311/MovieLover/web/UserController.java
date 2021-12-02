package com.coen6311.MovieLover.web;


import com.alibaba.fastjson.JSON;
import com.coen6311.MovieLover.Beans.User;
import com.coen6311.MovieLover.service.Service;


import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.Beans.MovieLover;
import com.coen6311.MovieLover.Beans.User;
import com.coen6311.MovieLover.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


//@RestController = @Controller + @ResponseBody
@RestController
public class UserController {


    Service service = new Service();

//    
//    /*
//    Query user
//     */
//    @GetMapping("/users/{id}")
//    public void getUser(@PathVariable("id") int id) {
//        //User user = userService.get(id);
//        System.out.println(id);
//        //return user;
//        return;
//    }
//    
//    /*
//    Add user
//     */
//    @PostMapping("/users")
//    public void addUser(@RequestBody User user) {
//        //userService.add(user);
//        System.out.println(user);
//        //return user;
//        return ;
//    }
//
//    
//    /*
//    Delete user
//     */
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable("id") int id, HttpServletRequest request) {
//        System.out.println(id);
//
//        return ;
//    }
//
//    /*
//    Update comments
//     */
//    @PutMapping("/users/{id}")
//    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
//        //userService.update(user);
//        System.out.println(id);
//        System.out.println(user);
//        //return user;
//        return ;
//    }
//
    
    /*
    Add movie to wishlist (new 11/27) (OK)
     */
    @PostMapping("/wishlist/{userId}/{movieId}")
    public Object addMovieToWishList(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId) {

        service.addMovieToWishList(userId,movieId);

        return JSON.toJSONString("Add movie to wishlist successfully");
    }

    /*
    Delete movie to wishlist (new 11/27) (OK)
     */
    @DeleteMapping("/wishlist/{userId}/{movieId}")
    public Object deleteMovieFromWishList(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId){

        service.deleteMovieFromWishList(userId, movieId);

        return JSON.toJSONString("Delete movie from wishlist successfully");

    }


}
