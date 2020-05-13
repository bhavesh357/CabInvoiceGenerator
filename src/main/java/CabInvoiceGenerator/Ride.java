package CabInvoiceGenerator;

import java.util.Objects;

public class Ride {
    double distance;
    int time;
    double fare;
    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
        calculateFare();
    }

    public double calculateFare() {
        fare =distance*10+time;
        if(fare<5){
            fare =5;
        }
        return fare;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Double.compare(ride.distance, distance) == 0 &&
                time == ride.time &&
                Double.compare(ride.fare, fare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, time, fare);
    }
}
