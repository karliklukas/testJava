package calendar;

import java.util.Date;
import java.util.Iterator;

public class Calendar implements Iterable<EventSet> {

    @Override
    public Iterator<EventSet> iterator() {
        return calendar.iterator();
    }

    private Tree<EventSet> calendar;

    public Calendar() {
        calendar = new Tree<>();
    }

    public void addEvent(Event event) {
        EventSet es = new EventSet(event.getDate());
        if (calendar.contain(es)) {
            es = calendar.getData(es);
        } else {
            calendar.add(es);
        }

        es.eventSet.add(event);
    }

    public EventSet eventsList(Date date) {
        return calendar.getData(new EventSet(date));
    }

    public void deleteAll(Date date) {
        calendar.erase(new EventSet(date));
    }

}
