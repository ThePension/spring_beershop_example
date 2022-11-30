package ch.hearc.beershopfull.catalog.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;

/**
 * Classe gérant l'accès aux données
 * @author Seb
 *
 */
@Repository
public class BeerInMemoryRepository implements BeerRepository
{
	private static List<Beer> BEER_TABLE = new ArrayList<>();
	
	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer)
	{
		// Get the biggest id in the table
		Optional<BigInteger> biggest_id = BEER_TABLE.stream()
				.map(Beer::getId)
				.max(BigInteger::compareTo);

		if (biggest_id.isPresent())
		{
			beer.setId(biggest_id.get().add(BigInteger.ONE));
		} 
		else 
		{
			beer.setId(BigInteger.ONE);
		}

		BEER_TABLE.add(beer);
	}
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers()
	{
		return BEER_TABLE;
	}

	public Beer getBeerById(BigInteger id)
	{
		Optional<Beer> beer = BEER_TABLE//
			.stream()//
			.filter(b -> b.getId().equals(id))//
			.findFirst();

		if (beer.isPresent()) return beer.get();

		return null;
	}

	/**
	 * Supprimer une bière
	 */
	public void deleteBeer(Beer beer)
	{
		BEER_TABLE.remove(beer);
	}

	/**
	 * Mettre à jour une bière
	 */
	public void updateBeer(Beer beer)
	{
		// Get beer index in BEER_TABLE
		OptionalInt index = IntStream.range(0, BEER_TABLE.size())
			.filter(i -> BEER_TABLE.get(i).getId().equals(beer.getId()))
			.findFirst();

		// Check that index is valid
		if (index.isPresent())
		{
			// Update beer
			BEER_TABLE.set(index.getAsInt(), beer);
		}
	}
}
