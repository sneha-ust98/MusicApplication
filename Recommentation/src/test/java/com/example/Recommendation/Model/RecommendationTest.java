package com.example.Recommendation.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationTest {
    Recommendation recommendation;
    @BeforeEach
    void setUp()
    {
        recommendation=new Recommendation();
    }
    @Test
    public void ShouldReturnUserId()
    {
        recommendation.setId(7);
        assertEquals(7,recommendation.getId());
    }

    @Test
    public void ShouldReturntitle()
    {
        recommendation.setTitle("first");
        assertEquals("first",recommendation.getTitle());
    }
    @Test
    public void ShouldReturnArtist()
    {
        recommendation.setArtist("john");
        assertEquals("john",recommendation.getArtist());
    }
}