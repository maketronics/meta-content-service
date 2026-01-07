package com.meta_content.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Meta-content")
@Data
public class BreadCrumbEntity {
    private String name;
    private String item;
}
