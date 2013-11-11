package com.zenika.cakefactory.chaines.impl;

import com.zenika.cakefactory.chaines.ChaineDeProduction;
import com.zenika.cakefactory.composants.*;
import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public class ChaineAssemblageTarte implements ChaineDeProduction<Gateau> {

	private Injecteur injecteur;

	private Four four;

	private Refrigerateur refrigerateur;

	@Override
	public Gateau activer(Produit... produits) {
		Gateau gateau = (Gateau) produits[0];
		Melange garniture = (Melange) produits[1];
		injecteur.injecter(gateau, garniture);
		four.cuire(gateau);
		return gateau;
	}


	public void setInjecteur(Injecteur injecteur) {
		this.injecteur = injecteur;
	}

	public void setFour(Four four) {
		this.four = four;
	}

	public void setRefrigerateur(Refrigerateur refrigerateur) {
		this.refrigerateur = refrigerateur;
	}

}
