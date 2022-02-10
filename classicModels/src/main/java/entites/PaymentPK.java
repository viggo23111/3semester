package entites;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PaymentPK implements Serializable {
    private int customerNumber;
    private String checkNumber;

    @Column(name = "customerNumber")
    @Id
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Column(name = "checkNumber")
    @Id
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentPK paymentPK = (PaymentPK) o;

        if (customerNumber != paymentPK.customerNumber) return false;
        if (checkNumber != null ? !checkNumber.equals(paymentPK.checkNumber) : paymentPK.checkNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerNumber;
        result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
        return result;
    }
}
