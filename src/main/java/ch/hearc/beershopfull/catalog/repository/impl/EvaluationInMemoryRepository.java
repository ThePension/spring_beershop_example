package ch.hearc.beershopfull.catalog.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import ch.hearc.beershopfull.catalog.model.Evaluation;
import ch.hearc.beershopfull.catalog.repository.EvaluationRepository;

/**
 * Classe gérant l'accès aux données
 * @author Aubert Nicolas
 *
 */
@Repository
public class EvaluationInMemoryRepository implements EvaluationRepository
{
	private static List<Evaluation> EVALUATION_TABLE = new ArrayList<>();
	
	/**
	 * Sauvegarde d'une évaluation
	 * @param evaluation
	 */
	public void saveEvaluation(Evaluation evaluation)
	{
		// Get the biggest id in the table
		Optional<BigInteger> biggest_id = EVALUATION_TABLE
				.stream()
				.map(Evaluation::getId)
				.max(BigInteger::compareTo);

		if (biggest_id.isPresent())
		{
			evaluation.setId(biggest_id.get().add(BigInteger.ONE));
		} 
		else 
		{
			evaluation.setId(BigInteger.ONE);
		}

		EVALUATION_TABLE.add(evaluation);
	}
	
	/**
	 * Retourne toutes les évaluations
	 * @return
	 */
	public List<Evaluation> getAllEvaluations()
	{
		return EVALUATION_TABLE;
	}

	public Evaluation getEvaluationById(BigInteger id)
	{
		Optional<Evaluation> evaluation = EVALUATION_TABLE//
			.stream()//
			.filter(b -> b.getId().equals(id))//
			.findFirst();

		if (evaluation.isPresent()) return evaluation.get();

		return null;
	}

	/**
	 * Supprimer une évaluation
	 */
	public void deleteEvaluation(Evaluation evaluation)
	{
		EVALUATION_TABLE.remove(evaluation);
	}

	/**
	 * Mettre à jour une évaluation
	 */
	public void updateEvaluation(Evaluation evaluation)
	{
		// Get evaluation index in EVALUATION_TABLE
		OptionalInt index = IntStream
			.range(0, EVALUATION_TABLE.size())
			.filter(i -> EVALUATION_TABLE.get(i).getId().equals(evaluation.getId()))
			.findFirst();

		// Check that index is valid
		if (index.isPresent())
		{
			// Update beer
			EVALUATION_TABLE.set(index.getAsInt(), evaluation);
		}
	}
}
