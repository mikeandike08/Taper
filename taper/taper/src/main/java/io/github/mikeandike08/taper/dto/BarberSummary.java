package io.github.mikeandike08.taper.dto;
import java.util.Set;

import io.github.mikeandike08.taper.model.Barber;
import io.swagger.v3.oas.annotations.media.Schema;

public record BarberSummary(
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) Long id,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String name,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) String shopName,
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED) AddressDTO address,
    @Schema(types = {"string", "null"}, description = "Null if a bio is never set.") String bio,
    @Schema(types = {"string", "null"}, description = "Null if styles are never set.") Set<String> styles,
    @Schema(types = {"string", "null"}, description = "Null if a profile picture is never set.") String profileImageUrl
) 
{
    public BarberSummary{
        styles = Set.copyOf(styles);
    }

    /**
     * Give a summary of the barber without any sensitive information, such as email or phone number
     * @param barber
     * @return BarberSummary object with the barber's id, name, shop name, city, state, styles, and profile image URL
     */
    public static BarberSummary from(Barber barber){
        return new BarberSummary(
            barber.getId(),
            barber.getName(),
            barber.getShopName(),
            barber.getAddress(),
            barber.getBio(),
            barber.getStyles(),
            barber.getProfileImageUrl()
        );
    }
}
