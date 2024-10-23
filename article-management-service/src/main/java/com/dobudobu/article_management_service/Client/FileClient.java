package com.dobudobu.article_management_service.Client;

import com.dobudobu.article_management_service.Dto.Response.FilePostResponse;
import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PostExchange;

public interface FileClient {

    @PostExchange("/api/v1/file/upload-file")
    ResponseHandling<FilePostResponse> postFile(@RequestPart(value = "file")MultipartFile file);

}
