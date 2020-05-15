package CabInvoiceGenerator.model;

public class NormalRide implements Ride {
    double distance;
    int time;
    double fare;
    public NormalRide(double distance, int time) {
        this.distance = distance;
        this.time = time;
        calculateFare();
    }
    @Override
    public double calculateFare() {
        fare =distance*10+time;
        if(fare<5){
            fare =5;
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
        NormalRide that = (NormalRide) o;
        return Double.compare(that.distance, distance) == 0 &&
                time == that.time &&
                Double.compare(that.fare, fare) == 0;
    }

}
