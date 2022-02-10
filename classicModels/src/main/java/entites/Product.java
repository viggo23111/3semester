package entites;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "classicmodels", catalog = "")
public class Product {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private double buyPrice;
    private double msrp;

    @Id
    @Column(name = "productCode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productLine")
    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    @Basic
    @Column(name = "productScale")
    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Basic
    @Column(name = "productVendor")
    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Basic
    @Column(name = "productDescription")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "quantityInStock")
    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Basic
    @Column(name = "buyPrice")
    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Basic
    @Column(name = "MSRP")
    public double getMsrp() {
        return msrp;
    }

    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (quantityInStock != product.quantityInStock) return false;
        if (Double.compare(product.buyPrice, buyPrice) != 0) return false;
        if (Double.compare(product.msrp, msrp) != 0) return false;
        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productLine != null ? !productLine.equals(product.productLine) : product.productLine != null) return false;
        if (productScale != null ? !productScale.equals(product.productScale) : product.productScale != null)
            return false;
        if (productVendor != null ? !productVendor.equals(product.productVendor) : product.productVendor != null)
            return false;
        if (productDescription != null ? !productDescription.equals(product.productDescription) : product.productDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productCode != null ? productCode.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productLine != null ? productLine.hashCode() : 0);
        result = 31 * result + (productScale != null ? productScale.hashCode() : 0);
        result = 31 * result + (productVendor != null ? productVendor.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (int) quantityInStock;
        temp = Double.doubleToLongBits(buyPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(msrp);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
