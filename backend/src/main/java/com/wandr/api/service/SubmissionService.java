package com.wandr.api.service;

import com.wandr.api.model.Submission;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory submission store. In Phase C, this will be backed by a database.
 */
@Service
public class SubmissionService {

    private final List<Submission> submissions = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public SubmissionService() {
        // Seed with some sample submissions
        submissions.add(new Submission(idCounter.getAndIncrement(), "Maria",
                "Boston", "Skip Mike's Pastry line. Bova's Bakery, two blocks over, is open 24 hours and the cannoli are honestly better.",
                "Hidden gem", true, Instant.now()));
        submissions.add(new Submission(idCounter.getAndIncrement(), "James",
                "Boston", "The EZRide shuttle is free and runs from North Station to Kendall. Saves you $2.40 every trip.",
                "Free transit", true, Instant.now()));
    }

    public List<Submission> findAll() {
        return List.copyOf(submissions);
    }

    public List<Submission> findByCity(String city) {
        return submissions.stream()
                .filter(s -> s.getCity().equalsIgnoreCase(city))
                .toList();
    }

    public Submission create(Submission submission) {
        submission.setId(idCounter.getAndIncrement());
        submission.setSubmittedAt(Instant.now());
        submission.setVerified(false);   // New submissions start unverified
        submissions.add(submission);
        return submission;
    }
}
