package io.github.mikeandike08.taper.model;
import java.util.List;

public record PageResult<T>(List<T> items, long totalItems) {
    public PageResult {
        items = List.copyOf(items);
        
        if (totalItems < 0) {
            throw new IllegalArgumentException("Total must be non-negative");
        }
    }
}
