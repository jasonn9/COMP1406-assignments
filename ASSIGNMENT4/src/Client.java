import java.util.*;

public abstract class Client {
    private static final int MAX_POLICIES_PER_CLIENT = 10;

    private static int NEXT_CLIENT_ID = 1;

    private   String        name;
    private   int           id;
    protected Policy[]      policies;
    protected int           numPolicies;
    private String          className;

    public Client(String n) {
        name = n;
        id = NEXT_CLIENT_ID++;
        policies = new Policy[MAX_POLICIES_PER_CLIENT];
        numPolicies = 0;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public Policy[] getPolicies() { return policies; }
    public int getNumPolicies() { return numPolicies; }

    public String toString() {
        className = this.getClass().getName();
        if (className == "IndividualClient") {
            return String.format("IndividualClient: %06d amount: %s", getId(), getName());
        }
        return String.format("CompanyClient: %06d amount: %s", getId(), getName());
    }

    public float totalCoverage(){
        float total = 0;
        for (int i = 0; i < getNumPolicies(); i++){
            total += getPolicies()[i].getAmount();
        }
        return total;
    }

    public Policy addPolicy(Policy p){
        if (getNumPolicies() < MAX_POLICIES_PER_CLIENT){
            getPolicies()[getNumPolicies()] = p;
            numPolicies++;
            return p;
        }
        return null;
    }

    public Policy openPolicyFor(float amt) {
        Policy p = new Policy(amt);
        return(addPolicy(p));

    }

    public Policy openPolicyFor(float amt, float rate){
        DepreciatingPolicy d = new DepreciatingPolicy(amt, rate);
        return(addPolicy(d));

    }

    public Policy openPolicyFor(float amt, Date expire){
        ExpiringPolicy e = new ExpiringPolicy(amt, expire);
        return(addPolicy(e));
    }

    public Policy getPolicy(int polNum){
        for (int i = 0; i < getNumPolicies(); i++){
            if (getPolicies()[i].getPolicyNumber() == polNum){
                return getPolicies()[i];
            }
        }
        return null;
    }

    public boolean cancelPolicy(int polNum){
        int count = 0;
        //boolean pol;
        Policy [] temp = new Policy[policies.length - 1];
        for (int i = 0; i < getNumPolicies(); i++){
            if(getPolicies()[i].getPolicyNumber() != polNum){
                temp[count] = policies[i];
                count++;
                return false;
            }
        }
        //if (pol == true){
            //for (int j = count; j < getNumPolicies(); j++){
               // getPolicies()[j] = getPolicies()[j+1];
            //}
        //}
        policies = temp;
        return true;
    }

    public abstract float makeClaim(int polNum);
}