import CabInvoiceGenerator.InvoiceSummary;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {
        InvoiceSummary invoiceSummary = new InvoiceSummary();
        double fare=invoiceSummary.calculateFare(2.5,5);
        Assert.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceSummary invoiceSummary = new InvoiceSummary();
        double fare=invoiceSummary.calculateFare(0.2,1);
        Assert.assertEquals(5,fare,0.0);
    }
}
