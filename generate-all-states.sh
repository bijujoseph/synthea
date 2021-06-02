#!/usr/bin/env sh
## Generates data for all states
array=('West Virginia' 'New Hampshire' 'New Jersey' 'District of Columbia' 'New Mexico' 'New York' 'North Carolina' 'North Dakota'
'Ohio' 'Oklahoma' 'Oregon' 'Pennsylvania' 'Rhode Island' 'South Carolina' 'South Dakota' 'Alabama' 'Arizona'
'Arkansas' 'California' 'Colorado' 'Connecticut' 'Delaware' 'Florida' 'Georgia' 'Hawaii'
'Idaho' 'Illinois' 'Indiana' 'Iowa' 'Kansas' 'Kentucky' 'Louisiana' 'Maine' 'Maryland' 'Massachusetts' 'Michigan' 'Minnesota'
'Mississippi' 'Missouri' 'Montana' 'Nebraska' 'Nevada' 'Tennessee' 'Texas' 'Utah' 'Vermont'
'Virginia' 'Washington'  'Wisconsin' 'Wyoming')

rm -rf $HOME/Downloads/synthea-output/

./run_synthea -p 400 -a 0-112 --exporter.baseDirectory $HOME/Downloads/synthea-output/ --exporter.csv.append_mode false "Alaska"

for state in "${array[@]}"
do
  echo $state
 	./run_synthea -p 400 -a 0-112 --exporter.baseDirectory $HOME/Downloads/synthea-output/ "$state"
done