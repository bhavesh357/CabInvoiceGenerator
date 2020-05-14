package CabInvoiceGenerator;

import java.util.Objects;

public class InvoiceGenerator {
    private final double fare;
    private final RideRepository rides;
    private final double avgFarePerRide;

    public InvoiceGenerator(RideRepository rides) {
        this.fare = rides.getTotalFare();
        this.rides = rides;
        this.avgFarePerRide = this.fare/this.rides.getTotalRides();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceGenerator that = (InvoiceGenerator) o;
        return Double.compare(that.fare, fare) == 0 &&
                Double.compare(that.avgFarePerRide, avgFarePerRide) == 0 &&
                Objects.equals(rides, that.rides);
    }

}
