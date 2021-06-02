package org.mitre.synthea.export;

import org.apache.commons.lang3.RegExUtils;

import java.util.*;

public class WordJuggler {
    public static Random rand = new Random();

    public static List<String> RANDOM_LINES = fetchRandomLines();
    public static List<String> RANDOM_WORDS = fetchRandomWords();
    public static Map<String, List<String>> TYPOS = fetchTypos();

    public static int lineSize = RANDOM_LINES.size();
    public static int wordsSize = RANDOM_WORDS.size();

    public static List<Integer> generateRandomNumbers(int count, int max) {
        List<Integer> nums = new ArrayList<Integer>();
        int n = rand.nextInt(max);
        for (int i = 0; i < count; i++) {
            while (nums.indexOf(n) > -1) {
                n = rand.nextInt(max);
            }
            nums.add(n);
        }

        return nums;
    }

    public static List<String> randomLines() {
        List<Integer> nums = generateRandomNumbers(10, lineSize);
        List<String> randomLines = new ArrayList<String>();
        randomLines.add("");
        randomLines.add( "         ");
        randomLines.add( "...");
        for(int n : nums)  {
            randomLines.add(" " + RANDOM_LINES.get(n) + ".");
        }
        Collections.shuffle(randomLines);
        return randomLines;
    }

    public static List<String> randomWords() {
        List<Integer> nums = generateRandomNumbers(10, wordsSize);
        List<String> randomWords = new ArrayList<String>();
        randomWords.add("");
        randomWords.add(" ");
        randomWords.add("!");
        randomWords.add(".");
        randomWords.add(" " + RANDOM_WORDS.get(nums.get(0)));
        randomWords.add(RANDOM_WORDS.get(nums.get(1)) + " ");
        randomWords.add(" " + RANDOM_WORDS.get(nums.get(2)) + " ");
        randomWords.add(" " + RANDOM_WORDS.get(nums.get(3)) + " ");
        randomWords.add(RANDOM_WORDS.get(nums.get(4)) + " ");
        randomWords.add("" + RANDOM_WORDS.get(nums.get(5)));
        randomWords.add(RANDOM_WORDS.get(nums.get(6)));
        randomWords.add(" ( " +RANDOM_WORDS.get(nums.get(7)) + " ) ");
        randomWords.add(RANDOM_WORDS.get(nums.get(8)));
        randomWords.add(RANDOM_WORDS.get(nums.get(9)));
        Collections.shuffle(randomWords);
        return randomWords;
    }

    public static String scrambleText(String text) {

        String[] parts = text.split("OTHER REMARKS:");


        String scrambled = parts[0];
        for (String word : TYPOS.keySet()) {
            List<String> synonyms = TYPOS.get(word);
            int i = rand.nextInt(synonyms.size());
            String synonym = synonyms.get(i);
            scrambled = RegExUtils.replaceAll(scrambled, word, synonym);
        }
        return scrambled + "OTHER REMARKS:" + parts[1];
    }

