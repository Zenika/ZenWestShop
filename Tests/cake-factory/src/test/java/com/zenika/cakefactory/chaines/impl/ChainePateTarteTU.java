package com.zenika.cakefactory.chaines.impl;

import com.google.common.collect.Lists;
import com.zenika.cakefactory.composants.Distributeur;
import com.zenika.cakefactory.composants.Lamineuse;
import com.zenika.cakefactory.composants.Melangeur;
import com.zenika.cakefactory.produits.ingredients.*;
import com.zenika.cakefactory.produits.sousproduits.Melange;
import com.zenika.cakefactory.util.VarargCaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.fest.assertions.api.Assertions.*;

/**
 * @author gtinon
 */
public class ChainePateTarteTU {

	private ChainePateTarte chaine;

	@Before
	public void setUp() {
		chaine = new ChainePateTarte();
	}

	@Test
	public void testActiver() {
		// prepare
		Distributeur<BeurreFondu> distributeurBeurre = mock(Distributeur.class);
		Distributeur<Sucre> distributeurSucre = mock(Distributeur.class);
		Distributeur<Oeuf> distributeurOeufs = mock(Distributeur.class);
		Distributeur<Farine> distributeurFarine = mock(Distributeur.class);
		Lamineuse lamineuse = mock(Lamineuse.class);
		Melangeur melangeur = mock(Melangeur.class);

		BeurreFondu beurre = new BeurreFondu(50);
		Oeuf oeuf = new Oeuf(50);
		Sucre sucre = new Sucre(50);
		when(distributeurBeurre.verserDose(anyInt())).thenReturn(beurre);
		when(distributeurOeufs.verserDose(anyInt())).thenReturn(oeuf);
		when(distributeurSucre.verserDose(anyInt())).thenReturn(sucre);

		chaine.setDistributeurBeurre(distributeurBeurre);
		chaine.setDistributeurFarine(distributeurFarine);
		chaine.setDistributeurOeufs(distributeurOeufs);
		chaine.setDistributeurSucre(distributeurSucre);
		chaine.setLamineuse(lamineuse);
		chaine.setMelangeur(melangeur);

		// test
		chaine.activer();

		// checks
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

		verify(distributeurBeurre, times(1)).verserDose(anyInt());
		verify(distributeurSucre, times(1)).verserDose(anyInt());
		verify(distributeurOeufs, times(1)).verserDose(anyInt());

		verify(distributeurFarine, times(4)).verserDose(captor.capture());
		assertThat(captor.getAllValues()).isEqualTo(Lists.newArrayList(50, 50, 50, 50));

		verify(melangeur, times(1)).melange(anyInt(), any(Melange.class), eq(beurre), eq(oeuf), eq(sucre));
		verify(melangeur, times(5)).melange(anyInt(), any(Melange.class), (Ingredient) anyVararg());
		verify(lamineuse, times(1)).mouler(any(Melange.class));
	}

}
