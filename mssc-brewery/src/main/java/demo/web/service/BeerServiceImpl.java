package demo.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import demo.web.model.BeerPojo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerPojo getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerPojo.builder().id(UUID.randomUUID()).beerName("Corona").beerType("Malt").build();
	}

	@Override
	public BeerPojo saveNewBeer(BeerPojo newBeer) {
		return BeerPojo.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerPojo updateBeer) {

	}

	@Override
	public void deleteBeerById(UUID beerId) {
		log.debug("Deleting a beer ....");
	}

}
