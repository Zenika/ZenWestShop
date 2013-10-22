package com.zenika.cakefactory.composants;

import com.zenika.cakefactory.produits.ingredients.Ingredient;

/**
 * @author gtinon
 */
public interface Distributeur<OUT extends Ingredient> {

	/**
	 * @param masse quantite d'ingredient verse
	 */
	public OUT verserDose(int masse);

}
