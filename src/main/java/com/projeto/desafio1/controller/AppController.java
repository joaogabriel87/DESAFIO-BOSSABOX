package com.projeto.desafio1.controller;


import com.projeto.desafio1.model.AppEntity;
import com.projeto.desafio1.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public List<AppEntity> GetAllApp(){
        return appService.GetAllApp();
    }

    @GetMapping("/tag/{tag}")
    public List<AppEntity> GetAppByTag(@PathVariable String tag){
        return appService.GetAppByTags(Collections.singletonList(tag));
    }

    @PostMapping
    public AppEntity CreateApp(@RequestBody AppEntity app){
        return appService.NewApp(app);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteApp(@PathVariable Long id){
        appService.DeleteApp(id);
        return ResponseEntity.noContent().build();
    }
}
