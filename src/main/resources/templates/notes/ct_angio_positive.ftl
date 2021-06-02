<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}

Medical Specialty: Radiology

Exam Name: Chest Pulmonary Angio

<#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>
     is a <#if ehr_ageInYears gt 0>${ehr_ageInYears} year-old<#elseif ehr_ageInMonths gt 0>${ehr_ageInMonths} month-old<#else>newborn</#if> ${ethnicity_display_lookup[race]} ${race} <#if gender=='F'>female<#else>male</#if>.

Description: ${RAND_W10}Postcontrast CT chest${RAND_W9} pulmonary${RAND_W2} embolism ${RAND_W5}protocol, 100 mL of Isovue-300 contrast is utilized.
(Medical Transcription Sample Report)

EXAM: CTA chest ${RAND_W3}pulmonary${RAND_W2} angio.

REASON FOR EXAM: Evaluate${RAND_W1} for pulmonary${RAND_W8} embolism.${RAND_W3}

TECHNIQUE: ${RAND_W6}Postcontrast${RAND_W5} CT ${RAND_W4}chest pulmonary embolism protocol, 100 mL of Isovue-300 contrast is utilized.

FINDINGS: ${RAND_L3}There are no ${RAND_W2}filling${RAND_W3} defects in the main or main right or left ${RAND_W7}pulmonary${RAND_W8} arteries${RAND_W9}. No central ${RAND_W1}embolism${RAND_W2}. The proximal subsegmental${RAND_W5} pulmonary arteries${RAND_W4} are free of embolus, but the distal subsegmental and segmental arteries especially on the right are limited by extensive ${RAND_W5}pulmonary ${RAND_W3}parenchymal${RAND_W7}, findings would be discussed in more detail below. ${RAND_L2}There is no evidence of a central embolism.${RAND_L1}
${RAND_L10}
As seen on the prior examination, there is a very ${RAND_W6}large heterogeneous${RAND_W6} right chest wall mass, which measures at least 10 x 12 cm based on axial image #35. Just superior to the mass is a second heterogeneous focus of neoplasm measuring about 5 x 3.3 cm. Given the short interval time course from the prior exam, dated 01/23/09, this finding has not significantly changed. However, there is considerable change in the appearance of the ${RAND_W2}lung${RAND_W6} fields. There are now bilateral ${RAND_W8}pleural effusions${RAND_W7}, small on the right and moderate on the left with associated atelectasis. There are also extensive right lung consolidations, all new or${RAND_W10} increased significantly from the prior examination. ${RAND_L7}Again identified is a somewhat spiculated region of increased density at the right ${RAND_W7}lung apex${RAND_W8}, which may indicate fibrosis or scarring, but the possibility of primary or metastatic disease cannot be excluded. There is no pneumothorax in the interval.${RAND_L8}

${RAND_L1}On the mediastinal windows, there is presumed subcarinal ${RAND_W9}adenopathy, with one lymph node measuring roughly 12 mm suggestive of metastatic disease here. There is aortic${RAND_W7} root and arch and descending thoracic${RAND_W9} aortic calcification. ${RAND_L3}There are scattered regions of soft plaque intermixed with this. The heart is not enlarged. The left axilla is intact in regards to ${RAND_W3}adenopathy${RAND_W2}. The inferior thyroid appears unremarkable.${RAND_L4}

Limited assessment of the upper abdomen discloses a region of lower density within the right hepatic ${RAND_W2} lobe, this finding is indeterminate, and if there is need for additional imaging in regards to hepatic metastatic disease, follow up ultrasound${RAND_W4}. Spleen, adrenal glands, and upper kidneys appear unremarkable. Visualized portions of the pancreas are unremarkable.${RAND_L5}

${RAND_L8}There is extensive rib destruction in the region of the ${RAND_W8}chest${RAND_W1} wall mass. There are changes suggesting prior trauma to the right clavicle.${RAND_L7}

IMPRESSION:
1. Again demonstrated is a large right chest wall mass.${RAND_L6}
2. No central embolus, distal subsegmental and ${RAND_W1}segmental pulmonary ${RAND_L10}artery${RAND_L3} branches are in part obscured by the pulmonary parenchymal findings, are not well assessed.${RAND_L1}
3. New bilateral pleural effusions and extensive increasing consolidations and infiltrates in the right lung. ${RAND_L9}
4. See above regarding other findings. ${RAND_L5}


OTHER REMARKS:
TEMPLATE_NAME: ${templateName}
SCRAMBLE_MODE: ${scrambleMode}
DISEASE_STATUS: ${vteStatus}
<#--
DEBUG DATA:
randomLinesSet: ${randomLinesSet}
randomWordsSet: ${randomWordsSet}
= = =
RAND_W1: ${RAND_W1}
RAND_W2: ${RAND_W2}
RAND_W3: ${RAND_W3}
RAND_W4: ${RAND_W4}
RAND_W5: ${RAND_W5}
RAND_W6: ${RAND_W6}
RAND_W7: ${RAND_W7}
RAND_W8: ${RAND_W8}
RAND_W9: ${RAND_W9}
RAND_W10: ${RAND_W10}
= = =
RAND_L1: ${RAND_L1}
RAND_L2: ${RAND_L2}
RAND_L3: ${RAND_L3}
RAND_L4: ${RAND_L4}
RAND_L5: ${RAND_L5}
RAND_L6: ${RAND_L6}
RAND_L7: ${RAND_L7}
RAND_L8: ${RAND_L8}
RAND_L9: ${RAND_L9}
RAND_L10: ${RAND_L10}
-->