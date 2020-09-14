package com.example.enrollmentService.component;

import com.example.enrollmentService.model.Dependent;
import com.example.enrollmentService.model.Enrollee;
import org.springframework.stereotype.Component;

@Component
public class DependentComponent {


    public Enrollee saveOrUpdateDependent(Enrollee enrollee, Dependent dependent) {
        for (int i = 0; i < enrollee.getDependents().size(); i++) {
            //if dependents match, remove dependent, break, and re-add with new fields
            if (Integer.valueOf(enrollee.getDependents().get(i).getId()) == Integer.valueOf(dependent.getId())) {
                enrollee.getDependents().remove(i);
                break;
            }
        }

        //if dependent is new, just add it without removing anything
        enrollee.getDependents().add(dependent);

        return enrollee;
    }

    public Enrollee deleteDependent(Enrollee enrollee, String dependentId) {
        for (int i = 0; i < enrollee.getDependents().size(); i++) {
            //if dependents match, remove dependent and then break
            if (Integer.valueOf(enrollee.getDependents().get(i).getId()) == Integer.valueOf(dependentId)) {
                enrollee.getDependents().remove(i);
                break;
            }
        }

        return enrollee;
    }
}
