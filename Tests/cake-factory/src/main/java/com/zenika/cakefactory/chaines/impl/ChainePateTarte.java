package com.zenika.cakefactory.chaines.impl;

import com.zenika.cakefactory.chaines.ChaineDeProduction;
import com.zenika.cakefactory.composants.Distributeur;
import com.zenika.cakefactory.composants.Lamineuse;
import com.zenika.cakefactory.composants.Melangeur;
import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.produits.ingredients.*;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gtinon
 */
public class ChainePateTarte implements ChaineDeProduction<Gateau> {

	private Distributeur<Farine> distributeurFarine;

	private Distributeur<Sucre> distributeurSucre;

	private Distributeur<BeurreFondu> distributeurBeurre;

	private Distributeur<Oeuf> distributeurOeufs;

	private Melangeur melangeur;

	private Lamineuse lamineuse;


	@Override
	@Transactional
	public Gateau activer(Produit... produits) {
		Melange melange = new Melange();

		// prepare la pate
		BeurreFondu beurre = distributeurBeurre.verserDose(50);
		Oeuf oeuf = distributeurOeufs.verserDose(50);
		Sucre sucre = distributeurSucre.verserDose(150);
		melangeur.melange(30, melange, beurre, oeuf, sucre);

		Farine farine1 = distributeurFarine.verserDose(50);
		Farine farine2 = distributeurFarine.verserDose(50);
		Farine farine3 = distributeurFarine.verserDose(50);
		Farine farine4 = distributeurFarine.verserDose(50);
		melangeur.melange(10, melange, farine1);
		melangeur.melange(10, melange, farine2);
		melangeur.melange(10, melange, farine3);
		melangeur.melange(20, melange, farine4);

		// moule le gateau
		Gateau gateau = lamineuse.mouler(melange);
		return gateau;
	}

	public void setDistributeurFarine(Distributeur distributeurFarine) {
		this.distributeurFarine = distributeurFarine;
	}

	public void setDistributeurSucre(Distributeur distributeurSucre) {
		this.distributeurSucre = distributeurSucre;
	}

	public void setDistributeurBeurre(Distributeur distributeurBeurre) {
		this.distributeurBeurre = distributeurBeurre;
	}

	public void setDistributeurOeufs(Distributeur distributeurOeufs) {
		this.distributeurOeufs = distributeurOeufs;
	}

	public void setMelangeur(Melangeur melangeur) {
		this.melangeur = melangeur;
	}

	public void setLamineuse(Lamineuse lamineuse) {
		this.lamineuse = lamineuse;
	}

}
