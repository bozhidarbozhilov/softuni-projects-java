package app.models.dtos.view;

/*    "Id": 4,
            "Name": "Airgas, Inc.",
            "partsCount": 5*/

import app.models.entities.Supplier;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import java.util.Collection;
import java.util.Set;

public class LocalSupplierDto {
    private long id;
    private String name;
    private int partsCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public static void configureMapping(ModelMapper mapper){
        Converter<Set, Integer> convertCollectionSize = new Converter<Set, Integer>() {
            @Override
            public Integer convert(MappingContext<Set, Integer> mappingContext) {
                return mappingContext.getSource().size();
            }
        };
        mapper.createTypeMap(Supplier.class, LocalSupplierDto.class)
                .addMappings(m->m.using(convertCollectionSize)
                        .map(src->src.getSuppliedParts(),
                                LocalSupplierDto::setPartsCount));
    }
}
