package org.mitre.synthea.export;

import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

public class WordJugglerTest extends TestCase {
    @Test
    public void testScramble() throws  Exception{
        File sampleFile = new File("src/test/resources/export/sample-radiology-report.txt");
        String data = FileUtils.readFileToString(sampleFile, "UTF-8");
        System.out.println(data);
        String scrambled = WordJuggler.scrambleText(data);
        assertFalse(data.contains("plural"));
        assertTrue(scrambled.contains("plural"));
        assertTrue(scrambled.contains("OTHER REMARKS:"));

    }
}