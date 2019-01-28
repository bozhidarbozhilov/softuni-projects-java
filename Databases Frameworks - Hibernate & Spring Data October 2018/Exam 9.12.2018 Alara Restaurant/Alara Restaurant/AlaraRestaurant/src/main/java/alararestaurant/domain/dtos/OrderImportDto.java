package alararestaurant.domain.dtos;

/*<customer>Garry</customer>
<employee>Maxwell Shanahan</employee>
<date-time>21/08/2017 13:22</date-time>
<type>ForHere</type>*/

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderImportDto {
    @XmlElement(name = "customer")
    private String customer;
    @XmlElement(name = "employee")
    private String employee;
    @XmlElement(name = "date-time")
    private String dateTime;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "items")
    private XmlItemRootDto items;

    @NotNull
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @NotNull
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @NotNull
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @NotNull
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public XmlItemRootDto getItems() {
        return items;
    }

    public void setItems(XmlItemRootDto items) {
        this.items = items;
    }
}
