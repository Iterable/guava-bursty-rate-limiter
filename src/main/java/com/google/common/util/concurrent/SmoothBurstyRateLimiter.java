package com.google.common.util.concurrent;

/**
 * This class provides an API to create a bursty rate limiter with a specified burst period.
 *
 * <p>This is in package {@link com.google.common.util.concurrent} as a workaround to allow us to
 * create a custom instance of {@link SmoothRateLimiter.SmoothBursty} which is a private API from
 * Guava.
 */
public class SmoothBurstyRateLimiter {
  public static RateLimiter create(double permitsPerSecond, double maxBurstSeconds) {
    RateLimiter rateLimiter =
        new SmoothRateLimiter.SmoothBursty(
            RateLimiter.SleepingStopwatch.createFromSystemTimer(), maxBurstSeconds);
    rateLimiter.setRate(permitsPerSecond);
    return rateLimiter;
  }
}
