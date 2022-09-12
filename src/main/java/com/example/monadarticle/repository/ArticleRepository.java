package com.example.monadarticle.repository;


import com.example.monadarticle.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Query(value = "select * from article where id = ?1", nativeQuery = true)
    public Article getArticleById(Long id);

    @Query(value = "select * from article where generic_sys_user_id = ?1", nativeQuery = true)
    public Article getArticleByGenericSysUserId(Long id);
}
