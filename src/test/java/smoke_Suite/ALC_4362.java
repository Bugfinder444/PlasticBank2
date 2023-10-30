package smoke_Suite;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Bonus;
import alchemy_Pages.Branches;
import io.qameta.allure.Description;

public class ALC_4362 extends BaseClass {
	@Test(priority =0,enabled=true, description = "Approve_transactions_In_Bonus_Sell_Buy_Verify_In_BranchExchangeHistory")
	@Description("Approve_transactions_In_Bonus_Sell_Buy_Verify_In_BranchExchangeHistory")
	public void  Approve_transactions_In_Bonus_Sell_Buy_Verify_In_BranchExchangeHistory() throws IOException, InterruptedException {
		
		Data pn=new Data();
		Branches br = new Branches(alcDriver);
		Bonus bn =new Bonus(alcDriver);
		
		pn.runNewmanALC_4362_4363();
		
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
		Thread.sleep(3000);
		
		br.transactionApproveInBranch(Data.branch1_Number);
		bn.bonusVerifyInBonusApproval(Data.bonusName);
		
	}

	
}
