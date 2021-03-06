package com.example.Favourites.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotBlank;

// to define properties
@Document(collection = "Favourites_record")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class Favourites
    {
        //@Id annotation to make id variable as primary key
        @Id
        private int id;
        @NotBlank(message = "userName is Mandatory")
        private String userName;
        @NotBlank(message = "Title is Mandatory")
        private String title;
        @NotBlank(message = "Artist is Mandatory")
        private String artist;
        private int releaseyear;
        @NotBlank(message = "Genre is Mandatory")
        private String genre;
    }


