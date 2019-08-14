public class IndividualClient extends Client {

    public IndividualClient(String s){
        super(s);
    }

    public float makeClaim(int polNum){
        float a = 0f;
        if (getPolicy(polNum) == null){
            return 0;
        }
        if (getPolicy(polNum) instanceof DepreciatingPolicy) {
            ((DepreciatingPolicy) getPolicy(polNum)).depreciate();
            a = getPolicy(polNum).getAmount();
        }
        if (getPolicy(polNum) instanceof ExpiringPolicy) {
            a = getPolicy(polNum).handleClaim();
        }
        if (getPolicy(polNum) instanceof Policy){
            a = getPolicy(polNum).handleClaim();
            if (getNumPolicies() == 1) {
                cancelPolicy(polNum);
            }
        }
        return a;
    }
}
