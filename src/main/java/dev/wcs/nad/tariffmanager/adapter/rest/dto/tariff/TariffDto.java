package dev.wcs.nad.tariffmanager.adapter.rest.dto.tariff;

import dev.wcs.nad.tariffmanager.persistence.entity.Option;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
public class TariffDto {

    private Long id;
    private String name;
    private BigDecimal price;

    private Set<Option> possibleOptions = new LinkedHashSet<>();

}
