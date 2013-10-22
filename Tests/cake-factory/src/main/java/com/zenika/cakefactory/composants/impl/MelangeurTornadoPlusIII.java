package com.zenika.cakefactory.composants.impl;

import com.google.common.collect.Sets;
import com.zenika.cakefactory.composants.Melangeur;
import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.ingredients.Ingredient;
import com.zenika.cakefactory.produits.sousproduits.Melange;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author gtinon
 */
public class MelangeurTornadoPlusIII implements Melangeur {

	@Override
	public Set<Ingredient> melange(int tempsEnSecondes, Melange melange, Ingredient... ingredientsArray) {
		Set<Ingredient> ingredients = Sets.newHashSet(ingredientsArray);
		return melange(tempsEnSecondes, melange, ingredients);
	}

	public Set<Ingredient> melange(int tempsEnSecondes, Melange melange, Set<Ingredient> ingredients) {
		if (tempsEnSecondes < 0 || ingredients.isEmpty() || melange == null) {
			return ingredients;
		}

		// fusionne les ingredients identiques
		fusionnerIngredientsIdentiques(ingredients);

		// ajoute tous les liquides dans le melange
		NatureProduit natureProduit = melange.getNatureProduit();
		if (natureProduit == null || natureProduit == NatureProduit.LIQUIDE) {
			absorbe(melange, ingredients, NatureProduit.LIQUIDE);
		} else {
			absorbe(melange, ingredients, NatureProduit.LIQUIDE, tempsEnSecondes, 10);
		}

		// dissout les poudres solubles dans le melange
		natureProduit = melange.getNatureProduit();
		if (natureProduit == NatureProduit.LIQUIDE) {
			absorbe(melange, ingredients, NatureProduit.POUDRE_SOLUBLE, tempsEnSecondes, 5);
		} else if (natureProduit == NatureProduit.PATE) {
			absorbe(melange, ingredients, NatureProduit.POUDRE_SOLUBLE, tempsEnSecondes, 2);
		} else {
			absorbe(melange, ingredients, NatureProduit.POUDRE_SOLUBLE);
		}

		// agrege les poudres non solubles
		natureProduit = melange.getNatureProduit();
		if (natureProduit == NatureProduit.LIQUIDE || natureProduit == NatureProduit.PATE) {
			absorbe(melange, ingredients, NatureProduit.POUDRE_NON_SOLUBLE, tempsEnSecondes, 2);
		} else {
			absorbe(melange, ingredients, NatureProduit.POUDRE_NON_SOLUBLE);
		}

		// agrege les ingredients en morceaux si le melange est pateux
		natureProduit = melange.getNatureProduit();
		if (natureProduit == NatureProduit.PATE) {
			absorbe(melange, ingredients, NatureProduit.MORCEAUX);
		}

		return ingredients;
	}

	protected void fusionnerIngredientsIdentiques(Set<Ingredient> ingredients) {
		Map<Class<? extends Ingredient>, Ingredient> ingredientsByType = new HashMap<>();
		for (Ingredient currIngredient : ingredients) {
			Ingredient ingredient = ingredientsByType.get(currIngredient.getClass());
			if (ingredient == null) {
				ingredientsByType.put(currIngredient.getClass(), currIngredient);
			} else {
				ingredient.ajouter(currIngredient.getMasse());
			}
		}
		ingredients.clear();
		ingredients.addAll(ingredientsByType.values());
	}

	protected void absorbe(Melange melange, Set<Ingredient> ingredients, NatureProduit typeProduit) {
		absorbe(melange, ingredients, typeProduit, Integer.MAX_VALUE, 1);
	}

	protected void absorbe(Melange melange, Set<Ingredient> ingredients, NatureProduit typeProduit,
	                       int tempsEnSecondes,
	                       int masseAbsorbeeParSeconde) {

		for (Ingredient ingredient : Sets.newHashSet(ingredients)) {
			NatureProduit nature = ingredient.getNatureProduit();
			if (nature == typeProduit) {
				int maxMasseAbsorbee = masseAbsorbeeParSeconde * tempsEnSecondes;
				if (maxMasseAbsorbee >= ingredient.getMasse()) {
					melange.add(ingredient);
					ingredients.remove(ingredient);

				} else {
					Ingredient partieAbsorbee = ingredient.diviser(maxMasseAbsorbee);
					melange.add(partieAbsorbee);
				}
			}
		}
	}

}
