package com.meta_content.service.controller;

import com.meta_content.service.dto.BreadCrumbReq;
import com.meta_content.service.dto.BreadCrumbRes;
import com.meta_content.service.dto.MetaContentDto;
import com.meta_content.service.dto.MetaContentResponse;
import com.meta_content.service.service.MetaContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/create/meta-content")
@RestController
public class MetaContentController {
    @Autowired
    MetaContentService metaContentService;

    @PostMapping
    public ResponseEntity<MetaContentResponse> storeMetaData(@RequestBody MetaContentDto metaData) {
        return ResponseEntity.ok(metaContentService.storeMetaTag(metaData));
    }
//testing
    @PostMapping("/breadcrumb")
    public ResponseEntity<BreadCrumbRes> generateBreadcrumb(@RequestBody List<BreadCrumbReq> crumbReq) {
        return ResponseEntity.ok(metaContentService.generateBreadcrumbs(crumbReq));
    }



}
