package demo.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.web.model.v2.BeerPojoV2;
import demo.web.service.v2.BeerServiceV2;

@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerService;

	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerPojoV2> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

	}

	@PostMapping // create new beer
	public ResponseEntity<Object> handlePost(@RequestBody BeerPojoV2 newBeer) {

		System.out.println(newBeer);
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.add("Location",
				"http://localhost:8081/api/v1/beer/" + beerService.saveNewBeer(newBeer).getId().toString());
		return new ResponseEntity<>(httpheader, HttpStatus.CREATED);
	}

	@PutMapping("/{beerId}")
	public ResponseEntity<Object> handlePut(@PathVariable("beerId") UUID beerId, @RequestBody BeerPojoV2 updateBeer) {
		System.out.println(updateBeer);
		beerService.updateBeer(beerId, updateBeer);
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.add("Location",
				"http://localhost:8081/api/v1/beer/" + beerService.saveNewBeer(updateBeer).getId().toString());
		return new ResponseEntity<>(httpheader, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteBeerById(beerId);
	}

}
