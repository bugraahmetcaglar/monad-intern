package com.example.monadarticle.service;


import com.example.monadarticle.model.Article;
import com.example.monadarticle.model.GenericSysUser;
import com.example.monadarticle.payload.ArticlePayload;
import com.example.monadarticle.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article findArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }

    public Article findArticleByUserId(Long id){
        return articleRepository.getArticleByGenericSysUserId(id);
    }

    public Article createNewArticle(ArticlePayload articlePayload, GenericSysUser genericSysUser) {
        Article newArticle = new Article();
        newArticle.setDatetime(articlePayload.getDatetime());
        newArticle.setDescription(articlePayload.getDescription());
        newArticle.setTitle(articlePayload.getTitle());
        newArticle.setGenericSysUser(genericSysUser);

        return articleRepository.save(newArticle);
    }
}
