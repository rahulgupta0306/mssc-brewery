package demo.web.service;

import java.util.UUID;

import demo.web.model.BeerPojo;

public interface BeerService {

	BeerPojo getBeerById(UUID beerId);

	BeerPojo saveNewBeer(BeerPojo newBeer);

	void updateBeer(UUID beerId, BeerPojo updateBeer);

	void deleteBeerById(UUID beerId);

}
