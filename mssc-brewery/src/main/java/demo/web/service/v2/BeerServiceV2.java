package demo.web.service.v2;

import java.util.UUID;

import demo.web.model.v2.BeerPojoV2;

public interface BeerServiceV2 {

	BeerPojoV2 getBeerById(UUID beerId);

	BeerPojoV2 saveNewBeer(BeerPojoV2 newBeer);

	void updateBeer(UUID beerId, BeerPojoV2 updateBeer);

	void deleteBeerById(UUID beerId);

}
