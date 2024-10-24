package com.dobudobu.article_management_service.Controller;

import com.dobudobu.article_management_service.Dto.Request.ArticleCreateRequest;
import com.dobudobu.article_management_service.Dto.Response.ArticleCreateResponse;
import com.dobudobu.article_management_service.Dto.Response.GetListArticleResponse;
import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import com.dobudobu.article_management_service.Service.ArticleService;
import com.dobudobu.article_management_service.Service.Implement.ArticleServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(
            value = "/create-article",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ResponseHandling<?>> createArticle(@RequestPart("article")ArticleCreateRequest articleCreateRequest,
                                                                                 @RequestPart("file")MultipartFile file){
        ResponseHandling<?> responseHandling = articleService.createArticle(articleCreateRequest, file);
        return ResponseEntity.status(HttpStatus.OK).body(responseHandling);
    }

    @GetMapping(value = "/helo")
    public String helo(){
        return "hello";
    }

    @GetMapping(value = "/get-article/{page}")
    public ResponseEntity<ResponseHandling<List<GetListArticleResponse>>> getArticle(@PathVariable("page")int page){
        ResponseHandling<List<GetListArticleResponse>> responseHandling = articleService.getArticle(page);
        return ResponseEntity.status(HttpStatus.OK).body(responseHandling);
    }

}
