echo "Recherche du mot 'du' dans les noms des livres." 

echo "Un résultat doit apparaître car l'analyzer par défaut est utilisé."

curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query" : {
	"match" : {
        	"name" : "du"
    	}
},
"fields" : [ "name", "auteurs.firstname", "auteurs.lastname" ],
"highlight" : {
		"fields" : { 
			"name" : {}
		} 
}
}'
