package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBQueries;
import com.flipkart.utils.DBUtil;

public class AdminDaoServices implements AdminDaoInterface{

	public static Connection conn = DBUtil.getConnection();
	
	@Override
	public String addProf(Prof prof, String username) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = conn.prepareStatement(DBQueries.FETCH_IDS);
			ResultSet rs=ps.executeQuery();
			List<String> userIds=new ArrayList<String>();
			while(rs.next())
			{
				userIds.add(rs.getString("userID"));
			}
			Random rand = new Random();
			String userID;
			while(true)
			{
				long id = 10000000 + rand.nextInt(10000000);
				userID =  "PROFESSOR" + Long.toString(id);
				if(!userIds.contains(userID))
					break;
			}
			PreparedStatement ps1 = conn.prepareStatement(DBQueries.ADD_USER);
			ps1.setString(1, userID);
			ps1.setString(2, prof.getName());
			ps1.setString(3, "Professor");
			ps1.setString(4, prof.getContact());
			ps1.setString(5, prof.getEmail());
			ps1.setString(6, prof.getPassword());
			ps1.setString(7, username);
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(DBQueries.ADD_PROFESSOR);
            ps2.setString(1, userID);
            ps2.setString(2, prof.getDept());
            ps2.setString(3, prof.getQualification());

            if(ps2.executeUpdate() == 1)
            	return userID;

        } catch (SQLException e) {
        	return null;
        }
        return null;
	}

	@Override
	public boolean removeProf(String profID) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.REMOVE_USER);
            ps.setString(1, profID);
            if(ps.executeUpdate() == 1)
            {
            	ps = conn.prepareStatement(DBQueries.REMOVE_PROFESSOR);
            	ps.setString(1, profID);
            	if(ps.executeUpdate() == 1)
            		return true;
            }
            else {
            	return false;
            }
        }catch (SQLException e) {
        	return false;
        }
		return false;
	}

	@Override
	public boolean updateCourse(String courseID, Course updatedCourse) {
		// TODO Auto-generated method stub
		if(!this.removeCourse(courseID))return false;
		if(!this.addCourse(updatedCourse))return false;
		return true;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.ADD_COURSE);
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getCourseName());
            //ps.setString(3, course.getCourseProf());
            ps.setInt(3, course.getSeats());
            ps.setFloat(4, course.getPrice());

            int rs=ps.executeUpdate();
            if(rs == 1)
            	return true;

        } catch (SQLException e) {
        	return false;
        }
        return false;
		
	}

	@Override
	public boolean removeCourse(String courseID) {
		try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.REMOVE_COURSE);
            ps.setString(1, courseID);
            if(ps.executeUpdate() == 1)
            	return true;
            else
            	return false;

        } catch (SQLException e) {
        	return false;
        }
	}

	@Override
	public boolean registerStudent(String studentID) {
		try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.APPROVE_REGISTRATION);
            ps.setString(1, studentID);
            if(ps.executeUpdate() == 1)
            	return true;
            else
            	return false;

        } catch (SQLException e) {
        	return false;
        }
	}

	@Override
	public Set<Course> viewCourses() {
		try {
			Set<Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_COURSE_CATALOG);
            //ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Course course=new Course(rs.getString("courseID"),rs.getString("courseName"),rs.getString("courseProf"),rs.getInt("seats"));
            	courseList.add(course);
            }
            
            return courseList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

	@Override
	public Set<Student> viewUnapprovedStudents() {
		// TODO Auto-generated method stub
		try {
			Set<Student> studentList = new HashSet<Student>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_UNAPPROVED_STUDENTS);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Student student=new Student(rs.getString("user.userID"),rs.getString("user.name"),rs.getString("user.contact"),rs.getString("user.email"),rs.getString("student.branch"),rs.getInt("student.rollNum"),rs.getBoolean("student.approved"),rs.getString("user.password"));
            	studentList.add(student);
            	System.out.println(student.getName());
            }
            
            return studentList;
            
        } catch (SQLException e) {
        	e.printStackTrace();
    		return null;
        }
	}

	@Override
	public Set<Prof> viewProfessors() {
		// TODO Auto-generated method stub
		try {
			Set<Prof> profList = new HashSet<Prof>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_PROF_LIST);
            //ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Prof prof=new Prof(rs.getString("user.userID"),rs.getString("user.name"),rs.getString("user.contact"),rs.getString("user.email"),rs.getString("professor.department"),rs.getString("professor.qualification"),rs.getString("user.password"));
            	profList.add(prof);
            }
            
            return profList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

}
