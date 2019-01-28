package app.models.dto;

import app.models.entities.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Query4Dto {
    @XmlAttribute(name="count")
    private int usersCount;
    @XmlElement(name="user")
    private List<Query4UsersDto> users;

    public Query4Dto() {
    }

    public Query4Dto(int usersCount, List<Query4UsersDto> usersDtos) {
        this.usersCount = usersCount;
        this.users = usersDtos;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<Query4UsersDto> getUsers() {
        return users;
    }

    public void setUsers(List<Query4UsersDto> usersDtos) {
        this.users = usersDtos;
    }

}
