package alararestaurant.domain.entities;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name="categories")
public class Category extends BaseEntity{
    private String name;
    private Set<Item> items;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category", targetEntity = Item.class)
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
