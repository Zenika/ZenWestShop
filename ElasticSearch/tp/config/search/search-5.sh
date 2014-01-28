curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query": {
"constant_score":{
  "filter":{
    "query":{
      "multi_match":{
        "query":"Gary", 
	"fields":["auteurs.firstname^3","auteurs.lastname"]
      }
    }
  },
  "boost":1 
}}
}'
