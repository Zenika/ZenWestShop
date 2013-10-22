package com.zenika.cakefactory;

import com.zenika.cakefactory.chaines.ChaineDeProduction;
import com.zenika.cakefactory.chaines.impl.ChaineAssemblageTarte;
import com.zenika.cakefactory.chaines.impl.ChaineGarnitureChoco;
import com.zenika.cakefactory.chaines.impl.ChainePateTarte;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public class CakeFactory {

	private ChaineDeProduction<Gateau> chainePateTarte;

	private ChaineDeProduction<Melange> chaineGarnitureChoco;

	private ChaineDeProduction<Gateau> chaineAssemblageTarte;

	public Gateau faireUnBonGateau() {
		Gateau gateau = chainePateTarte.activer();
		Melange garniture = chaineGarnitureChoco.activer();
		gateau = chaineAssemblageTarte.activer(gateau, garniture);
		return gateau;
	}

	public void setChainePateTarte(ChaineDeProduction<Gateau> chainePateTarte) {
		this.chainePateTarte = chainePateTarte;
	}

	public void setChaineGarnitureChoco(ChaineDeProduction<Melange> chaineGarnitureChoco) {
		this.chaineGarnitureChoco = chaineGarnitureChoco;
	}

	public void setChaineAssemblageTarte(ChaineDeProduction<Gateau> chaineAssemblageTarte) {
		this.chaineAssemblageTarte = chaineAssemblageTarte;
	}
}
