package com.wandr.api.controller;

import com.wandr.api.model.Submission;
import com.wandr.api.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * /api/submissions — list and create community submissions (hidden gems).
 */
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<Submission> list(@RequestParam(required = false) String city) {
        return (city == null) ? submissionService.findAll() : submissionService.findByCity(city);
    }

    @PostMapping
    public ResponseEntity<Submission> create(@Valid @RequestBody Submission submission) {
        Submission created = submissionService.create(submission);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
