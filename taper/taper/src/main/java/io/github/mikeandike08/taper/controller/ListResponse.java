package io.github.mikeandike08.taper.controller;
import java.util.List;

public class ListResponse<T> {
    private final List<T> items;

    public ListResponse(List<T> items){
        this.items = List.copyOf(items);
    }

    public List<T> getItems(){
        return items;
    }
}