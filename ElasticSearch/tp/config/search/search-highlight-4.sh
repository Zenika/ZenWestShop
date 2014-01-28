echo "Recherche du mot 'ce' dans les textes des livres." 

echo "Aucun résultat ne doit apparaître car l'analyzer utilise les filtres c_stop_fr et le c_lenght_filter."

curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query" : {
	"match" : {
        	"texte" : "ce"
    	}
},
"fields" : [ "name", "auteurs.firstname", "auteurs.lastname" ],
"highlight" : {
		"fields" : { 
			"texte" : {}
		} 
}
}'
