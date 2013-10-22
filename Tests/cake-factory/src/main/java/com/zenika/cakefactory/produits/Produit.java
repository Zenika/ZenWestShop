package com.zenika.cakefactory.produits;

/**
 * @author gtinon
 */
public abstract class Produit {

	protected final NatureProduit natureProduit;

	protected Produit(NatureProduit natureProduit) {
		this.natureProduit = natureProduit;
	}

	public abstract int getMasse();

	public NatureProduit getNatureProduit() {
		return natureProduit;
	}

}
