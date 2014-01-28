echo "Recherche du mot 'item' dans le texte des livres"

curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query" : {
	"match" : {
        	"texte" : "item"
    	}
},
"fields" : [ "name", "auteurs.firstname", "auteurs.lastname" ],
"highlight" : {
		"fields" : { 
			"texte" : {}
		} 
}
}'
