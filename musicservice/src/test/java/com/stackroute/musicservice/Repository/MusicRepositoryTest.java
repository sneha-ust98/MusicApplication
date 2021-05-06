package com.stackroute.musicservice.Repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import com.stackroute.musicservice.model.Music;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataMongoTest
class MusicRepositoryTest
{
    @Autowired
    private MusicRepository repository;
    private Music music;

    @AfterEach
    void tearDown() {
        music=null;
    }
    @Test
    public void givenFavouriteToSaveThenShouldReturnSavedFavourite(){
        Music music=new Music(1,"Despatico","Henry",1998,"pop");
        repository.save(music);
        Music music1=repository.findById(music.getId()).get();

        assertNotNull(music1);
        assertEquals(music1.getTitle(),music1.getTitle());
    }
    @Test
    public void givenGetAllThenShouldReturnListOfAllFavourites(){
        Music music=new Music(1,"Despatico","Henry",1998,"pop");
        repository.save(music);
        List<Music> musicList=repository.findAll();
        assertEquals("abc",musicList.get(1).getTitle());
    }


}
