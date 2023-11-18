package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Publisher;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id: " + id));
    }

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
        Optional<Publisher> existingPublisherOptional = publisherRepository.findById(id);
        if (existingPublisherOptional.isPresent()) {
            updatedPublisher.setPublisherId(id);
            return publisherRepository.save(updatedPublisher);
        } else {
            throw new ResourceNotFoundException("Publisher not found with id: " + id);
        }
    }

    public void deletePublisher(Long id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Publisher not found with id: " + id);
        }
    }
}

