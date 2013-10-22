package com.zenika.cakefactory.chaines;

import com.zenika.cakefactory.produits.Produit;

/**
 * @author gtinon
 */
public interface ChaineDeProduction<OUT extends Produit> {

	public abstract OUT activer(Produit... produits);

}
