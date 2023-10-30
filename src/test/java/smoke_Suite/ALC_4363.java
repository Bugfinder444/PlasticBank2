package smoke_Suite;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.BaseClass;
import Utilities.Data;
import alchemy_Pages.AlchemyLoginPage;
import alchemy_Pages.Bonus;
import alchemy_Pages.Branches;
import io.qameta.allure.Description;

public class ALC_4363 extends BaseClass{

	@Test(priority =0,enabled=true, description = "Approve_transactions_branch_exchange_history_Verify_In_BonusApproval")
	@Description("Approve_transactions_branch_exchange_history_Verify_In_BonusApproval")	
	public void  Approve_transactions_branch_exchange_history_Verify_In_BonusApproval() throws IOException, InterruptedException {
		
		Data pn=new Data();
		Branches br1 = new Branches(alcDriver);
		Bonus bn1 =new Bonus(alcDriver);
		
		pn.runNewmanALC_4362_4363();
		
		AlchemyLoginPage loginAlchmey=new AlchemyLoginPage(alcDriver);
		loginAlchmey.alc_adminlogin(adminphoneNumber,adminpassword);
		Thread.sleep(3000);
		
		bn1.bonusApproval(Data.bonusName);
		br1.verifyBonusInBranchExcHistory(Data.branch1_Number);
		

}
}
