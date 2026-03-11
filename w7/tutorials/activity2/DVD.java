import java.util.Collections;
import java.util.List;

public class DVD extends AbstractItem {

    private final int durationMinutes;
    private final String director;
    private final List<String> actors;

    public DVD(int id, String title, String author,
            int durationMinutes, String director, List<String> actors) {
        super(id, title, author, ItemType.DVD);
        this.durationMinutes = durationMinutes;
        this.director = director;
        this.actors = List.copyOf(actors); 
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActors() {
        return Collections.unmodifiableList(actors);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" | Duration: %d min | Director: %s | Actors: %s",
                        durationMinutes, director, actors);
    }
}
