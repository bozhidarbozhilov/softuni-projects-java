package alararestaurant.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name="items")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlItemRootDto {
    @XmlElement(name="item")
    public XmlItemImportDto[] items;

    public XmlItemImportDto[] getItems() {
        return items;
    }

    public void setItems(XmlItemImportDto[] items) {
        this.items = items;
    }
}
