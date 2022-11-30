package ch.hearc.beershopfull.catalog.service;

import java.math.BigInteger;
import java.util.List;

import ch.hearc.beershopfull.catalog.model.Beer;

public interface CatalogService {

	/**
	 * Sauvegarde une nouvelle bière
	 * @param beer la bière
	 */
	public void addBeerToCatalog(Beer beer);
	
	/**
	 * Retourne toute les bières
	 * @return la liste des bières
	 */
	public List<Beer> getAllBeersFromCatalog();

	/**
	 * Retourne une bière par son id
	 * @param id
	 * @return
	 */
	public Beer getBeerById(BigInteger id);

	/**
	 * Met à jour une bière
	 * @param beer
	 */
	public void updateBeerInCatalog(Beer beer);

	/**
	 * Supprime une bière
	 * @param beer
	 */
	public void removeBeerInCatalog(Beer beer);
}
