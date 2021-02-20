package demo.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BeerPojo {

	private UUID id;
	private String beerName;
	private String beerType;
	private Long upc;
}
