# guava-bursty-rate-limiter

This is a small library to provide an additional public API for the Guava rate limiter. The library provides an API, `SmoothBurstyRateLimiter`, that lets you create a rate limiter with bursts of a given period (other than the default 1 second). This effectively implements https://github.com/google/guava/issues/1974 as a separate library.

It can be used like this:

```java
import com.google.common.util.concurrent.SmoothBurstyRateLimiter;

/* ... */

// Create a rate limiter with 10 qps with a burst period of 30s (max burst of 300).
RateLimiter rateLimiter = SmoothBurstyRateLimiter.create(10, 30);

```
