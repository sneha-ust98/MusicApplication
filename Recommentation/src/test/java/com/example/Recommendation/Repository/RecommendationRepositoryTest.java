package com.example.Recommendation.Repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
        import org.springframework.test.context.junit.jupiter.SpringExtension;

        import java.util.List;
        import com.example.Recommendation.Model.Recommendation;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataMongoTest
class RecommendationRepositoryTest {

    @Autowired
    private RecommendationRepository repository;
    private Recommendation recommendation;

    @AfterEach
    void tearDown() {
        recommendation=null;
    }
    @Test
    public void givenFavouriteToSaveThenShouldReturnSavedFavourite(){
        Recommendation recommendation=new Recommendation(1,2,"Despatico","Henry",1998,"pop");
        repository.save(recommendation);
        Recommendation recommendation1=repository.findById(recommendation.getId()).get();

        assertNotNull(recommendation1);
        assertEquals(recommendation1.getTitle(),recommendation1.getTitle());
    }
    @Test
    public void givenGetAllThenShouldReturnListOfAllFavourites(){
        Recommendation recommendation=new Recommendation(1,2,"abcde","Henry",1998,"pop");
        repository.save(recommendation);
        List<Recommendation> musicList=repository.findAll();
        assertEquals("abcde",musicList.get(1).getTitle());
    }


}
