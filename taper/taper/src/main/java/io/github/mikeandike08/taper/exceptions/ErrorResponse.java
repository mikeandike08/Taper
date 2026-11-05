package io.github.mikeandike08.taper.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Schema(description = "Standard error response")
public record ErrorResponse (
    @Schema(example = "2026-11-04T14:30:00") LocalDateTime timestamp,
    @Schema(example = "400") int status,
    @Schema(example = "Bad Request") String error,
    @Schema(example = "Size must be positive") String message
) {
    public static ErrorResponse of(String message, HttpStatus status) {
        return new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message);
    }
}
