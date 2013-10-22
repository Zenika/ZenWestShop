package com.zenika.cakefactory.composants.impl;

import com.zenika.cakefactory.composants.Lamineuse;
import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;
import com.zenika.cakefactory.util.LocalRecrepitException;

/**
 * @author gtinon
 */
public class LamineuseMegaLamix implements Lamineuse {

	@Override
	public Gateau mouler(Melange melange) {
		if (melange.getNatureProduit() != NatureProduit.PATE) {
			throw new LocalRecrepitException("C'est moche ca !");
		}

		Gateau gateau = new Gateau();
		gateau.getCouches().add(melange);
		return gateau;
	}

}
