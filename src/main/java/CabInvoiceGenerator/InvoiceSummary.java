package CabInvoiceGenerator;

public class InvoiceSummary {
    double fare;
    public double calculateFare(double distance, int time) {
        fare =distance*10+time;
        if(fare<5){
            fare =5;
        }
        return fare;
    }
}
