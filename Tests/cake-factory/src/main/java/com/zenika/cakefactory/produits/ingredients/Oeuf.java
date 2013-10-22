package com.zenika.cakefactory.produits.ingredients;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.util.PhysiqueNonRespecteeException;

/**
 * @author gtinon
 */
public class Oeuf extends Ingredient {

	public Oeuf(int masse) {
		super(NatureProduit.LIQUIDE, masse);
	}

}
