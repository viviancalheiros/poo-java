package hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation (int roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public int getRoomNumber () {
        return roomNumber;
    }

    public Date getCheckin () {
        return checkin;
    }

    public Date getCheckout () {
        return checkout;
    }

    public void setCheckin (Date checkin) {
        this.checkin = checkin;
    }

    public void setCheckout (Date checkout) {
        this.checkout = checkout;
    }

    public static Date stringToDate (String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Date format invalid.");
            return null;
        }
    }

    public boolean verifyDate (Date date) {
        Date today = new Date();
        
        long millis = date.getTime() - today.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(millis);

        if (days <= 0) return false;
        else return true;
    }

    public long duration (Date checkin, Date checkout) {
        if (checkin == null || checkout == null) return -1;

        long millis = checkout.getTime() - checkin.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(millis);

        if (days <= 0) {
            return -1;
        } else {
            return days;
        }
    }

    public void updateDates (Date checkin, Date checkout) {
        boolean checkinIsBefore = verifyDate(checkin);
        boolean checkoutIsBefore = verifyDate(checkout);
        if (checkinIsBefore == true && checkoutIsBefore == true && duration(checkin, checkout) != -1) {
            setCheckin(checkin);
            setCheckout(checkout);
        } else {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
    }
    
}