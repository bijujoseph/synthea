<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}

PATIENT:

<#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>
      is a <#if ehr_ageInYears gt 0>${ehr_ageInYears} year-old<#elseif ehr_ageInMonths gt 0>${ehr_ageInMonths} month-old<#else>newborn</#if> ${ethnicity_display_lookup[race]} ${race} <#if gender=='F'>female<#else>male</#if>.
${RAND_L1}
${RAND_W1}Venousduplex${RAND_W2} examinationusing B-mode, ${RAND_W3}color flow and spectral Doppler ${RAND_W4}was performed. (CPT:93971) ${RAND_L2}
INDICATION:
Right lower extremity edema
FINDINGS:
The common femoral${RAND_W7} vein${RAND_W8}, femoral ${RAND_W1}vein${RAND_W6}, popliteal ${RAND_W7} vein, peroneal veins and ${RAND_W5}posterior tibial veins were all assessed for patency.${RAND_L3} B-mode ultrasound demonstrates a non-compressible and dilated ${RAND_W4}popliteal ${RAND_W3}vein with hypoechoic${RAND_W2} intraluminal debris extending just above the knee, partially obstructing the popliteal${RAND_W1} vein.${RAND_L5} All other vessels are compressible and demonstrate phasic, competent ${RAND_W1}flow with normal augmentation.${RAND_L4}
IMPRESSION:
${RAND_L9}
1)Evidence of an acute ${RAND_W4}DVT${RAND_W4} of the right popliteal ${RAND_W10}vein${RAND_W9}.
2)Incidental finding, an enlarged ${RAND_W1}lymph${RAND_W1} node noted in the groin measuring 2.5 cm. ${RAND_L2}Preliminary result was phoned to Doctor's office prior to release of patient.${RAND_L6}


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