package com.example.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.realestate.entity.Feedback;
import com.example.realestate.repository.FeedbackRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback findById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with id: " + id));
    }

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        Feedback feedback = findById(id);
        feedback.setComments(updatedFeedback.getComments());
        feedback.setRating(updatedFeedback.getRating());
        feedback.setUser(updatedFeedback.getUser());
        
        return feedbackRepository.save(feedback);
    }
}
