package calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Event implements Comparable<Event>, Serializable {

    private Date date;
    private String title;
    private String text;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.date);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public String toString() {
        return "Event{" + "date=" + date + ", title=" + title + ", text=" + text + '}';
    }

}
