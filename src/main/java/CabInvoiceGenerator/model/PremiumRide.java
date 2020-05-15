package CabInvoiceGenerator.model;

public class PremiumRide implements Ride {
    double distance;
    int time;
    double fare;
    public PremiumRide(double distance, int time) {
        this.distance = distance;
        this.time = time;
        calculateFare();
    }
    @Override
    public double calculateFare() {
        fare =distance*15+time*2;
        if(fare<20){
            fare =20;
        }
        return fare;
    }

    @Override
    public double getFare() {
        return fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PremiumRide that = (PremiumRide) o;
        return Double.compare(that.distance, distance) == 0 &&
                time == that.time &&
                Double.compare(that.fare, fare) == 0;
    }

}
