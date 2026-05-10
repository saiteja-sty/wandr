package com.wandr.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * A community-submitted gem (place, tip, or local hack) awaiting verification.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String authorName;

    @NotBlank
    private String city;

    @NotBlank
    @Size(min = 10, max = 500)
    private String quote;

    private String tag;          // "Hidden gem", "Free transit", "Local tip"
    private boolean verified;
    private Instant submittedAt;
}
