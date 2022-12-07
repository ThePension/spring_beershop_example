package ch.hearc.beershopfull.catalog.model;

import java.math.BigInteger;

/**
 * Model of a Evaluation
 * @author Aunbert NIcolas
 *
 */
public class Evaluation {
	private BigInteger id;
    private BigInteger beerId;
    private Integer note;

	public Evaluation(BigInteger id, BigInteger beerId, Integer note) {
		super();
		this.id = id;
        this.beerId = beerId;
        this.note = note;
	}

	public Evaluation()
	{
		super();
		this.beerId = null;
		this.note = 5;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getBeerId() {
		return this.beerId;
	}
	
	public void setBeerId(BigInteger beerId) {
		this.beerId = beerId;
	}

	public Integer getNote() {
		return this.note;
	}
	
	public void setPrice(Integer note) {
		this.note = note;
	}

}
