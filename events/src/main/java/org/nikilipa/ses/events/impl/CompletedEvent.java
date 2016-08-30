package org.nikilipa.ses.events.impl;

import org.nikilipa.ses.events.EventStatus;
import org.nikilipa.ses.events.Priority;

/**
 * Created by nikilipa on 7/26/16.
 */
public class CompletedEvent extends BaseEvent {

    public CompletedEvent(Priority priority, String title, String financeCode, int estimate) {
        super(priority, title, financeCode, estimate, EventStatus.COMPLETED);
    }

}
