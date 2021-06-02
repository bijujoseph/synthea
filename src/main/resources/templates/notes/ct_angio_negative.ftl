<#setting number_format="computer">
${time?number_to_date?string["yyyy-MM-dd"]}

Medical Specialty: Radiology

Exam Name: CT Angiography${RAND_W10}

<#if name??>${name?keep_before_last(" ")}<#else><#if gender=='F'>Jane<#else>John</#if> Doe</#if>
      is a <#if ehr_ageInYears gt 0>${ehr_ageInYears} year-old<#elseif ehr_ageInMonths gt 0>${ehr_ageInMonths} month-old<#else>newborn</#if> ${ethnicity_display_lookup[race]} ${race} <#if gender=='F'>female<#else>male</#if>.

Description: ${RAND_W1}Chest${RAND_W2} pain, shortness of breath and cough, evaluate for pulmonary${RAND_W3} arterial embolism. CT angiography chest with contrast. Axial CT images of the chest were obtained for pulmonary embolism protocol utilizing 100 mL of Isovue-300.
(Medical Transcription Sample Report)

CT ANGIOGRAPHY${RAND_W8} CHEST WITH CONTRAST

REASON FOR EXAM: Chest pain, shortness of breath and cough, evaluate for pulmonary arterial ${RAND_W7}embolism${RAND_W1}.

TECHNIQUE: ${RAND_W5}Axial CT images of the chest${RAND_W7} were obtained for ${RAND_W2}pulmonary${RAND_W3} ${RAND_W8}embolism protocol${RAND_W2} utilizing 100 mL of Isovue-300.

FINDINGS: There is no evidence for pulmonary arterial ${RAND_W9}embolism${RAND_W2}.

The lungs are clear of any abnormal airspace consolidation, pleural${RAND_W4} effusion, or pneumothorax. No abnormal mediastinal or hilar lymphadenopathy is seen.

Limited images of the upper abdomen are unremarkable. No destructive osseous lesion is detected.

IMPRESSION: Negative for ${RAND_W1}pulmonary ${RAND_W2}arterial ${RAND_W3}embolism${RAND_W4}.


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