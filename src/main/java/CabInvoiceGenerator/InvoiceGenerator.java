package CabInvoiceGenerator;

import java.util.Objects;

public class InvoiceGenerator {
    private final double fare;
    private final int rides;
    private final double avgFarePerRide;

    public InvoiceGenerator(double fare, int rides) {
        this.fare = fare;
        this.rides = rides;
        this.avgFarePerRide = this.fare/this.rides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceGenerator that = (InvoiceGenerator) o;
        return Double.compare(that.fare, fare) == 0 &&
                rides == that.rides;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fare, rides);
    }
}
