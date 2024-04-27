package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public  class Blackboard_Faculty extends Blackboard{

	/**
	 * @param id
	 * @param d
	 */
	public Blackboard_Faculty(String id, Data d) {
		super(id, d);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void welcome()
	{
	
		Scanner input = new Scanner(System.in);
		String selection = "";
		
		while(!selection.equals("x"))
		{
			System.out.println("Welcome to blackboard");
			System.out.println();
			System.out.println("select your course:");
			System.out.println();

			ArrayList<String> teachings = super.getD().getMyTeachingCourses(super.getId());
			for(int i=0; i<teachings.size(); i++)
			{
				System.out.printf("%d: %s\n", i+1, teachings.get(i));
				
			}
			// System.out.println("please make the selection of the course: ");
			
			String intSel = "";
			intSel = input.next();
		
			if(isInteger.test(intSel))
			{
				int sel = Integer.parseInt(intSel);
				if(sel>0 && sel<=teachings.size())
				{
					selection = teachings.get(sel-1);
					
					viewNotes(selection);
					/*
					 * System.out.println(); System.out.println("Please select an option:");
					 * System.out.println("v: view my course note");
					 * System.out.println("p: put a new course note");
					 * System.out.println("x: Logout");
					 * 
					 * selection = input.nextLine();
					 * 
					 * if(selection.equals("v")) { //super.getD().viewMyCourses(super.getId(),
					 * selection); viewMyCourses(selection); } else if(selection.equals("p")) {
					 * //add a new course note writenote(selection);
					 * //super.getD().writenote(super.getId(), selection); }
					 */
					
				}
				
			}
		}
		}
public void viewNotes(String courseID){
		
		Scanner input = new Scanner(System.in);
		String selection = "";
			System.out.println("Please select your options");
			System.out.println("v : View Course Notes");
			System.out.println("p : Post New Course Note");
			System.out.println("x : Leave course");
			selection  = input.next();
			input.nextLine();
			
		if(selection.equals("x")){
			viewMyCourses();
		}
		
		if(selection.equals("p")){
			System.out.println("Please write your Note for "+ courseID);
			String note = input.nextLine();
			String dt = DateAndTime.DateTime();
			
			super.getD().writeNote(super.getId(), courseID, note, dt);
			System.out.println("Course Note has been posted. ");
			viewNotes(courseID);

		}
		else if(selection.equals("v")) {
			
			ArrayList<CourseNote> notes = (ArrayList<CourseNote>)super.getD().getCourseNotes(courseID);
			
			System.out.println();
			System.out.println("Course Notes for " + courseID);
			if(notes.size()>0) {
				
				for(CourseNote n : notes) {
					System.out.println(n.getDatetime()+" : "+n.getContent());
				}
				
				System.out.println();
				System.out.println();
				System.out.println();
			}
			
			else {
				System.out.println("None");
				System.out.println();
			}
			viewNotes(courseID);
		}
	}
@Override
public void viewMyCourses() {
	// TODO Auto-generated method stub
	
}
	

	
		/*
		 * public void viewNotes(String courseId) { Scanner input = new
		 * Scanner(System.in); System.out.println("please write your content for " +
		 * courseId); String content = input.nextLine(); String dt =
		 * DateAndTime.DateTime(); // TODO Auto-generated method stub
		 * super.getD().writeNote(super.getId(), content, courseId, dt);
		 * 
		 * System.out.println("added!"); (courseId);
		 * 
		 * } public void viewMyCourses(String courseId) { ArrayList<CourseNote> courses
		 * = super.getD().getCourseNotes(super.getId()); for(CourseNote s: courses) {
		 * System.out.println(s); } }
		 * 
		 * @Override public void viewMyCourses() { // TODO Auto-generated method stub
		 * 
		 * }
		 */
	
}