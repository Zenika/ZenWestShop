curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query" : {
"match" : {
        "auteurs.lastname" : "Bazoud"
    }
},
fields:[ "name", "isbn" ]
}'
