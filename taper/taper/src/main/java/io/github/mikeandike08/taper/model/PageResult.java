package io.github.mikeandike08.taper.model;
import java.util.List;

public record PageResult<T>(List<T> items, long total) {
    public PageResult {
        items = List.copyOf(items);

        if (total < 0) {
            throw new IllegalArgumentException("Total must be non-negative");
        }
    }
}
