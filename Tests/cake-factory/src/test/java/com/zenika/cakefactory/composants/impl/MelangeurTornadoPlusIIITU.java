package com.zenika.cakefactory.composants.impl;

import com.google.common.collect.Sets;
import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.ingredients.*;
import com.zenika.cakefactory.produits.sousproduits.Melange;

import static org.fest.assertions.api.Assertions.*;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author gtinon
 */
public class MelangeurTornadoPlusIIITU {

	private MelangeurTornadoPlusIII melangeur;
	private Melange melange;

	@Before
	public void setUp() {
		melangeur = new MelangeurTornadoPlusIII();
		melange = new Melange();
	}

	@Test
	public void testMelangeLiquidesInstantane() {
		// prepare
		Lait lait = new Lait(50);
		Oeuf oeuf = new Oeuf(50);

		// test
		melangeur.melange(1, melange, lait, oeuf);

		// checks
		assertThat(melange.getIngredients()).containsOnly(lait, oeuf);
		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.LIQUIDE);
	}

	@Test
	public void testMelangePoudresInstantane() {
		// prepare
		Sucre sucre = new Sucre(50);
		Farine farine = new Farine(50);

		// test
		melangeur.melange(1, melange, sucre, farine);

		// checks
		assertThat(melange.getIngredients()).containsOnly(sucre, farine);
		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.POUDRE_NON_SOLUBLE);
	}

	@Test
	public void testMelangePoudreSolubleEtLiquide() {
		// prepare
		Sucre sucre = new Sucre(50);
		Lait lait = new Lait(50);

		// tests
		Set<Ingredient> ingredients = melangeur.melange(1, melange, sucre, lait);
		assertThat(melange.getIngredients()).containsOnly(new Sucre(5), lait);
		assertThat(ingredients).containsOnly(new Sucre(45));

		melangeur.melange(7, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Sucre(40), lait);
		assertThat(ingredients).containsOnly(new Sucre(10));

		melangeur.melange(50, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Sucre(50), lait);
		assertThat(ingredients).isEmpty();

		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.LIQUIDE);
	}

	@Test
	public void testMelangePoudreNonSolubleEtLiquide() {
		// prepare
		Farine farine = new Farine(50);
		Lait lait = new Lait(50);

		// tests
		Set<Ingredient> ingredients = melangeur.melange(1, melange, farine, lait);
		assertThat(melange.getIngredients()).containsOnly(new Farine(2), lait);
		assertThat(ingredients).containsOnly(new Farine(48));

		melangeur.melange(9, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Farine(20), lait);
		assertThat(ingredients).containsOnly(new Farine(30));

		melangeur.melange(20, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Farine(50), lait);
		assertThat(ingredients).isEmpty();

		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.PATE);
	}

	@Test
	public void testMelangeProgressifPoudreNonSolubleEtLiquide() {
		// prepare
		Lait lait = new Lait(50);
		Set<Ingredient> ingredients = Sets.<Ingredient>newHashSet(lait);

		// tests
		ingredients.add(new Farine(20));
		melangeur.melange(5, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Farine(10), lait);
		assertThat(ingredients).containsOnly(new Farine(10));
		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.LIQUIDE);

		ingredients.add(new Farine(20));
		melangeur.melange(5, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Farine(20), lait);
		assertThat(ingredients).containsOnly(new Farine(20));
		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.LIQUIDE);

		ingredients.add(new Farine(10));
		melangeur.melange(20, melange, ingredients);
		assertThat(melange.getIngredients()).containsOnly(new Farine(50), lait);
		assertThat(ingredients).isEmpty();
		assertThat(melange.getNatureProduit()).isEqualTo(NatureProduit.PATE);
	}

}
