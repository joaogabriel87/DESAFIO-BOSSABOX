package com.projeto.desafio1.Repository;

import com.projeto.desafio1.model.AppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AppRepository extends JpaRepository<AppEntity, Long> {

    List<AppEntity> findAll();
    @Query("SELECT a FROM AppEntity a JOIN a.tags t WHERE t IN :tags")
    List<AppEntity> findByTagsIn(@Param("tags") List<String> tags);


    default AppEntity saveApp(AppEntity app){
        return save(app);
    }

     default void  deleteAppById(Long id){
        deleteById(id);
     }


}


