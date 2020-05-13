import CabInvoiceGenerator.InvoiceGenerator;
import CabInvoiceGenerator.InvoiceService;
import CabInvoiceGenerator.RideRepository;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        InvoiceService invoiceService = new InvoiceService();
        double fare= invoiceService.calculateFare(2.5,5);
        Assert.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService();
        double fare= invoiceService.calculateFare(0.2,1);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_ShouldReturnFare() {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addRide(2,5);
        invoiceService.addRide(3.5,10);
        double fare= invoiceService.calculateFare();
        Assert.assertEquals(70,fare,0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_ShouldReturnInvoice() {
        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addRide(2,5);
        invoiceService.addRide(3.5,10);
        InvoiceGenerator invoice= invoiceService.getInvoice();
        RideRepository rideRepository = new RideRepository();
        rideRepository.addRide(2,5);
        rideRepository.addRide(3.5,10);
        Assert.assertEquals(invoice,new InvoiceGenerator(70,rideRepository));
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenRightUserId_ShouldReturnInvoice() {
        InvoiceService invoiceService = new InvoiceService("Bhavesh");
        invoiceService.addRide(2,5);
        invoiceService.addRide(3.5,10);
        InvoiceGenerator invoice= invoiceService.getInvoice("Bhavesh");
        RideRepository rideRepository = new RideRepository();
        rideRepository.addRide(2,5);
        rideRepository.addRide(3.5,10);
        Assert.assertEquals(invoice,new InvoiceGenerator(70,rideRepository));
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenWrongUserId_ShouldReturnInvoice() {
        InvoiceService invoiceService = new InvoiceService("Bhavesh");
        invoiceService.addRide(2,5);
        invoiceService.addRide(3.5,10);
        InvoiceGenerator invoice= invoiceService.getInvoice("Shivam");
        Assert.assertEquals(invoice,null);
    }
}
