package calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Event implements Comparable<Event>, Serializable {

    private Date date;
    private String title;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    @Override
    public int compareTo(Event event) {
        return date.compareTo(event.date);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Event event = (Event) object;
        
        return Objects.equals(this.date, event.date);
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {        
        return 97 * 5 + Objects.hashCode(this.date);
    }

    @Override
    public String toString() {
        return "Event{" + "date=" + date + ", title=" + title + '}';
    }

}
