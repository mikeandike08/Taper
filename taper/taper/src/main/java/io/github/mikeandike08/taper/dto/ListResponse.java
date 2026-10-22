package io.github.mikeandike08.taper.dto;
import java.util.List;

/**
 * 
 * Creates a response with a list of items, and the page and size of the list
 * @param items - The list of items to return
 * @param page - Zero-based page index
 * @param size - The size of the page to be returned
 * @param totalItems - The total number of items available
 * @param totalPages - The total number of pages available
 */
public record ListResponse<T>(List<T> items, int page, int size, long totalItems, long totalPages) {
    public ListResponse {
        items = List.copyOf(items);
    }

    public static <T> ListResponse<T> of(List<T> items, int page, int size, long totalItems){
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        long totalPages = (totalItems + size - 1) / size;
        return new ListResponse<>(items, page, size, totalItems, totalPages);
    }
}
