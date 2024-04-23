package smoke_Suite;

import Utilities.BaseClass;
import alchemy_Pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class ALC_506 extends BaseClass {

    @Test(priority = 0,description =" Login ")
    public void Login() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

    }

    @Test(priority = 1, description = "Verify monthly snapshot download")
    public void verifyMonthlySnapshot() throws InterruptedException {

        Dashboard d =new Dashboard(alcDriver);
        d.monthlySnapshotDownload();


    }
    @Test(priority = 2, description = "Verify branch Report , Processor Report , Token Exchange History")
    public void verifyReport() throws InterruptedException {


        Reports r=new Reports(alcDriver);
        r.reportDownload(Reports.branchReport,Reports.branchReportExport,"plastic-bank-active-branches_export");
        r.reportDownload(Reports.processorReport,Reports.processorReportExport,"plastic-bank-active-processors_export");
        r.reportDownload(Reports.tokenExchangeHistory,Reports.tokenExchangeHistoryExport,"plastic-bank-tokens-transactions_export");


    }
    @Test(priority = 3, description = "Verify branch Report")
    public void verifyReportBranch() throws InterruptedException {

        Branches b = new Branches(alcDriver);
        b.reportDownload("partner-transactions_export");

    }
    @Test(priority = 4, description = "Verify Rando Bonus Order Report")
    public void verifyReportBonusOrder() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.reportDownload("bonus-transactions_export");

    }
    @Test(priority = 5, description = "Verify Store Report")
    public void verifyReportStore() throws InterruptedException {

        Stores s = new Stores(alcDriver);
        s.reportDownload("partner-transactions_export");

    }
    @Test(priority = 6, description = "Verify Processors Report")
    public void verifyReportProcessors() throws InterruptedException {

        Processors p = new Processors(alcDriver);
        p.reportDownload("partner-transactions_export");

    }
    @Test(priority = 7, description = "Verify Offsets Report")
    public void verifyOffsetsReport() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.offsetsReportDownload("offsets-report_export");

    }
    @Test(priority = 8, description = "Verify Offsets Report")
    public void verifyTransfersReport() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.transferReportDownload("transfers-report_export");

    }


}
