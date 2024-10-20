package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job("Junior Developer", new Employer("Tech Corp"), new Location("Remote"), new PositionType("Software Engineer"), new CoreCompetency("Java"));
        Job job2 = new Job("Senior Developer", new Employer("Tech Corp"), new Location("Remote"), new PositionType("Software Engineer"), new CoreCompetency("Java"));

        asserNotEquals(job1.getId(), job2.getId());
    }

    private void asserNotEquals(int id, int id1) {

    }

    @Test
    public void testJobConstructorSetsAllFields(){
       Job theJob= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(theJob.getName() instanceof String);
        assertTrue(theJob.getEmployer() instanceof Employer);
        assertTrue(theJob.getLocation() instanceof Location);
        assertTrue(theJob.getPositionType() instanceof PositionType);
        assertTrue(theJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", theJob.getName());
        assertEquals("ACME", theJob.getEmployer().getValue());
        assertEquals("Desert", theJob.getLocation().getValue());
        assertEquals("Quality control", theJob.getPositionType().getValue());
        assertEquals("Persistence", theJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job theJob= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job theJob2= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(theJob.equals(theJob2));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobs = new Job("Junior Developer", new Employer("Tech Corp"), new Location("Remote"), new PositionType("Software Engineer"), new CoreCompetency("Java"));
        String jobsString = jobs.toString();
        String line = System.lineSeparator();
        assertEquals(line, jobsString.substring(0,line.length()));
        assertEquals(line, jobsString.substring(jobsString.length() - line.length()));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobs = new Job("Junior Developer", new Employer("Tech Corp"), new Location("Remote"), new PositionType("Software Engineer"), new CoreCompetency("Java"));
         String outPut= System.lineSeparator() +
              "ID: " + jobs.getId() + System.lineSeparator() +
              "Name: Junior Developer" + System.lineSeparator() +
              "Employer: Tech Corp" + System.lineSeparator() +
              "Location: Remote" + System.lineSeparator() +
              "Position Type: Software Engineer" + System.lineSeparator() +
              "Core Competency: Java" + System.lineSeparator();
       assertEquals(outPut,jobs.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobs = new Job("", new Employer(""), new Location("Remote"), new PositionType("Software Engineer"), new CoreCompetency("Java"));
        String outPut= System.lineSeparator() +
                "ID: " + jobs.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Remote" + System.lineSeparator() +
                "Position Type: Software Engineer" + System.lineSeparator() +
                "Core Competency: Java" + System.lineSeparator();
        assertEquals(outPut,jobs.toString());
    }
}
