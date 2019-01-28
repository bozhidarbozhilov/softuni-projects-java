package app.models.dto.xmlProcessing.query2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsRootXmlDto {
    @XmlElement(name="user")
    private List<UserSoldProductXmlDto> userSoldProductXmlDtos;

    public UserSoldProductsRootXmlDto() {
    }

    public List<UserSoldProductXmlDto> getUserSoldProductXmlDtos() {
        return userSoldProductXmlDtos;
    }

    public void setUserSoldProductXmlDtos(List<UserSoldProductXmlDto> userSoldProductXmlDtos) {
        this.userSoldProductXmlDtos = userSoldProductXmlDtos;
    }
}
