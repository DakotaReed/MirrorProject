package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.ListenersAuto.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test 01: Verify Mortgage Repayment")
    @Description("Fill Form and Verify Mortgage Repayment")
    public void test01_verifyMortgageRepayment() {
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageCalculator.tv_repayment, "£30.03");
    }

}
