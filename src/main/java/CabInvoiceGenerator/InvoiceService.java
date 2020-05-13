package CabInvoiceGenerator;

public class InvoiceService {
    double fare=0;
    private String userId;
    private RideRepository rideRepository;

    public InvoiceService(String userId) {
        this.userId = userId;
        rideRepository = new RideRepository();
    }

    public InvoiceService() {
        rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        return new Ride(distance,time).getFare();
    }

    public void addRide(double distance, int time) {
        rideRepository.addRide(distance,time);
    }

    public double calculateFare() {
        return rideRepository.getTotalFare();
    }

    public InvoiceGenerator getInvoice() {
        return new InvoiceGenerator(rideRepository);
    }

    public InvoiceGenerator getInvoice(String id) {
        if(id.equals(userId)){
            return getInvoice();
        }
        return null;
    }
}
