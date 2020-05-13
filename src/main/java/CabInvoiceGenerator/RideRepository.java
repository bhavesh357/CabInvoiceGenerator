package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Objects;

public class RideRepository {
    ArrayList<Ride> listOfRides;
    private double totalFare=0;
    public RideRepository() {
        this.listOfRides = new ArrayList<Ride>();
    }

    public void addRide(double distance, int time) {
        listOfRides.add(new Ride(distance,time));
    }

    public int getTotalRides() {
        return listOfRides.size();
    }

    public double getTotalFare() {
        totalFare=0;
        for (Ride r: listOfRides){
            totalFare+=r.getFare();
        }
        return totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideRepository that = (RideRepository) o;
        return Double.compare(that.totalFare, totalFare) == 0 &&
                Objects.equals(listOfRides, that.listOfRides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfRides, totalFare);
    }
}
