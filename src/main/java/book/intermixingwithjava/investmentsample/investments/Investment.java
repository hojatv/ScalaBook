package book.intermixingwithjava.investmentsample.investments;

/**
 * Created by hovaheb on 12/5/2016.
 */
public class Investment {
    private String investmentName;
    private InvestmentType investmentType;

    public Investment(String name, InvestmentType type) {
        investmentName = name;
        investmentType = type;
    }

    public int yield() { return 0; }
}
