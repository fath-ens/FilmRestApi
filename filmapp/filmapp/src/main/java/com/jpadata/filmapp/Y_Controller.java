package com.jpadata.filmapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Y_Controller {

    @Autowired
    Yorumm yorum;

    @GetMapping("/yorum")
    public List<Yorum> getYorum() {
        return yorum.findAll();
    }

    @GetMapping("/yorum/{F_id}")
    public List<Yorum> getYorumid(@PathVariable("F_id") Integer F_id) {
        return yorum.findByfid(F_id);
    }

    @PostMapping("/NewYorum")
    public void newYorum(@RequestBody Yorum N_yorum){
        yorum.save(N_yorum);
    }
}
