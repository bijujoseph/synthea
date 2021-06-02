<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}
Exam:
  US DOPPLER VENOUS DVT LOWER EXTREMITY LEFT
 HISTORY:
 ${RAND_L1}
 <#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>
      is a <#if ehr_ageInYears gt 0>${ehr_ageInYears} year-old<#elseif ehr_ageInMonths gt 0>${ehr_ageInMonths} month-old<#else>newborn</#if> ${ethnicity_display_lookup[race]} ${race} <#if gender=='F'>female<#else>male</#if>.
 TECHNIQUE:
  ${RAND_L1} Survey ultrasound imaging of the ${RAND_W1}deep${RAND_W2} venous system of the left lower extremity was preformed including color and spectral Doppler evaluation with representative images obrained. ${RAND_L1}The contralateral common femoral ${RAND_W1}vein was also imaged for comparison purposes. Segmental ${RAND_W1}venous compression and calf vein augmentation were performed. ${RAND_L1}
 COMPARISON:
 None
 FINDINGS:
 Statements: None.
 Right Lower Extremity:
 Common femoral vein:  ${RAND_L2}Patent without thrombus. Normal phasicity is indirect evidence of central patency. ${RAND_L1}
 Left Lower Extremity:
 Common femoral vein: Patent without ${RAND_W9}thrombus${RAND_W8}.  ${RAND_L3}Normal phasicity is indirect evidence of central patency. ${RAND_L10}
 Cephalad greater saphenous vein: Patent without ${RAND_W7}thrombus${RAND_W1}.
  ${RAND_L1}Cephalad profunda femoral vein: Patent without thrombus. ${RAND_L4}
 Femoral vein: Patent without thrombus.
 Popliteal vein: Patent without thrombus. Normal response to augmentation. ${RAND_L8}

 Other: None.

 IMPRESSION:
 1. ${RAND_W2}No evidence${RAND_W3} of deep venous thrombosis(DVT) identified.${RAND_L1}

 FOLLOW-UP RECOMMENDATIONS: Per Clinical team. ${RAND_L9}


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