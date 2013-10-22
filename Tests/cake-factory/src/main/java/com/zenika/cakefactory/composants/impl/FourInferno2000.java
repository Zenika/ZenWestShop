package com.zenika.cakefactory.composants.impl;

import com.zenika.cakefactory.composants.Four;
import com.zenika.cakefactory.produits.sousproduits.Gateau;

/**
 * @author gtinon
 */
public class FourInferno2000 implements Four {

	@Override
	public void cuire(Gateau gateau) {
		gateau.setCuit(true);
	}

}
