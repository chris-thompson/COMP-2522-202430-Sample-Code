package generics;

/**
 * OrderedPair.
 *
 * @author BCIT
 * @version 2024
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public final class OrderedPair<K, V> {

    private final K first;
    private final V second;

    /**
     * Constructor for objects of type OrderedPair.
     *
     * @param key the key
     * @param value the value
     */
    public OrderedPair(final K key, final V value) {
        this.first = key;
        this.second = value;
    }

    /**
     * Returns the key.
     * @return first the key as a K
     */
    public K getFirst() {
        return first;
    }

    /**
     * Returns the value.
     * @return second the value as a V
     */
    public V getSecond() {
        return second;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        OrderedPair<?, ?> that = (OrderedPair<?, ?>) object;

        if (getFirst() != null) {
            if (!getFirst().equals(that.getFirst())) {
                return false;
            }
        } else {
            if (that.getFirst() != null) {
                return false;
            }
        }
        if (getSecond() != null) {
            return getSecond().equals(that.getSecond());
        }
        return that.getSecond() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getFirst() != null) {
            result = getFirst().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getSecond() != null) {
            result = usefulPrime * result + getSecond().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
