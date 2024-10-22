package com.dobudobu.article_management_service.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCreateRequest {

    private String articleTitle;

    private String content;

    private String categoryId;
}
