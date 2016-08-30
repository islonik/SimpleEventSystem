package org.nikilipa.ses.events.impl;

import org.nikilipa.ses.events.Event;
import org.nikilipa.ses.events.EventListener;
import org.nikilipa.ses.events.EventsManager;
import org.nikilipa.ses.events.EventsSubscriptionsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikilipa on 7/25/16.
 */
@Service
public class EventsManagerImpl implements EventsManager {

    @Autowired
    private EventsSubscriptionsManager eventsSubscriptionsManager;

    @Override
    public <T extends Event> void subscribe(Class<T> event, EventListener<T> listener) {
        eventsSubscriptionsManager.addSubscriber(event, listener);
    }

}