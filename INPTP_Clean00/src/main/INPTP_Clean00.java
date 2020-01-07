package main;

import calendar.Calendar;
import calendar.Event;
import calendar.EventSet;
import java.util.Date;
import java.util.List;
import persistence.Storage;

public class INPTP_Clean00 {
    
    public static void main(String[] args) {
        /* TODO:
         0) vytvořit git repozitář a COMMITovat každou dílčí ucelenou změnu!
         1) vyčistit kód (clean code)
         2) unit testy
         ---- je nutné důkladně otestovat binární strom
         ---- přidání do prázdného, neprázdného stromu (levá/pravá větev)
         ---- mazání - kořene, listu, vnitřních prvků
         ---- iterování přes prázdný/plný strom
         ---- testy kalendáře, skupiny událostí
         3) celý repozitář odevzdat na stag - semestrální práce

         Při nedostupnosti GIT nástroje využijte portable ("thumbdrive") edici
         ke stažení z: https://git-scm.com/download/win
         */

        Storage storage = new Storage();
        storage.store(new Event(new Date(117, 6, 1), "1-4"));
        storage.store(new Event(new Date(117, 7, 1), "1-4"));
        storage.unstore(new Event(new Date(117, 6, 1), "1-4"));

        List<Event> list = storage.load(Event.class);
        System.out.println(list);
        System.out.println("");

        //////////////////////////////////
        Calendar calendar = new Calendar();
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-1"));
        calendar.addEvent(new Event(new Date(117, 6, 2), "2-1"));
        calendar.addEvent(new Event(new Date(117, 6, 3), "3-1"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-2"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-3"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-4"));

        for (EventSet calendarItem : calendar) {
            System.out.println(calendarItem.date);
            System.out.println(calendarItem.eventSet);
        }

        calendar.deleteAll(new Date(117, 6, 1));
        System.out.println("");

        for (EventSet calendarItem : calendar) {
            System.out.println(calendarItem.date);
            System.out.println(calendarItem.eventSet);
        }

    }

}
