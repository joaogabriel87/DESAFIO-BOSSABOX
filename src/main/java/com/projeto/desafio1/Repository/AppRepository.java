package com.projeto.desafio1.Repository;

import com.projeto.desafio1.model.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<AppEntity, Long> {

    List<AppEntity> findAllBy();

    List<AppEntity> findByTagsIn(List<String> tags);

    default AppEntity saveApp(AppEntity app){
        return save(app);
    }

     default void  deleteAppById(Long id){
        deleteById(id);
     }


}


