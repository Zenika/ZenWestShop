package com.zenika.cakefactory.composants.impl;

import com.zenika.cakefactory.composants.Refrigerateur;
import com.zenika.cakefactory.produits.sousproduits.Gateau;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gtinon
 */
public class FrigogidaireIcyStar implements Refrigerateur {

	private Set<Gateau> gateaux = Collections.synchronizedSet(new HashSet<Gateau>());

	@Override
	public void stocker(Gateau gateau) {
		gateaux.add(gateau);
	}

}
