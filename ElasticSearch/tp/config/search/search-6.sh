curl -XGET localhost:9200/zenika/book/_search?pretty=1 -d '{
"query": {
"constant_score":{
  "filter":{
    "query":{
      "multi_match":{
        "query":"Gary", 
	"fields":["auteurs.firstname","auteurs.lastname^3"]
      }
    }
  },
  "boost":1 
}}
}'
