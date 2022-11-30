package ch.hearc.beershopfull.catalog.model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Model of a beer
 * @author Seb
 *
 */
public class Beer {
	private BigInteger id;
	private String name;
	private BigDecimal price;
	private BigInteger stock;

	public Beer(String name, BigDecimal price, BigInteger stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public Beer()
	{
		super();
		this.name = "";
		this.price = new BigDecimal(0);
		this.stock = new BigInteger("0");
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setStock(BigInteger stock) {
		this.stock = stock;
	}

	public BigInteger getStock() {
		return stock;
	}
}
