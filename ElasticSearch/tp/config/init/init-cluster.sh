#!/bin/bash

echo
echo "Destruction de l'index 'zenika'"
curl -XDELETE http://127.0.0.1:9200/zenika
echo
echo
echo "Ajout des settings"
curl -XPUT http://127.0.0.1:9200/zenika -d @settings.json
echo
echo
echo "Ajout des mappings des publications"
curl -XPUT http://127.0.0.1:9200/zenika/book/_mapping?pretty=1 -d @book.json
echo
echo
echo "Résumé des settings en place"
curl -XGET http://127.0.0.1:9200/zenika/_settings?pretty=1
