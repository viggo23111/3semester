package entites;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderdetailPK implements Serializable {
    private int orderNumber;
    private String productCode;

    @Column(name = "orderNumber")
    @Id
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Column(name = "productCode")
    @Id
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailPK that = (OrderdetailPK) o;

        if (orderNumber != that.orderNumber) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        return result;
    }
}
