package org.mitre.synthea.export;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mitre.synthea.modules.LifecycleModule;
import org.mitre.synthea.world.agents.Payer;
import org.mitre.synthea.world.agents.Person;
import org.mitre.synthea.world.concepts.HealthRecord.Encounter;
import org.mitre.synthea.world.concepts.HealthRecord.Entry;
import org.mitre.synthea.world.concepts.HealthRecord.Medication;
import org.mitre.synthea.world.concepts.HealthRecord.Procedure;
import org.mitre.synthea.world.concepts.RaceAndEthnicity;

import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Export Clinical Notes using Apache FreeMarker templates.
 */
public class ClinicalNoteExporter {

  private static final Configuration TEMPLATES = templateConfiguration();
//  private static String[] CUSTOM_TEMPLATE_NAMES = new String[] { "pe_positive"};
  private static String[] CUSTOM_TEMPLATE_NAMES = new String[] {"ct_angio_negative","ct_angio_positive",
          "hand_dvt_positive", "lab_dvt_positive", "pe_positive", "us_doppler_negative"};

  private static Configuration templateConfiguration() {


    Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
    configuration.setDefaultEncoding("UTF-8");
    configuration.setLogTemplateExceptions(false);
    try {
      configuration.setSetting("object_wrapper",
          "DefaultObjectWrapper(2.3.26, forceLegacyNonListCollections=false, "
              + "iterableSupport=true, exposeFields=true)");
    } catch (TemplateException e) {
      e.printStackTrace();
    }
    configuration.setAPIBuiltinEnabled(true);
    configuration.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(),
        "templates/notes");
    return configuration;
  }

  /**
   * Export all the encounter notes for a Person in a single
   * document, with the most recent encounter on top.
   *
   * @param person Person to write notes about.
   * @return A set of consolidated clinical notes as plain text.
   */
  public static String export(Person person) {
    String consolidatedNotes = "";
    for (int i = person.record.encounters.size() - 1; i >= 0; i--) {
      Encounter encounter = person.record.encounters.get(i);

      String signature = String.format(" END (index = %s :: vteStatus = %s template = %s, scrambleMode = %s, name = %s " ,
              i, encounter.vteStatus, encounter.templateName, encounter.scrambleMode, encounter.name);

      consolidatedNotes += export(person, encounter) +
              "\n--------------------------------------------------" +
              signature +
              ")--------------------------------------------------\n";


//      if (!encounter.templateName.equalsIgnoreCase( "note")) {
//        System.out.println(String.format("MODE - Person: %s %s, Encounter: %s",
//                person.attributes.get(Person.FIRST_NAME),
//                person.attributes.get(Person.LAST_NAME),
//                signature));
//      }


    }

    return consolidatedNotes;
  }

  /**
   * Will reinitialize the freemarker template variables for this encounter.
   * Only one encounter associated with a person will be customized, there after
   * the subsequent encounters will use the default "notes.ftl" template.
   *
   * The data scrambling modes  :
   *  0 - none,
   *  1 - only lines,
   *  2 - only wrapping,
   *  3 - both lines and wrapping,
   *  4 - juggle
   *  5 - juggle and lines
   * @param person
   * @param encounter
   * @return
   */
  private static void initializeTemplateVariables(Person person, Encounter encounter) {

    if (encounter.markedForCustomizedNotes && !person.isNotesCustomized()) {
      person.setNotesCustomized(true);

      String templateName = CUSTOM_TEMPLATE_NAMES[person.randInt(CUSTOM_TEMPLATE_NAMES.length)];
      encounter.templateName = templateName;

      String vteStatus = templateName.contains("positive") ? "Y": "N";
      encounter.vteStatus = vteStatus;

      if (person.isMarkedForScrambledClinicalNotes()) {

        int scrambleMode = person.randInt(5) + 1;
        encounter.scrambleMode = scrambleMode;


        if(scrambleMode == 1 || scrambleMode == 3 || scrambleMode == 5) {
          List<String> lines =  WordJuggler.randomLines();
          encounter.RAND_L1 = lines.get(1);
          encounter.RAND_L2 = lines.get(2);
          encounter.RAND_L3 = lines.get(3);
          encounter.RAND_L4 = lines.get(4);
          encounter.RAND_L5 = lines.get(5);
          encounter.RAND_L6 = lines.get(6);
          encounter.RAND_L7 = lines.get(7);
          encounter.RAND_L8 = lines.get(8);
          encounter.RAND_L9 = lines.get(9);
          encounter.RAND_L10 = lines.get(10);
          encounter.randomLinesSet = "Y";
        }

        if(scrambleMode == 2 || scrambleMode == 3) {
          List<String> words =  WordJuggler.randomWords();

          encounter.RAND_W1 = words.get(1);
          encounter.RAND_W2 = words.get(2);
          encounter.RAND_W3 = words.get(3);
          encounter.RAND_W4 = words.get(4);
          encounter.RAND_W5 = words.get(5);
          encounter.RAND_W6 = words.get(6);
          encounter.RAND_W7 = words.get(7);
          encounter.RAND_W8 = words.get(8);
          encounter.RAND_W9 = words.get(9);
          encounter.RAND_W10 = words.get(10);
          encounter.randomWordsSet = "Y";

        }

      }

    }

  }


  /**
   * Export a clinical note for a Person at a given Encounter.
   *
   * @param person Person to write a note about.
   * @param encounter Encounter to write a note about.
   * @return Clinical note as a plain text string.
   */
  public static synchronized String export(Person person, Encounter encounter) {
    // The export templates fill in the record by accessing the attributes
    // of the Person, so we add a few attributes just for the purposes of export.
    Set<String> activeAllergies = new HashSet<String>();
    Set<String> activeConditions = new HashSet<String>();
    Set<String> activeMedications = new HashSet<String>();
    Set<String> activeProcedures = new HashSet<String>();

    // need to loop through record until THIS encounter
    // to get previous data, since "present" is what is present
    // at time of export and NOT what is present at this
    // encounter.
    long encounterTime = encounter.start;
    for (Encounter pastEncounter : person.record.encounters) {
      if (pastEncounter == encounter || pastEncounter.stop >= encounterTime) {
        break;
      }
      for (Entry allergy : pastEncounter.allergies) {
        if (allergy.stop != 0L || allergy.stop > encounterTime) {
          activeAllergies.add(allergy.codes.get(0).display);
        }
      }
      for (Entry condition : pastEncounter.conditions) {
        if (condition.stop != 0L || condition.stop > encounterTime) {
          activeConditions.add(condition.codes.get(0).display);
        }
      }
      for (Medication medication : pastEncounter.medications) {
        if (medication.stop != 0L || medication.stop > encounterTime) {
          activeMedications.add(medication.codes.get(0).display);
        }
      }
      for (Procedure procedure : pastEncounter.procedures) {
        if (procedure.stop != 0L || procedure.stop > encounterTime) {
          activeProcedures.add(procedure.codes.get(0).display);
        }
      }
    }

    Payer payer = person.getPayerAtTime(encounter.start);
    if (payer == null) {
      person.attributes.put("ehr_insurance", "unknown insurance coverage");
    } else {
      person.attributes.put("ehr_insurance", payer.getName());
    }
    person.attributes.put("ehr_ageInYears", person.ageInYears(encounter.start));
    person.attributes.put("ehr_ageInMonths", person.ageInMonths(encounter.start));
    person.attributes.put("ehr_symptoms", person.getSymptoms());
    person.attributes.put("ehr_activeAllergies", activeAllergies);
    person.attributes.put("ehr_activeConditions", activeConditions);
    if (activeConditions.contains("Normal pregnancy")) {
      person.attributes.put("pregnant", true);
    } else {
      person.attributes.remove("pregnant");
    }
    person.attributes.put("ehr_activeMedications", activeMedications);
    person.attributes.put("ehr_activeProcedures", activeProcedures);
    person.attributes.put("ehr_conditions", encounter.conditions);
    person.attributes.put("ehr_allergies", encounter.allergies);
    person.attributes.put("ehr_procedures", encounter.procedures);
    person.attributes.put("ehr_immunizations", encounter.immunizations);
    person.attributes.put("ehr_medications", encounter.medications);
    person.attributes.put("ehr_careplans", encounter.careplans);
    person.attributes.put("ehr_imaging_studies", encounter.imagingStudies);
    person.attributes.put("time", encounter.start);
    if (person.attributes.containsKey(LifecycleModule.QUIT_SMOKING_AGE)) {
      person.attributes.put("quit_smoking_age", person.attributes.get(LifecycleModule.QUIT_SMOKING_AGE));
    }
    person.attributes.put("race_lookup", RaceAndEthnicity.LOOK_UP_CDC_RACE);
    person.attributes.put("ethnicity_lookup", RaceAndEthnicity.LOOK_UP_CDC_ETHNICITY_CODE);
    person.attributes.put("ethnicity_display_lookup", RaceAndEthnicity.LOOK_UP_CDC_ETHNICITY_DISPLAY);

    initializeTemplateVariables(person, encounter);
//
//    if (!templateName.equals(encounter.templateName)) {
//      System.out.println(" >>> TEMPLATE THREADING ISSUE >>> " +
//              String.format("%s %s - Encounter: (%s, template:%s, vteStatus: %s, scrambleMode: %s)",
//                      person.attributes.get(Person.FIRST_NAME),
//                      person.attributes.get(Person.LAST_NAME),
//                      encounter.name, encounter.templateName, encounter.vteStatus, encounter.scrambleMode) +
//              String.format("templateName: %s, scrambleMode: %s, randomWordsSet:%s, randomLinesSet:%s, vteStatus:%s",
//                      templateName, scrambleMode, randomWordsSet, randomLinesSet, vteStatus ));
//    }


    StringWriter writer = new StringWriter();
    try {
      String templateFileName = encounter.templateName + ".ftl";
      Template template = TEMPLATES.getTemplate(templateFileName);

      Map<String, Object> variables = new ConcurrentHashMap<String, Object>(person.attributes);
      variables.put("RAND_L1", encounter.RAND_L1);
      variables.put("RAND_L2", encounter.RAND_L2);
      variables.put("RAND_L3", encounter.RAND_L3);
      variables.put("RAND_L4", encounter.RAND_L4);
      variables.put("RAND_L5", encounter.RAND_L5);
      variables.put("RAND_L6", encounter.RAND_L6);
      variables.put("RAND_L7", encounter.RAND_L7);
      variables.put("RAND_L8", encounter.RAND_L8);
      variables.put("RAND_L9", encounter.RAND_L9);
      variables.put("RAND_L10", encounter.RAND_L10);

      variables.put("RAND_W1", encounter.RAND_W1);
      variables.put("RAND_W2", encounter.RAND_W2);
      variables.put("RAND_W3", encounter.RAND_W3);
      variables.put("RAND_W4", encounter.RAND_W4);
      variables.put("RAND_W5", encounter.RAND_W5);
      variables.put("RAND_W6", encounter.RAND_W6);
      variables.put("RAND_W7", encounter.RAND_W7);
      variables.put("RAND_W8", encounter.RAND_W8);
      variables.put("RAND_W9", encounter.RAND_W9);
      variables.put("RAND_W10", encounter.RAND_W10);

      variables.put("randomLinesSet", encounter.randomLinesSet);
      variables.put("randomWordsSet", encounter.randomWordsSet);

      variables.put("templateName", encounter.templateName);
      variables.put("scrambleMode", encounter.scrambleMode);
      variables.put("vteStatus", encounter.vteStatus);

      template.process(variables, writer);

    } catch (Exception e) {
      e.printStackTrace();
    }

    // scramble words if necessary.
    String notes = writer.toString();
    if (encounter.scrambleMode == 4 || encounter.scrambleMode == 5) {
      return WordJuggler.scrambleText(notes);
    }

//    if (!templateName.equals("note")
//            && !scrambleMode.equals("0")
//            && !(randomLinesSet.equals("Y") || randomWordsSet.equals("Y") ) ) {
//      System.out.println(" >>> TEMPLATE REPLACEMENT ISSUE >>> " +
//              String.format("%s %s - Encounter:%s",
//                      person.attributes.get(Person.FIRST_NAME),
//                      person.attributes.get(Person.LAST_NAME),
//                      encounter.name) +
//              String.format("templateName: %s, scrambleMode: %s, randomWordsSet:%s, randomLinesSet:%s, vteStatus:%s",
//                      templateName, scrambleMode, randomWordsSet, randomLinesSet, vteStatus ));
//    }

    return notes;
  }
}
