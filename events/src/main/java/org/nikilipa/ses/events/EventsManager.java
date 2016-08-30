package org.nikilipa.ses.events;

public interface EventsManager {

    public <T extends Event> void subscribe(Class<T> event, EventListener<T> listener);

}