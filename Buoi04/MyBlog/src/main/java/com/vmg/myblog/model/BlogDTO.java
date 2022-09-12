package com.vmg.myblog.model;

import lombok.Data;

@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String cover;
    private String content;
    private Long categoryId;
}
