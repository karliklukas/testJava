package calendar;

import java.util.Date;
import java.util.Iterator;

public class Calendar implements Iterable<EventSet> {

    private Tree<EventSet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }

    public void addEvent(Event event) {
        EventSet eventSet = new EventSet(event.getDate());
        if (calendar.contain(eventSet)) {
            eventSet = calendar.getData(eventSet);
        } else {
            calendar.add(eventSet);
        }

        eventSet.eventSet.add(event);
    }

    public EventSet eventsList(Date date) {
        return calendar.getData(new EventSet(date));
    }

    public void deleteAll(Date date) {
        calendar.erase(new EventSet(date));
    }
    
    @Override
    public Iterator<EventSet> iterator() {
        return calendar.iterator();
    }

}
