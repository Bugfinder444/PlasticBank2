package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Orders;
import org.testng.annotations.Test;
import java.io.IOException;

public class ALC_4356 extends BaseClass {

    @Test(priority = 0, description = "Create data and do Transactions")
    public void createDataAndPerformTransaction() throws IOException {

        Data pn = new Data();
        pn.data_ALC_4356();


    }
    @Test(priority=1,description = "create Order In Alchemy")
    public void createOrder() throws InterruptedException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin(adminphoneNumber,adminpassword);

        Orders o1= new Orders(alcDriver);
        o1.createOrder();

    }
    @Test(priority=2,description = "Update name of created Order In Alchemy")
    public void updateOrder() throws InterruptedException {

        Orders o2= new Orders(alcDriver);
        o2.editOrder();

    }
    @Test(priority=3,description = "Update name of created Order In Alchemy")
    public void addTransactionInExcHistory() throws InterruptedException {

        Orders o3= new Orders(alcDriver);
        o3.addFromExchangeHistory();

    }
}
