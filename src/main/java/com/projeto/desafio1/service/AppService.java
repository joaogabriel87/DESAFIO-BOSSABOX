package com.projeto.desafio1.service;

import com.projeto.desafio1.Repository.AppRepository;
import com.projeto.desafio1.model.AppEntity;

import java.util.List;

public class AppService {

    private final AppRepository appRepository;

    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public List<AppEntity> GetAllApp(){
        return appRepository.findAllBy();
    }

    public List<AppEntity> GetAppByTags(List<String> tags){
        return appRepository.findByTagsIn(tags);
    }

    public AppEntity NewApp(AppEntity app){
        return appRepository.save(app);
    }

    public void DeleteApp(Long id){
        appRepository.deleteById(id);
    }
}
