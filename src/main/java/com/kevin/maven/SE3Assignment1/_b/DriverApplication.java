package com.kevin.maven.SE3Assignment1._b;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;

import com.kevin.maven.SE3Assignment1._a.Course;
import com.kevin.maven.SE3Assignment1._a.Module;
import com.kevin.maven.SE3Assignment1._a.Student;

/**
 * Driver Application for student, course, module assignment
 *
 */
public class DriverApplication{

	//static long beginTime = Timestamp.valueOf("1990-01-01 00:00:00").getTime();
    //static long endTime = Timestamp.valueOf("2000-12-31 00:58:00").getTime();
   
	public static void main(String[] args) {

		//begin and end dates of students
		//DateTime beginTime =  new DateTime(1995, 1, 1, 0, 0);
		//DateTime endTime = new DateTime(1999, 1, 1, 0, 0);
		
		
		// Creates course and modules
	    Course[] courses = new Course[2];
	    for (int k = 0; k < 2; k++) {
			courses[k] =  new Course("Course" + k, k + "134J8", getRandomDate(Timestamp.valueOf("2018-09-01 00:58:00").getTime(), Timestamp.valueOf("2018-10-01 00:58:00").getTime()), getRandomDate(Timestamp.valueOf("2019-04-01 00:58:00").getTime(),Timestamp.valueOf("2019-05-01 00:58:00").getTime()));
		}
	    
		Module[] modules = new Module[8];
		for (int i = 0; i < 8; i++) {
			modules[i] = new Module("Module" + i, i + "gosos");
		}

		//add modules to course
		for (int l =0; l< 8; l++) {

			courses[l%2].addModuleToList(modules[l]);

		}

		// Creates 12 mock students rgeb adds courses and modules to them
		for (int j = 0; j < 12; j++) {
		

			Student student = new Student("joe" + j, j + "stjos", getRandomDate(Timestamp.valueOf("1990-01-01 00:00:00").getTime(), Timestamp.valueOf("2000-12-31 00:58:00").getTime())  );
			courses[j%2].addStudentToList(student);
			student.addCourseToList(courses[j%2]);

			if (j% 3 == 0)
				modules[0].addStudentToList(student);
			student.addModuleToList(modules[0]);
			if (j % 3 == 1)
				modules[1].addStudentToList(student);
			student.addModuleToList(modules[1]);
			if (j % 3 == 2)
				modules[2].addStudentToList(student);
			student.addModuleToList(modules[2]);
		}

		//prints
		for(Course course : courses){
		ArrayList<Module>CourseModuleList = course.getModuleList();
		System.out.println("\nCourse: " + course.getName());
		for (Module module : CourseModuleList) {
			System.out.println("\nMODULE: " + module.getName());
			
		}
		
		ArrayList<Student>courseStudentList = course.getStudentsList();
		for (Student student : courseStudentList) {
			ArrayList<Course>StudentCourseList = student.getCourseList();
			ArrayList<Module>StudentModuleList = student.getModuleList();
			System.out.println("\nStudent: " + student.getUsername());
			for (Module module : StudentModuleList) {
				System.out.println("\tModule: " + module.getName());
				
			}
			for (Course courseB : StudentCourseList ) {
				System.out.println("\tCourses: " + courseB.getName());
				
			}
			
		}
		}

	}
	
	//gets random date between 2 inputted dates
	
	private static DateTime getRandomDate(long beginTime,long endTime){
		long diff = endTime - beginTime + 1;
		long timeDiff = beginTime + (long) (Math.random() * diff);
		DateTime randomDate = new DateTime(timeDiff);
		return randomDate;
	}



}