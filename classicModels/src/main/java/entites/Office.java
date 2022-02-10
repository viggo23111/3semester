package entites;

import javax.persistence.*;

@Entity
@Table(name = "offices", schema = "classicmodels", catalog = "")
public class Office {
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    @Id
    @Column(name = "officeCode")
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "territory")
    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office office = (Office) o;

        if (officeCode != null ? !officeCode.equals(office.officeCode) : office.officeCode != null) return false;
        if (city != null ? !city.equals(office.city) : office.city != null) return false;
        if (phone != null ? !phone.equals(office.phone) : office.phone != null) return false;
        if (addressLine1 != null ? !addressLine1.equals(office.addressLine1) : office.addressLine1 != null)
            return false;
        if (addressLine2 != null ? !addressLine2.equals(office.addressLine2) : office.addressLine2 != null)
            return false;
        if (state != null ? !state.equals(office.state) : office.state != null) return false;
        if (country != null ? !country.equals(office.country) : office.country != null) return false;
        if (postalCode != null ? !postalCode.equals(office.postalCode) : office.postalCode != null) return false;
        if (territory != null ? !territory.equals(office.territory) : office.territory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = officeCode != null ? officeCode.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (territory != null ? territory.hashCode() : 0);
        return result;
    }
}
