package CabInvoiceGenerator;

public class InvoiceSummary {
    double fare=0;
    public double calculateFare(double distance, int time) {
        double rideFare =distance*10+time;
        if(rideFare<5){
            rideFare =5;
        }
        return rideFare;
    }

    public void addRide(double distance, int time) {
        fare = fare + calculateFare(distance,time);
    }

    public double calculateFare() {
        return fare;
    }
}
