package com.zenika.cakefactory.chaines.impl;

import com.zenika.cakefactory.chaines.ChaineDeProduction;
import com.zenika.cakefactory.composants.Distributeur;
import com.zenika.cakefactory.composants.Melangeur;
import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.produits.ingredients.ChocolatFondu;
import com.zenika.cakefactory.produits.ingredients.CremeFraiche;
import com.zenika.cakefactory.produits.ingredients.Sucre;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public class ChaineGarnitureChoco implements ChaineDeProduction<Melange> {

	private Distributeur<ChocolatFondu> distributeurChocolat;

	private Distributeur<Sucre> distributeurSucre;

	private Distributeur<CremeFraiche> distributeurCremeFraiche;

	private Melangeur melangeur;

	@Override
	public Melange activer(Produit... produits) {
		Melange melange = new Melange();

		ChocolatFondu chocolatFondu = distributeurChocolat.verserDose(150);
		Sucre sucre = distributeurSucre.verserDose(100);
		CremeFraiche cremeFraiche = distributeurCremeFraiche.verserDose(150);

		melangeur.melange(60, melange, chocolatFondu, sucre, cremeFraiche);

		return melange;
	}


	public void setDistributeurChocolat(Distributeur<ChocolatFondu> distributeurChocolat) {
		this.distributeurChocolat = distributeurChocolat;
	}

	public void setDistributeurSucre(Distributeur<Sucre> distributeurSucre) {
		this.distributeurSucre = distributeurSucre;
	}

	public void setDistributeurCremeFraiche(Distributeur<CremeFraiche> distributeurCremeFraiche) {
		this.distributeurCremeFraiche = distributeurCremeFraiche;
	}

	public void setMelangeur(Melangeur melangeur) {
		this.melangeur = melangeur;
	}

}