    private static Map<String, List<String>> fetchTypos() {

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("pulmonary embolism", Arrays.asList("p.e", "PE", "P.E"));
        map.put("PE", Arrays.asList("p.e", "Physical Education (PE)", "P.E"));
        map.put("pleural", Arrays.asList("plural","purell", "plurals"));
        map.put("pulmonary", Arrays.asList("stroke", " ", "pulmonary", "palmonary", "pulmonery", "pelmonary", "lung", "right pulmonary", "planetary", "palmieri", "preliminary pulmonary", "preliminary", "pulmonary preliminary", "planetary pulmonary"));
        map.put("embolism", Arrays.asList(" ", "embolism", "ablism", "abolism", "empolism", "clot", "block", "mbolic", "embolus", "embolden", "ebolism", "embolisms", "symbolism", "embolus embolism", "tiny bubble", "elboism", "elbolism", "emboliz", "embolis", "embolisis", "plagiarism", "altruism", "ebola", "thrombo", "thrombophlebitis", "hematoma", "aeroembolism", "aembolism", "embolistic", "ascites", "lump", "thrombosis"));
        map.put("embolus", map.get("embolism"));
        map.put("lung", Arrays.asList("", " ", "respiratory", "lungs", "pneumoconiosis", "respiratory organ", "ling", "lang", "lyng", "long", "pleural cavity", "lung cancer", "lugs", "iung", "lungis", "sungs", "lung lung", "right lung", "left lung", "chest lung", "chest", "lunch", "lump", "mung", "lung fry", "chicken lung", "lung stew", "lung curry", "-lung-", "lung.", ".lung"));
        map.put("illdefined", Arrays.asList("", " ", "illdefined", "ill defined", "ill-defined", "well defined", "ill shown", "ill visible", "hidden", "not clear", "undefined", "defined", "not defined", "dim", "vauge", "unclear", "faint", "dimmed", "nebulous", "dark", "crude", "unclear", "not defined", "not defined"));
        map.put("vein", Arrays.asList("pulmonary vessel thrombosis", "vena", "venous", "temporal vein", "ardinal vein", "vain", "wain", "spain", "rain", "vein", "artery", "nervure", "vessel", "bartery", "veein", "vessels", "vessel", "blood vessel", "bloood vein"));
        map.put("deep", Arrays.asList(" ", "deeper", "deeep", "dee", "the depest", "doop","beep","thick", "intense","abyssal", "big"));
        map.put("dvt", Arrays.asList("DDT", "DVD", "VVT", "D V T", "D VT", "DV thrombosis", "D.V.T", "d.v.t","Direct Vendor Tool (DVT)","deep vessel thrombosis", "deep vain thrombosis", "Dr. Victor Thomas (DVT)"));
        map.put("DVT", map.get("dvt"));
        map.put("vte", Arrays.asList("VTE", "V.T.E", "VVT", "PE"));
        map.put("VTE", map.get("vte"));
        map.put("clot", Arrays.asList("claught", "clout", "clto", "clut", "coagulate", "block", "sticky", "cluster", "thromb", "thrombuses"));
        map.put("lower", Arrays.asList("low", "bottom", "inferior", "lesser"));
        map.put("occlusion", Arrays.asList("oclusion","0cclusion", "chemical causing an occlus ion", "occlult", "blockage", "closure", "eclosion", "occlus", "occluded" ));
        map.put("profunda", Arrays.asList("profund", "pro funda", "profound", "profounda", "arteria", "profundo"));
        map.put("deep vein thrombosis", map.get("dvt"));
        map.put("radiologist", Arrays.asList("radio logist", "rodiologist"));
        map.put("Deep Vein Thrombosis", Arrays.asList("D.V. Thomas (DVT)", "Drink Vodka Today (DVT)"));
        map.put("brachiocephalic", Arrays.asList("branchiocephalic","brachycephalic", "brachiocephalics", "brachiocephlic", "brachiocaphalic", "brachio cephalic","truncus celiacus","radial vein"));
        map.put("costophrenic", Arrays.asList(" ", "costophrenic", "costophrenics", "azimuthal", "pleural effusion", "thoracentesis", "diaphragm", "costophrenics"));
        map.put("costophrenic angle", Arrays.asList(" ","costophrenic acute angle", "costophrenic right angle at 90 degree north east", "costophrenic recesses", "costophrenic angle", "costophrenic blunting", "CP angle"));
        map.put("thrombus", Arrays.asList("", " ", "thrombus", "thrombuses", "thromboline", "thromb", "thrombas", "thrombectomy", "atheroma", "occlusion", "occlusions", "thrombosis", "stenosis", "asilar artery", "thrombophilia", "defect", "thromboembolism", "deep vessel thrombosis", "deeep veins", "angina pectoris", "leg vein", "vein clot", "vessel clot", "coronary artery disease", "thrombolysis", "venous thrombosis"));


        return map;

    }


    private static List<String> fetchRandomLines() {
        return Arrays.asList("In ancient Greek, there was a king named Midas.",
                "He had a lot of gold and everything he needed. He also had a beautiful daughter.",
                "Midas loved his gold very much, but he loved his daughter more than his riches.",
                "One day, a satyr named Silenus got drunk and passed out in Midas’ rose garden.",
                "The foolish farmer’s wife also agreed and decided to cut the goose’s stomach for the eggs.",
                "As soon as they killed the bird and opened the goose’s stomach, to find nothing but guts and blood.",
                "The farmer, realizing his foolish mistake, cries over the lost resource!",
                "One day, a thief who knew the old miser’s routine, waited for the old man to go back into his house.",
                "After it was dark, the thief went to the hiding place and took the gold.",
                "The next day, the old miser found that his treasure was missing and started crying loudly.",
                "Four cows lived in a forest near a meadow. They were good friends and did everything together.",
                "They grazed together and stayed together, because of which no tigers or lions were able to kill them for food.",
                "But one day, the friends fought and each cow went to graze in a different direction.",
                "A tiger and a lion saw this and decided that it was the perfect opportunity to kill the cows.",
                "They hid in the bushes and surprised the cows and killed them all, one by one.",
                "                           ",
                "!!!!!",
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$",
                "We were all a little drunk with spring, like the fat bees reeling from flower to flower, and a strange insurrectionary current ran among us.",
                "Inside us there is something that has no name, that something is what we are.",
                "The circle of an empty day is brutal and at night it tightens around your neck like a noose.",
                "The dean listened and agreed to let them take the test on a later date.",
                "Happy that they got a second chance, the four friends studied hard and were ready for the exam.",
                "On exam day, the dean asked the students to sit in separate classrooms, which the students agreed to.",
                "Within seconds of that thought, the train entered Washington, where she was to come to her end more than sixty-eight years later, a mother to seven living and two dead, a grandmother to twenty-one living and three dead, a great-grandmother to twelve, a great-great grandmother to twins."
        );
    }

