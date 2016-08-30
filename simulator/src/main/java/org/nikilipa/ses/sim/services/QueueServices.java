package org.nikilipa.ses.sim.services;

import org.nikilipa.ses.sim.model.Task;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

/**
 * Created by nikilipa on 8/25/16.
 */
@Service
public class QueueServices {

    private final PriorityQueue<Task> creationQueue = new PriorityQueue<>();
    private final PriorityQueue<Task> validationQueue = new PriorityQueue<>();

    public PriorityQueue<Task> getValidationQueue() {
        return validationQueue;
    }

    public PriorityQueue<Task> getCreationQueue() {
        return creationQueue;
    }

}
