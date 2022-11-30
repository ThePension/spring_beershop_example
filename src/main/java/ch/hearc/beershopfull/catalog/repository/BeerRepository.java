package ch.hearc.beershopfull.catalog.repository;

import java.math.BigInteger;
import java.util.List;

import ch.hearc.beershopfull.catalog.model.Beer;
/**
 * Interface de gestion des données des bières
 * @author seb
 *
 */
public interface BeerRepository {

	/**
	 * Sauvegarde d'une bière
	 * @param beer
	 */
	public void saveBeer(Beer beer);
	
	
	/**
	 * Retourne toutes les bières
	 * @return
	 */
	public List<Beer> getAllBeers();

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
	public void updateBeer(Beer beer);

	/**
	 * Supprime une bière
	 * @param beer
	 */
	public void deleteBeer(Beer beer);
}
