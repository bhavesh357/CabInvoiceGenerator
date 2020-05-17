package CabInvoiceGenerator;

import CabInvoiceGenerator.exceptions.CabInvoiceException;
import CabInvoiceGenerator.model.NormalRide;
import CabInvoiceGenerator.model.PremiumRide;
import CabInvoiceGenerator.model.Ride;

import java.util.ArrayList;
import java.util.Objects;

public class RideRepository {
    ArrayList<Ride> listOfRides;
    private double totalFare=0;
    public RideRepository() {
        this.listOfRides = new ArrayList<Ride>();
    }

    public void addRide(double distance, int time) {
        if(distance >=0 && time >= 0) {
            listOfRides.add(new NormalRide(distance, time));
        }else{
            throw new CabInvoiceException(CabInvoiceException.ERROR_TYPE.NEGATIVE_INPUTS);
        }
    }

    public void addPremiumRide(double distance, int time) {
        if(distance >=0 && time >= 0) {
            listOfRides.add(new PremiumRide(distance, time));
        }else{
            throw new CabInvoiceException(CabInvoiceException.ERROR_TYPE.NEGATIVE_INPUTS);
        }
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

}
