
curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query" : {
	"match" : {
        	"texte" : "pantalon"
    	}
},
"fields" : [ "name", "auteurs.firstname", "auteurs.lastname" ],
"highlight" : {
		"fields" : { 
			"texte" : {}
		} 
}
}'
