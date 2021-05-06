package com.stackroute.musicservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "music_abc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Music
{
    //@id annotation makes id variable as primary key
    @Id
    private int id;
    @NotBlank(message = "Title is Mandatory")
    private String title;
    @NotBlank(message = "Artist is Mandatory")
    private String artist;
    private int releaseyear;
    @NotBlank(message = "Genre is Mandatory")
    private String genre;
}
