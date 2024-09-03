package students;

/**
 * Represents a street address.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2024
 */
public final class Address {

    private final String streetAddress;
    private final String city;
    private final String province;
    private final String postalCode;

    /**
     * Constructs an Address object with the specified data.
     *
     * @param streetAddress as a String
     * @param city as a String
     * @param province as a String
     * @param postalCode as a String
     */
    public Address(final String streetAddress,
                   final String city,
                   final String province,
                   final String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Returns the street address as a string.
     * @return streetAddress as a String
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns the city as a string.
     * @return city as a String
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the province as a string.
     * @return province as a String
     */
    public String getProvince() {
        return province;
    }

    /**
     * Returns the postal code as a string.
     * @return postalCode as a String
     */
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Address{");
        sb.append("streetAddress='").append(getStreetAddress()).append('\'');
        sb.append(", city='").append(getCity()).append('\'');
        sb.append(", province='").append(getProvince()).append('\'');
        sb.append(", postalCode='").append(getPostalCode()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Address address = (Address) object;

        if (getStreetAddress() != null) {
            if (!getStreetAddress().equals(address.getStreetAddress())) {
                return false;
            }
        } else {
            if (address.getStreetAddress() != null) {
                return false;
            }
        }
        if (getCity() != null) {
            if (!getCity().equals(address.getCity())) {
                return false;
            }
        } else {
            if (address.getCity() != null) {
                return false;
            }
        }
        if (getProvince() != null) {
            if (!getProvince().equals(address.getProvince())) {
                return false;
            }
        } else {
            if (address.getProvince() != null) {
                return false;
            }
        }
        if (getPostalCode() != null) {
            return getPostalCode().equals(address.getPostalCode());
        }
        return address.getPostalCode() == null;
    }

    @Override
    public int hashCode() {
        int result;
        if (getStreetAddress() != null) {
            result = getStreetAddress().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getCity() != null) {
            result = usefulPrime * result + getCity().hashCode();
        } else {
            result = usefulPrime * result;
        }
        if (getProvince() != null) {
            result = usefulPrime * result + getProvince().hashCode();
        } else {
            result = usefulPrime * result;
        }
        if (getPostalCode() != null) {
            result = usefulPrime * result + getPostalCode().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
