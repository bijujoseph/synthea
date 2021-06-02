#!/usr/bin/env sh
## Generates data for all states
arrayx=('West Virginia' 'New Hampshire' 'New Jersey' 'District of Columbia'
'New Mexico' 'New York' 'North Carolina' 'North Dakota'
'Ohio' 'Oklahoma' 'Oregon' 'Pennsylvania' 'Rhode Island' 'South Carolina'
'South Dakota' 'Alabama' 'Alaska' 'Arizona'
'Arkansas' 'California' 'Colorado' 'Connecticut' 'Delaware'
 'Florida' 'Georgia' 'Hawaii'
'Idaho' 'Illinois' 'Indiana' 'Iowa' 'Kansas' 'Kentucky' 'Louisiana'
'Maine' 'Maryland' 'Massachusetts' 'Michigan' 'Minnesota'
'Mississippi' 'Missouri' 'Montana' 'Nebraska' 'Nevada' 'Tennessee' 'Texas' 'Utah' 'Vermont'
'Virginia' 'Washington'  'Wisconsin' 'Wyoming')

array=('Idaho')

for i in "${array[@]}"
do
  echo $i
 	./run_synthea -p 1 -a 0-112 --exporter.baseDirectory /Users/biju.joseph/Downloads/synthea-output/ --exporter.csv.append_mode true "$i"
done