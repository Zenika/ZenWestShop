package com.zenika.cakefactory.produits.sousproduits;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.produits.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gtinon
 */
public class Melange extends Produit {

	private int masse;

	private boolean grumeaux;

	private Set<Ingredient> ingredients = new HashSet<>();

	public Melange() {
		super(null);
	}

	public void add(Ingredient produit) {
		masse += produit.getMasse();

		for (Ingredient ingredient : ingredients) {
			if (ingredient.getClass() == produit.getClass()) {
				ingredient.ajouter(produit.getMasse());
				produit = null;
				break;
			}
		}
		if (produit != null) {
			ingredients.add(produit);
		}
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	@Override
	public NatureProduit getNatureProduit() {
		if (masse == 0) {
			return null;
		}

		int masseLiquides = 0;
		int massePoudresNonSolubles = 0;
		int massePoudresSolubles = 0;
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getNatureProduit() == NatureProduit.LIQUIDE) {
				masseLiquides = +ingredient.getMasse();
			}
			if (ingredient.getNatureProduit() == NatureProduit.POUDRE_SOLUBLE) {
				massePoudresSolubles = +ingredient.getMasse();
			}
			if (ingredient.getNatureProduit() == NatureProduit.POUDRE_NON_SOLUBLE) {
				massePoudresNonSolubles = +ingredient.getMasse();
			}
		}

		int massePoudres = massePoudresNonSolubles + massePoudresSolubles;
		if (massePoudres == 0 && masseLiquides == 0) {
			return null;
		}
		if (massePoudres > 0 && masseLiquides < massePoudres / 10) {
			if (massePoudresNonSolubles > 0) {
				return NatureProduit.POUDRE_NON_SOLUBLE;
			} else {
				return NatureProduit.POUDRE_SOLUBLE;
			}
		} else if (masseLiquides > 0 && massePoudresNonSolubles < masseLiquides / 2) {
			return NatureProduit.LIQUIDE;
		} else {
			return NatureProduit.PATE;
		}
	}


	public boolean isGrumeaux() {
		return grumeaux;
	}

	public void setGrumeaux(boolean grumeaux) {
		this.grumeaux = grumeaux;
	}

	@Override
	public int getMasse() {
		return masse;
	}

	@Override
	public String toString() {
		return "Melange{" + "masse=" + masse + ", grumeaux=" + grumeaux + ", ingredients=" + ingredients + '}';
	}
}
