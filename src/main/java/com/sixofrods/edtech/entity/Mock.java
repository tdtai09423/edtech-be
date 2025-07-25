package com.sixofrods.edtech.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "mock")
@NoArgsConstructor
@AllArgsConstructor
public class Mock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameMock;
    private int numberOfQuestions;
    private LocalDateTime createdAt;
    private String createdBy;
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;
    @OneToMany(mappedBy = "mock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizQuestions> quizQuestions = new ArrayList<>();
    @OneToMany(mappedBy = "mock", cascade = CascadeType.ALL)
    private List<Score> scores = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
