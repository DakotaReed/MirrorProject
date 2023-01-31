package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgageCalculator.txt_amount, amount);
        MobileActions.updateText(mortgageCalculator.txt_term, term);
        MobileActions.updateText(mortgageCalculator.txt_rate, rate);
        MobileActions.tap(mortgageCalculator.btn_calculate);
    }

}
