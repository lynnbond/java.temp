/**
 *  Copyright (c) 2011-2013 Terracotta, Inc.
 *  Copyright (c) 2011-2013 Oracle and/or its affiliates.
 *
 *  All rights reserved. Use is subject to license terms.
 */

package javax.cache.management;

import javax.management.MXBean;

/**
 * Cache statistics.
 * <p>
 * Statistics are accumulated from the time a cache is created. They can be reset
 * to zero using {@link #clear}.
 * <p>
 * There are no defined consistency semantics for statistics. Refer to the
 * implementation for precise semantics.
 * <p>
 * Each cache's statistics object must be registered with an ObjectName that is
 * unique and has the following type and attributes:
 * <p>
 * Type:
 * <code>javax.cache:type=CacheStatistics</code>
 * <p>
 * Required Attributes:
 * <ul>
 * <li>CacheManager the URI of the CacheManager
 * <li>Cache the name of the Cache
 * </ul>
 *
 * @author Greg Luck
 * @since 1.0
 */
@MXBean
public interface CacheStatisticsMXBean {

  /**
   * Clears the statistics counters to 0 for the associated Cache.
   */
  void clear();

  /**
   * The number of get requests that were satisfied by the cache.
   * <p>
   * {@link javax.cache.Cache#containsKey(Object)} is not a get request for
   * statistics purposes.
   * <p>
   * In a caches with multiple tiered storage, a hit may be implemented as a hit
   * to the cache or to the first tier.
   * <p>
   * For an {@link javax.cache.processor.EntryProcessor}, a hit occurs when the
   * key exists and an entry processor can be invoked against it, even if no
   * methods of {@link javax.cache.Cache.Entry} or
   * {@link javax.cache.processor.MutableEntry} are called.
   *
   * @return the number of hits
   */
  long getCacheHits();

  /**
   * This is a measure of cache efficiency.
   * <p>
   * It is calculated as:
   * {@link #getCacheHits} divided by {@link #getCacheGets ()} * 100.
   *
   * @return the percentage of successful hits, as a decimal e.g 75.
   */
  float getCacheHitPercentage();

  /**
   * A miss is a get request that is not satisfied.
   * <p>
   * In a simple cache a miss occurs when the cache does not satisfy the request.
   * <p>
   * {@link javax.cache.Cache#containsKey(Object)} is not a get request for
   * statistics purposes.
   * <p>
   * For an {@link javax.cache.processor.EntryProcessor}, a miss occurs when the
   * key does not exist and therefore an entry processor cannot be invoked
   * against it.
   * <p>
   * In a caches with multiple tiered storage, a miss may be implemented as a miss
   * to the cache or to the first tier.
   * <p>
   * In a read-through cache a miss is an absence of the key in the cache that
   * will trigger a call to a CacheLoader. So it is still a miss even though the
   * cache will load and return the value.
   * <p>
   * Refer to the implementation for precise semantics.
   *
   * @return the number of misses
   */
  long getCacheMisses();

  /**
   * Returns the percentage of cache accesses that did not find a requested entry
   * in the cache.
   * <p>
   * This is calculated as {@link #getCacheMisses()} divided by
   * {@link #getCacheGets()} * 100.
   *
   * @return the percentage of accesses that failed to find anything
   */
  float getCacheMissPercentage();

  /**
   * The total number of requests to the cache. This will be equal to the sum of
   * the hits and misses.
   * <p>
   * A "get" is an operation that returns the current or previous value. It does
   * not include checking for the existence of a key.
   * <p>
   * In a caches with multiple tiered storage, a gets may be implemented as a get
   * to the cache or to the first tier.
   *
   * @return the number of gets
   */
  long getCacheGets();

  /**
   * The total number of puts to the cache.
   * <p>
   * A put is counted even if it is immediately evicted.
   * <p>
   * Replaces, where a put occurs which overrides an existing mapping is counted
   * as a put.
   *
   * @return the number of puts
   */
  long getCachePuts();

  /**
   * The total number of removals from the cache. This does not include evictions,
   * where the cache itself initiates the removal to make space.
   *
   * @return the number of removals
   */
  long getCacheRemovals();

  /**
   * The total number of evictions from the cache. An eviction is a removal
   * initiated by the cache itself to free up space. An eviction is not treated as
   * a removal and does not appear in the removal counts.
   *
   * @return the number of evictions
   */
  long getCacheEvictions();

  /**
   * The mean time to execute gets.
   * <p>
   * In a read-through cache the time taken to load an entry on miss is not
   * included in get time.
   *
   * @return the time in µs
   */
  float getAverageGetTime();

  /**
   * The mean time to execute puts.
   *
   * @return the time in µs
   */
  float getAveragePutTime();

  /**
   * The mean time to execute removes.
   *
   * @return the time in µs
   */
  float getAverageRemoveTime();

}