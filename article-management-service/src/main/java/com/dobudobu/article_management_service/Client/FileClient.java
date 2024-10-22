package com.dobudobu.article_management_service.Client;

import com.dobudobu.article_management_service.Dto.Response.FilePostResponse;
import com.dobudobu.article_management_service.Dto.Response.ResponseHandling;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "file", url = "http://localhost:8082")
public interface FileClient {

    @PostMapping(value = "/api/v1/file/upload-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseHandling<FilePostResponse> postFile(@RequestPart(value = "file")MultipartFile file);

}
