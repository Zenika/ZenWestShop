package com.zenika.cakefactory.produits.ingredients;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.util.PhysiqueNonRespecteeException;

import java.lang.reflect.Constructor;

/**
 * @author gtinon
 */
public class Farine extends Ingredient {

	public Farine(int masse) {
		super(NatureProduit.POUDRE_NON_SOLUBLE, masse);
	}

}
