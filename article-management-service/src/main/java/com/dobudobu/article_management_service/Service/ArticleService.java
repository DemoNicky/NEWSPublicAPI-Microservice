package com.dobudobu.article_management_service.Service;

import com.dobudobu.article_management_service.Dto.Request.ArticleCreateRequest;
import com.dobudobu.article_management_service.Dto.Response.ArticleCreateResponse;
import com.dobudobu.article_management_service.Dto.Response.GetListArticleResponse;
import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    ResponseHandling<?> createArticle(ArticleCreateRequest articleCreateRequest, MultipartFile file);

    ResponseHandling<List<GetListArticleResponse>> getArticle(int page);
}
