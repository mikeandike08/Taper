package io.github.mikeandike08.taper.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;


@Embeddable
public record AddressDTO(
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String street,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String city,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String state,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String zipCode
) {
    public static AddressDTO from(String street, String city, String state, String zipCode) {
        return new AddressDTO(street, city, state, zipCode);
    }
}
