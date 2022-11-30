package ch.hearc.beershopfull.catalog.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.repository.BeerRepository;
import ch.hearc.beershopfull.catalog.service.CatalogService;


/**
 * Service de gestion du catalogue de bières
 * @author Seb
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService{
	
	@Autowired
	BeerRepository beerRepository; //repository d'accès aux données
	
	/**
	 * Sauvegarde une nouvelle bière
	 * @param beer la bière
	 */
	@Override
	public void addBeerToCatalog(Beer beer)
	{
		beerRepository.saveBeer(beer);
	}
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	@Override
	public List<Beer> getAllBeersFromCatalog()
	{
		return beerRepository.getAllBeers();
	}

	/**
	 * Retourne une bière par son id
	 */
	@Override
	public Beer getBeerById(BigInteger id)
	{
		return beerRepository.getBeerById(id);
	}

	/**
	 * Met à jour une bière
	 */
	@Override
	public void updateBeerInCatalog(Beer beer)
	{
		beerRepository.updateBeer(beer);
	}

	/**
	 * Supprime une bière
	 */
	@Override
	public void removeBeerInCatalog(Beer beer)
	{
		beerRepository.deleteBeer(beer);
	}
}
