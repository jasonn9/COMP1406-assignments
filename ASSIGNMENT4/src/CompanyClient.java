public class CompanyClient extends Client{

    public CompanyClient(String s){
        super(s);
    }

    public float makeClaim(int polNum){
        //boolean n = (getPolicy(polNum) == null);
        if (getPolicy(polNum) == null){
            return 0;
        }
        return(getPolicy(polNum).handleClaim());
    }
}
