<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}

Radiology Report
==================

Patient:
 <#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>


Service: General Report - ${RAND_W5}Chest${RAND_W6}
Status: Final
Requested By: Thomas, Josephine
Examined: ${time?number_to_date?string["yyyy-MM-dd"]} 23:29
Reported: ${time?number_to_date?string["yyyy-MM-dd"]} 23:45

Chest:
 Clinical: ${RAND_L10}Please compare with prior imaging. Known PE left base.
 Persisted pain. Examination consistent with developing effusions.

Report:
 Comparisons maide with study of  ${time?number_to_date?string["yyyy-MM-dd"]} 011:29.
 ${RAND_L1}There is left sided pleural${RAND_W5}effusion that has been developed in the interval period.
 There is adjacent compressive atelectasis. There is an opacity in the left mid zone that is noted previously.
 Cardiomediastinal borders are with normal range.${RAND_L2}The right lung is clear. There is a small right sided pleural effusion.
There is no ${RAND_W1}pneumothorax${RAND_W3} or free subphragmatic gas.${RAND_L3}

 Reported by Dr. F James
 Reviewed with Dr. S Knox

------------------------------ End Report --------------------------------------------

 Service: General Report - Chest
 Status: Final
 Requested by: Huges Geoff
 Examined: ${time?number_to_date?string["yyyy-MM-dd"]} 11:29
 Reported: ${time?number_to_date?string["yyyy-MM-dd"]} 11:50

 Chest:

 Clinical Details:
  Left sided chest pain on inspiration. Cough productive, colored sputum.

  Report:
   No old films available for comparison.
   Cardiac silhouette is within normal limits. There is an ${RAND_L4}illdefined density in the left midzone which could representing developing infection or
   consolidation. There is blunting on the left costophrenic angle which could represent a small effusion. No pneumothorax${RAND_W10} and no free gas
   under the diaphram. No rib fractures are identified.${RAND_L5}

   IMPRESSION
    ${RAND_L6}Illdefined left midzone , opacity with blunting of the left costophrenic angle could represent developing infection. Correlate with any fever and leukocytosis. Progress imaging is recommended to ensure resolution.

    Reported by: Dr. J Bewes
    Reviewed by Dr. Skyes


------------------------------ End Report --------------------------------------------
Service: Nuclear Med Reports - Lung Scan - Ventilation/Perfus
Status: Final
Requested by: Dr. Huges Geoff
 Examined: ${time?number_to_date?string["yyyy-MM-dd"]} 03:00
 Reported: ${time?number_to_date?string["yyyy-MM-dd"]} 04:00

Radiopharmaceutical: 99m-Tc MAA/99m-Tc Technegas
Reported by Dr. N LIAJ
Clinical History:
 L. chest pain, tachycardia D-dimer 1.8
Technique:
 Ventilation and ${RAND_W1}Perfusion${RAND_W2} SPECT images obtained followed by planar reconstructions.

 Report:
  ${RAND_L7}A moderate sized matching defect is noted in the left upper lobe apical segment with a non segmental matching defect noted
  following the oblique fissure of the left lung.${RAND_L8} There is however a small mismatched subsegmental perfusion defect noted involving the medical
  basal segment of the left lower lobe. This is wedge shaped on the sagittal images and consistent with a small ${RAND_W8}pulmonary ${RAND_W5}embolus.

  Conclusion:
   Findings consistent with a small acute ${RAND_W5}pulmonary${RAND_W7} embolus${RAND_W9} left lower lobe medial basal segment left lower lobe. ${RAND_L9}The matching apical defect appears worse on ventilation images and may relate to an underlying parenchymal process.

------------------------------ End Report --------------------------------------------


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