package com.meta_content.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
@Data
@Document(collection = "Meta-content")
public class MetaContentEntity {
    @Id
    private String id =  UUID.randomUUID().toString();
    private String slugName;
    private List<MetaTagAttributes> metaTagAttributesList;
}
