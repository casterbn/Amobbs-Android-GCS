package com.tlog.helper;

import com.tlog.helper.TLogParser.Event;

/**
 * Callback for asynchronous TLog iterator.
 */
public interface TLogIteratorCallback {

    /**
     * Callback for successful retrieval of next Event.
     *
     * @param event
     */
    void onResult(Event event);

    /**
     * Callback for unsuccessful retrieval of next Event.
     * {@link java.util.NoSuchElementException} is returned when the tlogs contain no more Events matching the criteria.
     *
     * @param e
     */
    void onFailed(Exception e);
}