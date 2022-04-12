package org.example.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TodoRequest {

    private String title;
    private Long order;
    private Boolean completed;
}
