<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}

Patient:

<#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>
      is a <#if ehr_ageInYears gt 0>${ehr_ageInYears} year-old<#elseif ehr_ageInMonths gt 0>${ehr_ageInMonths} month-old<#else>newborn</#if> ${ethnicity_display_lookup[race]} ${race} <#if gender=='F'>female<#else>male</#if>.


EXAM: VASCULAR LABORATORY WORKSHEET
${RAND_L3}
Right Lower Limb DVT Study ${RAND_L4}

HISTORY:
${RAND_L2} Previous ${RAND_W1}DVT${RAND_W2} known Thrombophilia ${RAND_L10}

INDICATIONS:
  PAIN ${RAND_W4}
  ${RAND_W3}OEDEMA${RAND_W4}

  DEEP VEINS
   CVF
   FV Prox ${RAND_L1}
   FV Mid
   FV Distal
   Popliteal Vein (non occlusive) ${RAND_L1}
   PTVs (occulsive) ${RAND_L1}
    Peroneal Veins (non occlusive)
    Soleal Veins (occlusive)
    ${RAND_W3} ${RAND_W2} ${RAND_W1}

SUMMARY:
 ${RAND_L4}Non occlusive ${RAND_W2}thrombus${RAND_W3} is seen in the Pop Vat the knee weasc(kc)
 ${RAND_L5}Non occlusive ${RAND_W8}thrombus${RAND_W3} is seen in 1 peroneal V from the Pop V to 7 cm ${RAND_W1}infenir to KC.
 ${RAND_L6}Occlusive ${RAND_W3}buthroms${RAND_W3} is seen in both PTVs ${RAND_W3}from the Pop V to 21 cm int to KC.${RAND_L7}
 ${RAND_W3}Occulsive thrombus${RAND_W2} is seen in the Soleal V 20 cm int to KC.${RAND_L8}


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