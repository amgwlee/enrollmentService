package com.example.enrollmentService.component;

import com.example.enrollmentService.model.Dependent;
import com.example.enrollmentService.model.Enrollee;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DependentComponentTests {


    DependentComponent dependentComponent = new DependentComponent();

    @Test
    //add new dependent that doesn't exist to Enrollee
    public void test_saveOrUpdateDependent_new_dependent() {

        Enrollee enrollee = buildSampleEnrollee();
        assert(enrollee.getDependents().size() == 3);

        String id = "99";
        String firstName = "Alastair";
        String lastName = "Lewis";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        Enrollee modifiedEnrollee = dependentComponent.saveOrUpdateDependent(enrollee, dependent);

        //assert dependent list +1 size
        assert(modifiedEnrollee.getDependents().size() == 4);

        //assert dependent id
        assert(Integer.valueOf(modifiedEnrollee.getDependents().get(3).getId()) == Integer.valueOf(99));
    }

    @Test
    //change name of existing dependent in default Enrollee
    public void test_saveOrUpdateDependent_update_dependent() {

        Enrollee enrollee = buildSampleEnrollee();

        String id = "99";
        String firstName = "Alastair";
        String lastName = "Lewis";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        enrollee.getDependents().add(dependent);

        //assert name before change
        assert(enrollee.getDependents().get(3).getFirstName().equals("Alastair"));

        dependent.setFirstName("Michael");

        Enrollee modifiedEnrollee = dependentComponent.saveOrUpdateDependent(enrollee, dependent);

        //assert dependent list size same as before update
        assert(modifiedEnrollee.getDependents().size() == enrollee.getDependents().size());

        //assert dependent name change
        assert(enrollee.getDependents().get(3).getFirstName().equals("Michael"));
    }

    @Test
    //delete a dependent by id that exists
    public void test_deleteDependent_normal() {


        Enrollee enrollee = buildSampleEnrollee();
        assert(enrollee.getDependents().size() == 3);

        String id = "99";
        String firstName = "Alastair";
        String lastName = "Lewis";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        enrollee.getDependents().add(dependent);

        assert(enrollee.getDependents().size() == 4);

        Enrollee modifiedEnrollee = dependentComponent.deleteDependent(enrollee, id);

        //assert dependent list size -1
        assert(modifiedEnrollee.getDependents().size() == 3);
    }

    @Test
    //attempt to delete a dependent by id that does not exist
    public void test_deleteDependent_dependent_does_not_exist() {

        Enrollee enrollee = buildSampleEnrollee();
        assert(enrollee.getDependents().size() == 3);

        String id = "99";
        String firstName = "Alastair";
        String lastName = "Lewis";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        enrollee.getDependents().add(dependent);

        assert(enrollee.getDependents().size() == 4);

        Enrollee modifiedEnrollee = dependentComponent.deleteDependent(enrollee, "1234");

        //assert dependent list size hasn't changed
        assert(modifiedEnrollee.getDependents().size() == 4);
    }


    private Enrollee buildSampleEnrollee() {

        String id = "1007";
        String firstName = "Rivas";
        String lastName = "Henderson";
        boolean active = false;
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-27");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String phoneNumber = "+1 (966) 596-3746";

        ArrayList<Dependent> dependents = new ArrayList<Dependent>();

        dependents.add(buildSampleDependent1());
        dependents.add(buildSampleDependent2());
        dependents.add(buildSampleDependent3());

        Enrollee enrollee = new Enrollee(id, firstName, lastName, active, birthDate, phoneNumber, dependents);

        return enrollee;
    }

    private Dependent buildSampleDependent1() {
        String id = "10";
        String firstName = "Sonia";
        String lastName = "Hester";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        return dependent;
    }

    private Dependent buildSampleDependent2() {
        String id = "11";
        String firstName = "Johns";
        String lastName = "Pennington";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        return dependent;
    }

    private Dependent buildSampleDependent3() {
        String id = "12";
        String firstName = "Corrine";
        String lastName = "Gomez";
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse("2014-06-30");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Dependent dependent = new Dependent(id, firstName, lastName, birthDate);

        return dependent;
    }

}
