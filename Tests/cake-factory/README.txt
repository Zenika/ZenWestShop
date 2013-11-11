Bienvenue dans la CFAAS (Cake factory as a service :-)

Le but final consiste à mettre en place et combiner 3 chaines de production afin de produire une tarte au chocolat.
Un gateau est modélisé de manière simpliste comme une liste de couches, chaque couche étant un mélange d'ingrédients
de base. Notre tarte devra comporter 2 couches, une pour la pate et une pour la garniture.

1) Implémenter le TU MelangeurTornadoPlusIIITU en utilisant les assertions Fest Assert.
	Exemple d'éléments à tester:
		- mélanger 2 liquides donne instantanément un liquide
		- mélanger 2 poudres donne instantanément une poudre
		- mélanger de la farine et du lait donne un mélange pâteux à partir d'un certaine dose de farine
		- mélanger du sucre et du lait absorbe petit à petit le sucre dans le mélange

2) Implémenter le test d'intégration DistributeurMaxidoseP700IT en utilisant Spring et DBSetup.
	Le distributeur prend ses ingrédients dans une base H2 embarquée et initialisée par Spring (cf. init.sql).
	Vérifiez que le stocke d'ingrédients (dans la table 'Stock') diminue bien après chaque prélèvement.

3) Implémentez les classes ChainePateTarte, ChaineGarnitureChoco puis ChaineAssemblageTarte ainsi que les TU associés.
ChainePateTarte: un mélangeur produit de la pate à partir d'ingérdients (farine, beurre, sucre, oeufs) fournis par des
	distributeurs. Le mélange doit être de consistence pâteuse. La pâte est ensuite faconnée en fond de tarte avec
	une lamineuse.
ChaineGarnitureChoco: produit la garniture en mélangeant de la crème fraiche, du sucre et du chocolat
ChaineAssemblageTarte: injecte la garniture dans le fond de tarte (grâce à un injecteur), cuit le tout (avec un four !!)
 	et stocke le résultat dans un réfrigérateur.

4) Ouvrez votre navigateur préféré sur la page de la factory et vérifier que tout fonctionne. Automatisez cette
vérification en implémentant le test d'intégration CakeFactoryControlIT grâce à Selenium.
