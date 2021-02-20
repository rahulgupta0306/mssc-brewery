package demo.web.model.v2;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerPojoV2 {

	private UUID id;
	private String beerName;
	private BeerStyleEnum beerType;
	private Long upc;
}