    private static List<String> fetchRandomWords() {
        return Arrays.asList("abaft",
                "abalone",
                "abandon",
                "abandoned",
                "abandonee",
                "abandonees",
                "abandoning",
                "abandonment",
                "abandons",
                "abase",
                "abased",
                "abasement",
                "abases",
                "abash",
                "acoustical",
                "acoustically",
                "acoustics",
                "acquaint",
                "acquaintance",
                "acquaintances",
                "acquaintanceship",
                "acquainted",
                "acquainting",
                "acquaints",
                "acquest",
                "acquests",
                "acquiesce",
                "acquiesced",
                "acquiescence",
                "acquiescent",
                "acquiescently",
                "acquiesces",
                "acquiescing",
                "acquirable",
                "acquire",
                "acquired",
                "acquirement",
                "acquirements",
                "acquires",
                "acquiring",
                "acquisition",
                "chronicle",
                "chronicled",
                "chronicler",
                "chroniclers",
                "chronicles",
                "chronicling",
                "chronograph",
                "chronographs",
                "chronological",
                "chronologically",
                "chronologies",
                "chronologist",
                "chronologists",
                "chronology",
                "chronometer",
                "chronometers",
                "chrysalides",
                "chrysalis",
                "chrysalises",
                "chrysanthemum",
                "chrysanthemums",
                "chrysler",
                "chryslers",
                "wrns",
                "wrong",
                "wrongdoer",
                "wrongdoers",
                "wrongdoing",
                "wronged",
                "wrongful",
                "wrongfully",
                "wronging",
                "wrongly",
                "wrongs",
                "wrote",
                "wroth",
                "wrotham",
                "wrought",
                "wrung",
                "wrvs",
                "wry",
                "wryer",
                "wryest",
                "wryly",
                "wsw",
                "wyatt",
                "wycombe",
                "wye",
                "wykeham",
                "wyman",
                "wymondham",
                "wynn",
                "wyoming",
                "wysiwyg",
                "wyvern",
                "x",
                "xebec",
                "xebecs",
                "xenodochium",
                "xenon",
                "xenophile",
                "xenophiles",
                "xenophilous",
                "xenophobe",
                "xenophobes",
                "xenophobia",
                "xenophobic",
                "xerographic",
                "xerography",
                "xerox",
                "xeroxed",
                "xeroxes",
                "xeroxing",
                "xi",
                "xii",
                "xiii",
                "xiv",
                "xix",
                "xmas",
                "xmases",
                "xu",
                "xv",
                "xvi",
                "xvii",
                "xviii",
                "xx",
                "xxi",
                "xxii",
                "xxiii",
                "xxiv",
                "xxix",
                "xxv",
                "xxvi",
                "xxvii",
                "xxviii",
                "xxx",
                "xylem",
                "xylography",
                "xylophone",
                "xylophones",
                "xylophonist",
                "xylophonists",
                "y",
                "yacht",
                "yachted",
                "yachter",
                "yachters",
                "yachting",
                "yachts",
                "yachtsman",
                "yachtsmen",
                "yachtswoman",
                "yachtswomen",
                "yah",
                "yahoo",
                "yahoos",
                "yahweh",
                "yak",
                "yaks",
                "yale",
                "yalta",
                "yam",
                "yamaha",
                "yammer",
                "yammered",
                "yammering",
                "yammers",
                "yams",
                "yang",
                "yank",
                "yanked",
                "yankee",
                "yankees",
                "yanking",
                "yanks",
                "yap",
                "yapped",
                "yapping",
                "yaps",
                "yard",
                "yardage",
                "yardarm",
                "yardie",
                "yardies",
                "yardley",
                "yardman",
                "yardmen",
                "yards",
                "yardstick",
                "yardsticks",
                "yarmouth",
                "yarmulke",
                "yarmulkes",
                "yarn",
                "yarns",
                "yarrow",
                "yarrows",
                "yashmak",
                "yaw",
                "yawed",
                "yawing",
                "yawl",
                "yawls",
                "yawn",
                "yawned",
                "yawner",
                "yawning",
                "yawningly",
                "yawns",
                "yaws",
                "yea",
                "yeah",
                "year",
                "yearbook",
                "yearbooks",
                "yearling",
                "yearlings",
                "yearlong",
                "yearly",
                "yearn",
                "yearned"
        );
    }

}
