package io.github.mikeandike08.taper.dto;
import java.util.List;

/**
 * 
 * Creates a response with a list of items, and the page and size of the list
 * @param items - The list of items to return
 * @param page - Zero-based page index
 * @param size - The size of the page to be returned
 */
public record ListResponse<T>(List<T> items, int page, int size) {
    public ListResponse {
        items = List.copyOf(items);
    }
}
