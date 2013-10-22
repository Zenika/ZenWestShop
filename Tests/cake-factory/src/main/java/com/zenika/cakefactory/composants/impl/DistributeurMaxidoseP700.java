package com.zenika.cakefactory.composants.impl;

import com.zenika.cakefactory.composants.Distributeur;
import com.zenika.cakefactory.produits.ingredients.Ingredient;
import com.zenika.cakefactory.util.YapudstockException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author gtinon
 */
public class DistributeurMaxidoseP700<OUT extends Ingredient> implements Distributeur<OUT> {

	private final Class<? extends Ingredient> typeIngredient;

	private JdbcTemplate template;

	public DistributeurMaxidoseP700(Class<OUT> typeIngredient) {
		this.typeIngredient = typeIngredient;
	}

	@Override
	public OUT verserDose(int masse) {
		int stock = template.queryForObject("select quantity from Stock where ingredient=?", Integer.class,
				typeIngredient.getSimpleName());

		if (stock < masse) {
			throw new YapudstockException();
		}

		int affectedRows = template.update("update Stock set quantity = ? where quantity = ? and ingredient=?",
				stock - masse, stock, typeIngredient.getSimpleName());
		if (affectedRows != 1) {
			throw new OptimisticLockingFailureException("Essaye encore !");
		}

		return (OUT) Ingredient.newInstance(typeIngredient, masse);
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
