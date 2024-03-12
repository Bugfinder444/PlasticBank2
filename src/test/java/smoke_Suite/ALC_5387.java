package smoke_Suite;

import Utilities.BaseClass;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Users;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_5387 extends BaseClass {

    public String numberAshish ="+919560071590";
    public String numberKalin ="+17783844311";
    public String passwordKalin ="778778";
    public String numberGayas ="+916394605799";


    @Test(priority = 0,description =" Login ")
    public void LoginSuperAdmin() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        Users usr = new Users(alcDriver);
        login.alc_adminlogin(numberKalin,passwordKalin);

        Thread.sleep(2000);
        usr.verifyClickReadOnly(numberGayas);
        usr.logOut();
        Thread.sleep(2000);


    }
    @Test(priority = 1,description =" Login ")
    public void LoginAdmin() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        Users usr = new Users(alcDriver);
        login.alc_adminlogin(numberAshish,password);

        Thread.sleep(2000);
        usr.verifyClickReadOnly(numberGayas);
        Thread.sleep(2000);
        usr.logOut();
        Thread.sleep(2000);

    }
    @Test(priority = 2,description =" Login ")
    public void LoginAppManager() throws InterruptedException, IOException {


        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin(numberGayas,password);
        Users usr = new Users(alcDriver);

        Thread.sleep(2000);
        usr.verifyReadOnlyDisabled();
        Thread.sleep(2000);
        usr.logOut();

    }



}
