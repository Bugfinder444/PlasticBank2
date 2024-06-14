package smoke_Suite;

import Utilities.BaseClass;
import Utilities.ColumnVerify;
import alchemy_Pages.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Member;

public class ALC_506 extends BaseClass {

    @Test(priority = 0,description =" Verify Dashboard Kg Collected file(.csv) ")
    public void dashboardKgCollected() throws InterruptedException, IOException {

        AlchemyLoginPage login=new AlchemyLoginPage(alcDriver);
        login.alc_adminlogin("+919560071590","123456a");

        Dashboard d =new Dashboard(alcDriver);
        d.kgCollectedReport();

    }

    @Test(priority = 1, description = "Verify monthly snapshot download")
    public void verifyMonthlySnapshot() throws InterruptedException {

        Dashboard d =new Dashboard(alcDriver);
        d.monthlySnapshotDownload();


    }
    @Test(priority = 2, description = "Verify branch Report , Processor Report , Token Exchange History ,Branches Transaction History ")
    public void verifyReport() throws InterruptedException {

        ColumnVerify c= new ColumnVerify();
        Reports r=new Reports(alcDriver);

        String[] arrBranch={"Collection Point","Country","Total KG Recycled","Average Monthly KG Recycled","New Active Members","Active Members","Trust Score","Current Inventory"};
        r.reportDownload(Reports.branchReport,Reports.branchReportExport,"plastic-bank-active-branches_export");
        c.verifyColumn(arrBranch,"plastic-bank-active-branches_export");
        Thread.sleep(4000);

        String[] arrProcessor={"Processor Name","Country","Total KG Recycled","Average Monthly Recycled","Active Branches","Current Inventory"};
        r.reportDownload(Reports.processorReport,Reports.processorReportExport,"plastic-bank-active-processors_export");
        c.verifyColumn(arrProcessor,"plastic-bank-active-processors_export");
        Thread.sleep(4000);

        String[] arrTokenTran={"Seller Name","Seller Type","Buyer Name","Buyer Type","Amount","Date","Country","Seller Verified","Pin Off","Bonus"};
        r.reportDownload(Reports.tokenExchangeHistory,Reports.tokenExchangeHistoryExport,"plastic-bank-tokens-transactions_export");
        c.verifyColumn(arrTokenTran,"plastic-bank-tokens-transactions_export");

        String[] arrTokenBranchTranHis={"Transaction ID","Branch","Country","Date","Type","Buyer's Entity Name","Buyer's Name","Seller's Entity Name","Seller's Name","Weight","Value (USD)","Value Local Currency","Bonus","Tokens","Material Category","Material Category Local","Material Type","Material Type Local","Material Condition","Material Condition Local","Material Color","Material Color Local"};
        r.reportDownload(Reports.branchesTranHis,Reports.branchesTranHisExport,"plastic-bank-branches-transactions_export");
        c.verifyColumn(arrTokenBranchTranHis,"plastic-bank-branches-transactions_export");

    }
    @Test(priority = 3, description = "Verify branch Report")
    public void verifyReportBranch() throws InterruptedException {

        Branches b = new Branches(alcDriver);
        String[] arrBranchExcHis={"Date","Weight","Branch ID","Buyer Name","Buyer Type","Seller Name","Seller Type","Material Type","Material Type Local","Material Condition","Material Condition Local","Material Color","Material Color Local","Material Category","Material Category Local","Transaction Type","Delayed Bonus","Cash Value (USD)","Tokens In Wallet","Token Offset Value","Item Value From Store (USD)"};

        b.reportDownload("partner-transactions_export");
        ColumnVerify c= new ColumnVerify();
        c.verifyColumn(arrBranchExcHis,"partner-transactions_export");

    }
    @Test(priority = 4, description = "Verify Rando Bonus Order Report")
    public void verifyMemberReport() throws InterruptedException {

        Members m=new Members(alcDriver);
        m.reportDownload("members-report_export");

        String[] arrBonusOrdExcHis={"Id","Age","Name","Level","Phone","Gender","Country","National Id","Tokens in wallet","Registration date","Total KG Recycled","Phone Verification","Branch Registered by","Token Value in Local Currency","Suspended"};
        ColumnVerify c= new ColumnVerify();
        c.verifyColumn(arrBonusOrdExcHis,"members-report_export");

    }
    @Test(priority = 5, description = "Verify Rando Bonus Order Report")
    public void verifyReportBranchList() throws InterruptedException {

        Branches b = new Branches(alcDriver);
        b.reportDownloadBranchList("branches-list_report");

        String[] arrBranchListRep={"Name","Country","Phone","Tokens in Wallet","Total KG Recycled","Token Value in Local Currency","Suspended"};
        ColumnVerify c= new ColumnVerify();
        c.verifyColumn(arrBranchListRep,"branches-list_report");

    }
    @Test(priority = 6, description = "Verify Random Bonus Order Exchange History Report")
    public void verifyReportBonusOrderExcHis() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.reportDownload("bonus-transactions_export");

