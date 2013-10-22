package com.zenika.cakefactory.produits.ingredients;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.util.PhysiqueNonRespecteeException;

/**
 * @author gtinon
 */
public class BeurreFondu extends Ingredient {

	public BeurreFondu(int masse) {
		super(NatureProduit.LIQUIDE, masse);
	}

}
