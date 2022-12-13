package ch.hearc.beershopfull.catalog.repository;

import java.math.BigInteger;
import java.util.List;

import ch.hearc.beershopfull.catalog.model.Evaluation;
/**
 * Interface de gestion des données des évaluations
 * @author Aubert Nicolas
 *
 */
public interface EvaluationRepository 
{
	/**
	 * Sauvegarde d'une évaluation
	 * @param evaluation
	 */
	public void saveEvaluation(Evaluation evaluation);
	
	
	/**
	 * Retourne toutes les évaluations
	 * @return
	 */
	public List<Evaluation> getAllEvaluations();

	/**
	 * Retourne une évaluation par son id
	 * @param id
	 * @return
	 */
	public Evaluation getEvaluationById(BigInteger id);

	/**
	 * Met à jour une évaluation
	 * @param evaluation
	 */
	public void updateEvaluation(Evaluation evaluation);

	/**
	 * Supprime une évaluation
	 * @param evaluation
	 */
	public void deleteEvaluation(Evaluation evaluation);

	/**
	 * Retourne toutes les évaluations d'une bière
	 * @param beer
	 */
	public List<Evaluation> getAllEvaluationsFromBeer(BigInteger beerId);

	/**
	 * Supprime toutes les évaluations d'une bière
	 */
	public void deleteAllEvaluationsFromBeer(BigInteger beerId);
}
