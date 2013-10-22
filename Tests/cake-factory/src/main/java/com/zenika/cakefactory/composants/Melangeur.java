package com.zenika.cakefactory.composants;

import com.zenika.cakefactory.produits.sousproduits.Melange;
import com.zenika.cakefactory.produits.ingredients.Ingredient;

import java.util.Set;

/**
 * @author gtinon
 */
public interface Melangeur {

	public Set<Ingredient> melange(int tempsEnSecondes, Melange melange, Ingredient... ingredients);

	public Set<Ingredient> melange(int tempsEnSecondes, Melange melange, Set<Ingredient> ingredients);

}
