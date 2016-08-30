package org.nikilipa.ses.sim.model;

import org.nikilipa.ses.events.Priority;

/**
 * Created by nikilipa on 7/23/16.
 */
public class Task implements Comparable<Task> {

    private Priority priority;

    private int id;

    private String title;

    private String financeCode;

    private int estimate;

    public Task(Priority priority, int id, String title, String financeCode, int estimate) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.financeCode = financeCode;
        this.estimate = estimate;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getFinanceCode() {
        return financeCode;
    }

    public int getEstimate() {
        return estimate;
    }

    public int compareTo(Task that) {
        if (this.priority.getSort() > that.getPriority().getSort()) {
            return 1;
        } else if (this.priority.getSort() == that.getPriority().getSort()) {
            if (this.id > that.id) {
                return 1;
            } else if (that.id > this.id) {
                return -1;
            }
            return 0;
        } else {
            return -1;
        }
    }

}
