package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titie;

    @Column(name = "todoOrder", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

    @Builder
    public TodoEntity(Long id, String title, Long order, Boolean completed){
        this.id = id;
        this.titie = title;
        this.order = order;
        this.completed = completed;
    }

    public void update(TodoRequest request){
        if(request.getTitle() != null){
            this.titie = request.getTitle();
        }
        if(request.getOrder() != null){
            this.order = request.getOrder();
        }
        if(request.getCompleted() != null){
            this.completed = request.getCompleted();
        }
    }
}
