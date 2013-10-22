package com.zenika.cakefactory.produits.sousproduits;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gtinon
 */
public class Gateau extends Produit {

	private final List<Produit> couches = new ArrayList<>();

	private boolean cuit;

	public Gateau() {
		super(NatureProduit.SOLIDE);
	}

	@Override
	public int getMasse() {
		int masse = 0;
		for (Produit couche : couches) {
			masse += couche.getMasse();
		}
		return masse;
	}

	public void setCuit(boolean cuit) {
		this.cuit = cuit;
	}

	public List<Produit> getCouches() {
		return couches;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cerise\n");
		for (int i = couches.size() - 1; i >= 0; i--) {
			builder.append(couches.get(i));
			builder.append("\n");
		}
		builder.append("plat en carton");
		return builder.toString();
	}

}
