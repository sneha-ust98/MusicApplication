package com.example.Recommendation.Service;

import com.example.Recommendation.Model.Recommendation;
import com.example.Recommendation.Repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RecommendationRepository repository;
    //implementation of service methods using counter

    @Override
    public Recommendation saveSong(Recommendation recommendation) {
        int id = recommendation.getId();
        List<Recommendation> addlist = repository.findAll();
        for (Recommendation item :
                addlist) {
            if (item.getId() == id) {
                int counter = repository.findById(id).get().getCounter();
                repository.deleteById(id);
                recommendation.setCounter(counter + 1);
            }

        }
return repository.save(recommendation);
    }

    @Override
    public List<Recommendation> getAllSongs() {
        return repository.getBycounter();
    }

    @Override
    public void deleteSong(int id) {
      repository.deleteById(id);
    }
}
