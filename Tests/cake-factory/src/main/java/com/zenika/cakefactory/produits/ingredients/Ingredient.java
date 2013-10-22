package com.zenika.cakefactory.produits.ingredients;

import com.zenika.cakefactory.produits.NatureProduit;
import com.zenika.cakefactory.produits.Produit;
import com.zenika.cakefactory.util.PhysiqueNonRespecteeException;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author gtinon
 */
public abstract class Ingredient extends Produit {

	protected int masse;

	protected Ingredient(NatureProduit natureProduit, int masse) {
		super(natureProduit);
		this.masse = masse;
	}

	public Ingredient diviser(int masse) {
		if (masse > this.masse) {
			throw new PhysiqueNonRespecteeException();

		} else if (masse < this.masse) {
			Ingredient autre = newInstance(getClass(), masse);
			this.masse -= masse;
			return autre;

		} else {
			return this;
		}
	}

	public void ajouter(int masse) {
		this.masse += masse;
	}

	@Override
	public int getMasse() {
		return masse;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o.getClass() != getClass()) {
			return false;
		}

		Ingredient that = (Ingredient) o;
		if (masse != that.masse) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return getClass().getName().hashCode();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" + masse + '}';
	}

	public static <T extends Ingredient> T newInstance(Class<T> type, int masse) {
		try {
			Constructor<T> constructor = type.getConstructor(int.class);
			T ingredient = constructor.newInstance(masse);
			return ingredient;

		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}

}
