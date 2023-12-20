package smoke_Suite;

import Utilities.*;
import alchemy_Pages.AlchemyLoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_687 extends BaseClass {


@Test
    public void run() throws InterruptedException, IOException {

    restAssured_ALC_687 r1 = new restAssured_ALC_687();
    r1.sendPostRequest();

    }
   @Test
    public void run2() throws InterruptedException, IOException {

//        Data d = new Data();
//
//        d.runNewman_ALC687_2();
//        System.out.println("......2nd done");
        // d.runNewman_ALC687_3();
        //System.out.println("......3rd done");
        //d.runNewman_ALC687_4();
        //System.out.println("......4th done");

    }

}
