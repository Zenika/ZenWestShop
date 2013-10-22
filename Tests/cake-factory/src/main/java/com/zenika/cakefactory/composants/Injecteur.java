package com.zenika.cakefactory.composants;

import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import com.zenika.cakefactory.produits.sousproduits.Melange;

/**
 * @author gtinon
 */
public interface Injecteur {

	public void injecter(Gateau gateau, Melange garniture);

}
