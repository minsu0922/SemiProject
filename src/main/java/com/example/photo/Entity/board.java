package com.example.photo.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer no;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String writer;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime CREATED_AT;

}