        String[] arrBonusOrdExcHis={"Transaction ID","Date (UTC)","Year","Country","Member Name","Seller ID","Buyer Name","Buyer ID","Transaction Type","Materials","Color","Total Weight","Total Bonus","Local Currency","Cash USD","Tokens","Total Value in USD (MP + BONUS)","Unique Impact Claim","Sponsor Claim","Bonus Claim","Supply Chain Claim","Verified Claim Status","Output","Output Status"};
        ColumnVerify c= new ColumnVerify();
        c.verifyColumn(arrBonusOrdExcHis,"bonus-transactions_export");

    }

    @Test(priority = 7, description = "Verify Store Report")
    public void verifyReportStore() throws InterruptedException {

        Stores s = new Stores(alcDriver);
        s.reportDownload("partner-transactions_export");
        String[] arrStoreExcHis={"Date","Summary","Quantity","Buyer Type","Member Name","Seller Name","Seller Type","Member Phone","Total Price USD","Cash-Out Details","Associated Branch","Total Token Value","Member National ID","Total Price Local Currency"};
        ColumnVerify c= new ColumnVerify();

        c.verifyColumn(arrStoreExcHis,"partner-transactions_export");

    }
    @Test(priority = 8, description = "Verify Processors Report in Exchange History | Verify Processors Report in Processor List ")
    public void verifyReportProcessors() throws InterruptedException {

        Processors p = new Processors(alcDriver);
        p.reportDownload("partner-transactions_export");

        String[] arrProcessorExcHis={"Date","Weight","Branch ID","Buyer Name","Buyer Type","Seller Name","Seller Type","Material Type","Material Type Local","Material Condition","Material Condition Local","Material Color","Material Color Local","Material Category","Material Category Local","Transaction Type","Total Coupon Value","Delayed Bonus","Cash Value (USD)","Tokens In Wallet","Token Offset Value","Item Value From Store (USD)"};
        ColumnVerify c= new ColumnVerify();
        c.verifyColumn(arrProcessorExcHis,"partner-transactions_export");


        p.reportDownloadList("processors-list_report");
        String[] arrProcessorExcHisList={"Name","Country","Phone","Tokens in Wallet","Total KG Recycled","Token Value in Local Currency","Suspended"};
        c.verifyColumn(arrProcessorExcHisList,"processors-list_report");

    }
    @Test(priority = 9, description = "Verify Bonus Order Report")
    public void verifyBonusOrder() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.offsetsReportDownload("offsets-report_export");
        ColumnVerify c= new ColumnVerify();
        String[] arrBonusOrder={"ID","Name","Brand","Country","Priority","Burn Rate","Issue Date","KG Promised","KG Delivered","KG Per Month","Pending Bonus $","Paid Bonus $","Pending KG","Paid KG","Benefit Pool $","Branch bonus/kg","People Impacted","Members bonus/kg","Processor bonus/kg","Unverified Receipts","Member Limit Per Day","Member Limit Per Exchange","Member Limit Per Material Type"};
        c.verifyColumn(arrBonusOrder,"offsets-report_export");

    }
    @Test(priority = 10, description = "Verify Offsets Report")
    public void verifyTransfersReport() throws InterruptedException {

        Bonus b = new Bonus(alcDriver);
        b.transferReportDownload("transfers-report_export");

        ColumnVerify c= new ColumnVerify();
        String[] arrTransfer={"Transfer date","Sender name","Recipient name","Reason","Transfer type","Amount","Recipient country","Message"};
        c.verifyColumn(arrTransfer,"transfers-report_export");

    }


}






































