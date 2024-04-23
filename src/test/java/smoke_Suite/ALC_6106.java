package smoke_Suite;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Orders;
import org.testng.annotations.Test;

import java.io.IOException;


public class ALC_6106 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+17783844311","778778");

    }

    @Test(priority = 1,description =" Verify Disable Bonus Transaction Present In T1 | verify DisableBonus Transaction Added To SPOrder | verify Total KgCollected T1 in Donught graph ")
    public void verifyDisableBonusTransactionAddedToSPOrderT1() throws InterruptedException, IOException {

        Data d1 =new Data();
        d1.runNewman_ALC_6106();
        Orders o1 =new Orders(alcDriver);
        o1.verifyBonusPresentInSPOrder1(Data.sporderId_1_6106,250);

    }
    @Test(priority = 2,description =" Verify Disable Bonus Transaction Present In T2 | verify DisableBonus Transaction Added To SPOrder | verify Total KgCollected T2 in Donught graph ")
    public void verifyDisableBonusTransactionAddedToSPOrderT2() throws InterruptedException, IOException {

        Data d1 =new Data();
        d1.runNewman_ALC_6106_2();
        Orders o1 =new Orders(alcDriver);
        o1.verifyBonusPresentInSPOrder2(Data.sporderId_2_6106,60);


    }
    @Test(priority = 3,description =" Verify Disable Bonus Transaction Present In T3 | verify DisableBonus Transaction Added To SPOrder | verify Total KgCollected T3 in Donught graph ")
    public void verifyDisableBonusTransactionAddedToSPOrderT3() throws InterruptedException, IOException {

        Data d1 =new Data();
        d1.runNewman_ALC_6106_3();
        Orders o1 =new Orders(alcDriver);
        o1.verifyBonusPresentInSPOrder1(Data.sporderId_3_6106,130);
    }


}
