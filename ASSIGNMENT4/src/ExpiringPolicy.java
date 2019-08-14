import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class ExpiringPolicy extends Policy {
    private Date expiryDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy (hh:ma)");

    public ExpiringPolicy(float a, Date e) {
        super(a);
        expiryDate = e;
    }

    public ExpiringPolicy (float a){
        super(a);
        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR,1);
        expiryDate = aCalendar.getTime();
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired(){
        if (new Date().after(getExpiryDate()) || new Date().equals(getExpiryDate())){
            return true;
        }
        return false;
    }

    public String toString(){
        if (isExpired()){
            return "Expiring" + super.toString() + " expired on: " + dateFormat.format(getExpiryDate());
        }
        return "Expiring" + super.toString() + " expires: " + dateFormat.format(getExpiryDate());
    }

    public float handleClaim(){
        if (isExpired()) {
            return 0;
        }
        else {
            return getAmount();
        }
    }
}
