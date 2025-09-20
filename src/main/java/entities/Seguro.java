package entities;

import java.math.BigDecimal;

public class Seguro {
	private int id;
	private String description;
	private TypeSeguro typeSeguro;
	private BigDecimal contractingCost;
	private BigDecimal insuranceCost;

	public Seguro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeSeguro getTypeSeguro() {
		return typeSeguro;
	}

	public void setTypeSeguro(TypeSeguro typeSeguro) {
		this.typeSeguro = typeSeguro;
	}

	public BigDecimal getContractingCost() {
		return contractingCost;
	}

	public void setContractingCost(BigDecimal contractingCost) {
		this.contractingCost = contractingCost;
	}

	public BigDecimal getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(BigDecimal insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", description=" + description + ", typeSeguro=" + typeSeguro
		    + ", contractingCost=" + contractingCost + ", insuranceCost=" + insuranceCost + "]";
	}

}
