package calendar;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EventSet implements Comparable<EventSet> {

    public Date date;
    public Set<Event> eventSet;

    public EventSet() {
        eventSet = new HashSet<>();
    }

    public EventSet(Date date) {
        this.date = date;
        this.eventSet = new HashSet<>();
    }

    @Override
    public int compareTo(EventSet o) {
        return date.compareTo(o.date);
    }

}
