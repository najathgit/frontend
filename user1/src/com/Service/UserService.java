package com.n.User.Service;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import com.n.User.Database.UserDatabase;
import com.n.User.Model.User;

public class UserService {
	
	

		
			
			
			Connection con = UserDatabase.connector();
			
			//Get User List
			public List<User>getUsers(){
			   	 
			   	 List<User> user = new ArrayList<>();
			   	 String sql = "select * from user";
			   	 try 
			   	   {
			   		 
						  Statement st = con.createStatement();
						  ResultSet rs = st.executeQuery(sql);
						  
						  while(rs.next())
						  {
							  User u = new User();
							  u.setId(rs.getInt(1));
							  u.setFirst_name(rs.getString(2));
							  u.setLast_name(rs.getString(3));
							  u.setDate_of_birth(rs.getDate(4));
							  u.setTelephone_no(rs.getString(5));
							  u.setUsername(rs.getString(6));
							  u.setPassword(rs.getString(7));
							  u.setEmail(rs.getString(8));
							  u.setUser_type(rs.getString(9));
			
							   			  
							  user.add(u);
						  }
						
					    } 
			   	 catch (Exception e) 
			   	  {
						
					   System.out.println(e);
			   	  }
			   	  
			   	 return user;
			   	 
			    }
			    
			    
			    
			    
			    
			    
			    //Get Only One User
			    public User getUser(int id)
			    
			    {
			   	 String sql = "select * from user where id="+id;
			   	User u = new User();
			   	 try 
			   	   {
						  Statement st = con.createStatement();
						  ResultSet rs = st.executeQuery(sql);
						  if(rs.next())
						  {
							
							  u.setId(rs.getInt(1));
							  u.setFirst_name(rs.getString(2));
							  u.setLast_name(rs.getString(3));
							  u.setDate_of_birth(rs.getDate(4));
							  u.setTelephone_no(rs.getString(5));
							  u.setUsername(rs.getString(6));
							  u.setPassword(rs.getString(7));
							  u.setEmail(rs.getString(8));
							  u.setUser_type(rs.getString(9));
						
					    
						  }
			   	   }
			   	 catch (Exception e) 
			   	  {
						
					   System.out.println(e);
			   	  } 
			   	 
			   	 return u;
			   	 
			    }
			    
			  //Get buyrt search username
			    public User getUsername(String  username)
			    
			    {
			    	List<User> user = new ArrayList<>();
			   	 	String sql = "select * from user where username ="+username;
			   	 User u = new User();
			   	 	
			   	 try 
			   	   {
						  Statement st = con.createStatement();
						  ResultSet rs = st.executeQuery(sql);
						  if(rs.next())
						  {
						
							  
							  
							  u.setId(rs.getInt(1));
							  u.setFirst_name(rs.getString(2));
							  u.setLast_name(rs.getString(3));
							  u.setDate_of_birth(rs.getDate(4));
							  u.setTelephone_no(rs.getString(5));
							  u.setUsername(rs.getString(6));
							  u.setPassword(rs.getString(7));
							  u.setEmail(rs.getString(8));
							  u.setUser_type(rs.getString(9));
						
					    
							 
						  }
						
					    } 
			   	 catch (Exception e) 
			   	  {
						
					   System.out.println(e);
			   	  } 
			   	 
			   	 return u;
			   	 
			    }


			    
			    //Create User
				public void createUser(User u1) 
				{
					String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
			  	 try 
				   {
					  PreparedStatement st = con.prepareStatement(sql);
					  st.setInt(1, u1.getId());
					  st.setString(2, u1.getFirst_name());
					  st.setString(3, u1.getLast_name());
					  st.setDate(4, u1.getDate_of_birth());
					  st.setString(5, u1.getTelephone_no());
					  st.setString(6, u1.getUsername());
					  st.setString(7, u1.getPassword());
					  st.setString(8, u1.getEmail());
					  st.setString(9, u1.getUser_type());
					  
					  
					  
					  
					  
					 
					  
					  
					  st.executeUpdate();
				
					
				    } 
				 catch (Exception e) 
				  {
					
				   System.out.println(e);
				  } 
					
				}
				
				//Update User
				public void updateUser(User u1) 
				{
					String sql = "update user set first_name=?,last_name=?,date_of_birth=?,telephone_no=?,username=?,password=?,email=?,user_type=?   where id=?";
			  	 try 
				   {
					  PreparedStatement st = con.prepareStatement(sql);

					  
					  
					  
					  
					  
					  st.setInt(1, u1.getId());
					  st.setString(2, u1.getFirst_name());
					  st.setString(3, u1.getLast_name());
					  st.setDate(4, u1.getDate_of_birth());
					  st.setString(5, u1.getTelephone_no());
					  st.setString(6, u1.getUsername());
					  st.setString(7, u1.getPassword());
					  st.setString(8, u1.getEmail());
					  st.setString(9, u1.getUser_type());
					  
					  
					  
			         st.executeUpdate();
				
					
				    } 
				 catch (Exception e) 
				  {
					
				   System.out.println(e);
				  } 
					
				}



				public void deleteUser(int id) {

					String sql = "delete from user where id=?";
			  	 try 
				   {
					  PreparedStatement st = con.prepareStatement(sql);
					  st.setInt(1, id);
			         st.executeUpdate();
				
					
				    } 
				 catch (Exception e) 
				  {
					
				   System.out.println(e);
				  } 

				}


		}
