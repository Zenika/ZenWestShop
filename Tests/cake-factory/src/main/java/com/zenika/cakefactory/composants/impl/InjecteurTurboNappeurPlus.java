package com.zenika.cakefactory.composants.impl;

import com.zenika.cakefactory.composants.Injecteur;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public class InjecteurTurboNappeurPlus implements Injecteur {

	@Override
	public void injecter(Gateau gateau, Melange garniture) {
		gateau.getCouches().add(garniture);
	}

}
