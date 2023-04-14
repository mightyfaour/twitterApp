package com.philipneo.twitterapp.data.model;

import jakarta.persistence.*;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    private User author;

    // Constructors, getters, and setters
}
