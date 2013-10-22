package com.zenika.cakefactory.produits.ingredients;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.util.PhysiqueNonRespecteeException;

/**
 * @author gtinon
 */
public class Lait extends Ingredient {

	public Lait(int masse) {
		super(NatureProduit.LIQUIDE, masse);
	}

}
