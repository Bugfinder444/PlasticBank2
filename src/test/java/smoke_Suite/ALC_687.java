package smoke_Suite;

import Utilities.*;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Orders;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_687 extends BaseClass {


    @Test(priority = 0,description =" Create Data and Perform Transactions 1 ")
    public void createTransaction1() throws InterruptedException, IOException {

        Data d1 = new Data();
        d1.runNewman_ALC687_4();


    }
    @Test(priority=1,description = "create Order In Alchemy and adding Processors | 1) Both Bonus and Non bonus transaction should be visible in Add from Exchange history section | 2) Corresponding Bonus order name for the bonus transaction and System offset for Non bonus transaction should appear under 'Bonus Orders' column in 'Associated Transaction Items From Exchange History | 3 Value validation: *Total kg on top | *Bonus details branch details | * Bonus color (green) | 4) Donation Transaction should be visible in Add from Exchange history section | 5) For the Donation Transaction , 'System Offset' should appear under 'Bonus Orders' column in \"Add from Exchange history\"  section | 6) Value validation: a)Total kg on top | b)Bonus details | c) branch details | d) Bonus color | 7) SP Order should fulfilled based on the KGs reached the Processor for Without bonus and Donation transactions in 'Total' widget that SP Order is fulfilled accordingly | 8) 'Total KG collected' should show the total KG reached the Processor and should match the graph'Pending' should show the KG remaining to fulfill the order | 9) Audit trail should be updated with the transaction details ")
    public void createOrder1AndVerifyTransfer() throws InterruptedException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+17783844311","778778");

        Orders o1= new Orders(alcDriver);
        o1.createOrder687(Data.processor_Name687);

    }
    @Test(priority=2,description = "Verify Audit Trail Report ")
    public void verifyAuditTrailsReport() throws InterruptedException {

        FileSearch fs= new FileSearch(alcDriver);
        fs.run("150");

    }

    @Test(priority=3,description = "Create Data and Perform Transactions 2 ")
    public void createTransactions2() throws InterruptedException, IOException {

        Data d2 = new Data();
        d2.runNewman_ALC687_2();

    }

    @Test(priority=4,description = "create Order2 In Alchemy and adding Processors | 1) Verify the default filter is SP/EPR Eligible. | 2) Verify *Transactions 1, 2, 3 and 5*  are seen and can be selected under SP/EPR Eligible filter. | 3) When Order filter is: Show all, verify all transactions 1, 2,3, 4, 5 are seen | 4)  Verify transaction is added to the Associated Transaction Items From Exchange History | 5) Verify the KGs are added to the doughnut graph of the SP Order | 6) SP Order Audit Trail: Verify the transaction is seen in the Audit Trail.")
    public void createOrder2AndVerifyTransfer() throws InterruptedException, IOException {


        Orders o1= new Orders(alcDriver);
        o1.createOrderAllPlastik(Data.processor_Name687_2);


    }
    @Test(priority=5,description = "create Order 3 In Alchemy and adding Processors | 1) Verify the default filter is SP/EPR Eligible.| 2) Verify *only Transactions 2,3, and 5* are seen and can be selected under SP/EPR Eligible filter.| 3) When Order filter is: Show all, verify all transactions 1-5 are seen.| 4) When Order filter is: Show all, verify *Transaction 1* is *grayed out  and is not selectable | 5) Verify transaction is added to the Associated Transaction Items From Exchange History | 6) Verify the KGs are added to the doughnut graph of the SP Order. | 7) SP Order Audit Trail: Verify the transaction is seen in the Audit Trail.")
    public void createOrder3AndVerifyTransfer() throws InterruptedException, IOException {


        Orders o2= new Orders(alcDriver);
        o2.createOrderAllPlastik2(Data.processor_Name687_2);

    }


}
