public class DepreciatingPolicy extends Policy{
    private float rate;

    public DepreciatingPolicy(float a, float r) {
        super(a);
        rate = r;
    }

    public float getRate() {
        return rate;
    }

    public String toString() {
        return "Depreciating" + super.toString() + String.format(" rate: %.1f", getRate()*100) +"%";
    }

    public boolean isExpired(){
        return(amount == 0);
    }

    public void depreciate() {
        amount = amount - (rate * amount);
    }

    public float handleClaim(){
        float i = getAmount();
        depreciate();
        return i;
    }
}
