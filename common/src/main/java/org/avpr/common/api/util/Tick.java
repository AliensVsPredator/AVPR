package org.avpr.common.api.util;

/**
 * The Tick record provides constants and utility methods to handle game tick operations. A game tick is a unit of time
 * used in game development, where a certain number of ticks occur per second and can be utilized to manage
 * timing-related tasks.
 */
public record Tick() {

    // TODO: This is a utility class, this should not be a record.

    public static final int PER_SECOND = 20;

    public static final int PER_MINUTE = 60 * PER_SECOND;

    public static final int PER_HOUR = 60 * PER_MINUTE * PER_SECOND;

    public static final int MILLIS_PER_TICK = 1000 / PER_SECOND;

    public static int fromMillis(int millis) {
        if (millis <= 0) {
            throw new IllegalArgumentException("Milliseconds must not be less than zero.");
        }
        return millis / MILLIS_PER_TICK;
    }

    public static int fromSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Seconds must not be less than zero.");
        }
        return seconds * PER_SECOND;
    }

    public static int fromMinutes(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("Minutes must not be less than zero.");
        }
        return minutes * PER_MINUTE;
    }

    public static int fromHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Hours must not be less than zero.");
        }
        return hours * PER_HOUR;
    }
}
