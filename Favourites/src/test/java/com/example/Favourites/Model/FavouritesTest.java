package com.example.Favourites.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavouritesTest {
    Favourites favourites;
    @BeforeEach
    void setUp()
    {
        favourites=new Favourites();
    }
    @Test
    public void ShouldReturnUserId()
    {
        favourites.setId(7);
        assertEquals(7,favourites.getId());
    }
    @Test
    public void ShouldReturnUserName()
    {
        favourites.setUserName("sneha");
        assertEquals("sneha",favourites.getUserName());
    }
    @Test
    public void ShouldReturntitle()
    {
        favourites.setTitle("first");
        assertEquals("first",favourites.getTitle());
    }
    @Test
    public void ShouldReturnArtist()
    {
        favourites.setArtist("john");
        assertEquals("john",favourites.getArtist());
    }

}