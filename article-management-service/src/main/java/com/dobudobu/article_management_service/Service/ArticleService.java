package com.dobudobu.article_management_service.Service;

import com.dobudobu.article_management_service.Dto.Request.ArticleCreateRequest;
import com.dobudobu.article_management_service.Dto.Response.ArticleCreateResponse;
import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleService {
    ResponseHandling<?> createArticle(ArticleCreateRequest articleCreateRequest, MultipartFile file);
}
