package org.nikilipa.ses.events.impl;

import org.nikilipa.ses.events.Event;
import org.junit.Assert;
import org.junit.Test;
import org.nikilipa.ses.events.Priority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nikilipa on 7/26/16.
 */
public class BaseEventTest {

    @Test
    public void testEqualsContains() {
        String financeCode = "TestFinanceCode";

        List<Event> eventList = new ArrayList<>();
        eventList.add(new CreatedEvent(Priority.BLOCKER, "Task 1", financeCode, 10));
        eventList.add(new AcceptedEvent(Priority.CRITICAL, "Task 2", financeCode, 15));
        eventList.add(new RunningEvent(Priority.NORMAL, "Task 3", financeCode, 20));
        eventList.add(new CompletedEvent(Priority.NORMAL, "Task 4", financeCode, 25));

        Assert.assertTrue(eventList.contains(new CreatedEvent(Priority.BLOCKER, "Task 1", financeCode, 10)));
        Assert.assertTrue(eventList.contains(new AcceptedEvent(Priority.CRITICAL, "Task 2", financeCode, 15)));
        Assert.assertTrue(eventList.contains(new RunningEvent(Priority.NORMAL, "Task 3", financeCode, 20)));

    }

    @Test
    public void testCompareTo() {
        String financeCode = "TestFinanceCode";

        List<Event> sortedEventList = new ArrayList<>();
        sortedEventList.add(new CompletedEvent(Priority.NORMAL,  "Task 4", financeCode, 25));
        sortedEventList.add(new CompletedEvent(Priority.NORMAL,  "Task 3", financeCode, 50));
        sortedEventList.add(new AcceptedEvent(Priority.CRITICAL, "Task 2", financeCode, 15));
        sortedEventList.add(new RunningEvent(Priority.CRITICAL,  "Task 1", financeCode, 20));
        sortedEventList.add(new CreatedEvent(Priority.BLOCKER,   "Task 0", financeCode, 10));

        Collections.sort(sortedEventList);

        Assert.assertEquals("Task 0", sortedEventList.get(0).getTitle());
        Assert.assertEquals("Task 1", sortedEventList.get(1).getTitle());
        Assert.assertEquals("Task 2", sortedEventList.get(2).getTitle());
        Assert.assertEquals("Task 3", sortedEventList.get(3).getTitle());
        Assert.assertEquals("Task 4", sortedEventList.get(4).getTitle());

    }
}
