package com.nighthawk.spring_portfolio.mvc.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/location")
public class LocationApiController {
    //     @Autowired
    // private JwtTokenUtil jwtGen;
    /*
    #### RESTful API ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    // Autowired enables Control to connect POJO Object through JPA
    @Autowired
    private LocationJpaRepository repository;

    /*
    GET List of People
     */

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable long id) {
        Optional<Location> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Location location = optional.get();  // value from findByID
            return new ResponseEntity<>(location, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  
    }

}
