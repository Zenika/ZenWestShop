package com.zenika.cakefactory.chaines.impl;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import com.zenika.cakefactory.composants.Distributeur;
import com.zenika.cakefactory.produits.ingredients.Farine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.Assert.assertEquals;

/**
 * @author gtinon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class DistributeurMaxidoseP700IT {

	public static final Operation DELETE_ALL = deleteAllFrom("Stock");

	public static final Operation INSERT = insertInto("Stock").columns("INGREDIENT", "QUANTITY").values("Farine", 50)
			.build();

	private static DbSetupTracker dbSetupTracker = new DbSetupTracker();


	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate template;

	@Autowired
	@Qualifier("distributeurFarine")
	private Distributeur<Farine> distributeur;

	@Before
	public void setUp() {
		Operation setup = sequenceOf(DELETE_ALL, INSERT);
		DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), setup);
		dbSetupTracker.launchIfNecessary(dbSetup);
	}

	@Test
	@Transactional
	public void testVerserDose() {
		// test
		distributeur.verserDose(20);

		// checks
		int stock = template.queryForObject("select quantity from Stock where ingredient=?", Integer.class, "Farine");
		assertEquals(30, stock);
	}

}
