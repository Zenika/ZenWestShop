package com.zenika.cakefactory.composants;

import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public interface Lamineuse {

	public Gateau mouler(Melange melange);

}
