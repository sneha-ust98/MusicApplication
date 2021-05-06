package com.stackroute.musicservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicTest {
    Music music;
    @BeforeEach
    void setUp()
    {
        music=new Music();
    }
    @Test
    public void ShouldReturnUserId()
    {
        music.setId(7);
        assertEquals(7,music.getId());
    }

    @Test
    public void ShouldReturntitle()
    {
        music.setTitle("first");
        assertEquals("first",music.getTitle());
    }
    @Test
    public void ShouldReturnArtist()
    {
        music.setArtist("john");
        assertEquals("john",music.getArtist());
    }
}