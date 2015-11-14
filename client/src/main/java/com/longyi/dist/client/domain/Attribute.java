package com.longyi.dist.client.domain;

/**
 * Created by chenglongwei on 11/14/15.
 */
public class Attribute {
    private long minimumPeriod;
    private long maximumPeriod;
    private int greaterThan;
    private boolean cancel;

    public long getMinimumPeriod() {
        return minimumPeriod;
    }

    public void setMinimumPeriod(long minimumPeriod) {
        this.minimumPeriod = minimumPeriod;
    }

    public long getMaximumPeriod() {
        return maximumPeriod;
    }

    public void setMaximumPeriod(long maximumPeriod) {
        this.maximumPeriod = maximumPeriod;
    }

    public int getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(int greaterThan) {
        this.greaterThan = greaterThan;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
