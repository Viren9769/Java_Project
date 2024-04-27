package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard_Student extends Blackboard {

    // Constructor
    public Blackboard_Student(String id, Data d) {
        super(id, d);
    }

    // Override welcome method
    @Override
    public void welcome() {
        Scanner input = new Scanner(System.in);
        String selection = "";

        while (!selection.equals("x")) {
            System.out.println("Welcome to blackboard");
            System.out.println();
            System.out.println("Please make the selection of the course:");
            System.out.println();

            ArrayList<String> courses = super.getD().getMyCourses(super.getId());
            for (int i = 0; i < courses.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, courses.get(i));
            }
System.out.println("x: go Back");
            System.out.println("Please make the selection of the course: ");
            

            String intSel = input.nextLine();
            String selectedCourseId = " ";
            
if(selectedCourseId.equals("x"))
{
	return;
}
else if (isInteger.test(intSel)) {
                int sel = Integer.parseInt(intSel);
                if (sel > 0 && sel <= courses.size()) {
                	
                    selectedCourseId = courses.get(sel - 1);
                   
					/*
					 * selection = input.nextLine();
					 * 
					 * if (selection.equals("v")) { viewMyCourses(selectedCourseId); }
					 */
                    //else if (selection.equals("p")) {
                        // add a new course note
                        // writenote();
                        // super.getD().writenote(super.getId(), selection);
                    }
                view(selectedCourseId);
                }
            }
        }
   

    // New method to view course notes based on the selected course ID
    public void view(String courseId) {
    	Scanner input = new Scanner(System.in);
    	String selection = " ";
    	 System.out.println();
         System.out.println("Please select an option:");
         System.out.println("v: view my course note");
         System.out.println("x: Logout");
selection = input.next();
if(selection.equals("x"))
         {
        	 welcome();
         }
        // Use the courseId to retrieve and display course notes
         else if(selection.equals("v")) {
        ArrayList<CourseNote> courseNotes = (ArrayList<CourseNote>)super.getD().getCourseNotes(courseId);
        
        System.out.println();
        System.out.println("Course notes for " + courseId);
        if(courseNotes.size()>0)
        {
        for (CourseNote n : courseNotes) {
            System.out.println(n.getDatetime() +" : " + n.getContent());
        }
        }
        }
        else 
        {
        	System.out.println("None");
        	System.out.println();
        	}
        view(courseId);
    }


	@Override
	public void viewMyCourses() {
		// TODO Auto-generated method stub
		
	}

    // ... existing code ...
}
