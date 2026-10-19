import java.util.List;

public class ListResponse<T> {
    private final List<T> items;

    public ListResponse(List<T> content){
        this.items = List.copyOf(items);
    }

    public List<T> getItems(){
        return items;
    }
}