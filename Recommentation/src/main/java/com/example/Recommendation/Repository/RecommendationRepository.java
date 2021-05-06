package com.example.Recommendation.Repository;

import com.example.Recommendation.Model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//it markes  the specific class as a dat access object

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation,Integer>
{
    @Query(value = "{}",sort = "{counter:-1}")
    public List<Recommendation> getBycounter();

}
