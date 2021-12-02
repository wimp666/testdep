package com.coen6311.MovieLover.web;

import com.coen6311.MovieLover.Beans.Administrator;
import com.coen6311.MovieLover.service.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.coen6311.MovieLover.Beans.Comment;
import com.coen6311.MovieLover.Beans.Movie;
import com.coen6311.MovieLover.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    /*
    Query administrator
     */
    @GetMapping("/administrators/{id}")
    public void getAdministrator(@PathVariable("id") int id) {
        //Administrator administrator = administratorService.get(id);
        System.out.println(id);
        //return administrator;
        return ;
    }

    /*
    Update administrator
     */
    @PutMapping("/administrators")
    public void updateAdministrator(@RequestBody Administrator administrator) {
        //administratorService.update(administrator);
        System.out.println(administrator);
        //return administrator;
        return ;
    }

    /*
    Delete administrator
     */
    @DeleteMapping("/administrators/{id}")
    public void deleteAdministrator(@PathVariable("id") int id, HttpServletRequest request) {
        //administratorService.delete(id);
        System.out.println(id);
        //return null;
    }

    /*
    Add administrator
     */
    @PostMapping("/administrators/{id}")
    public void addAdministrator(@PathVariable("id") int id, @RequestBody Administrator administrator) {
        //administratorService.add(administrator);
        System.out.println(id);
        System.out.println(administrator);
        //return administrator;
    }

}
