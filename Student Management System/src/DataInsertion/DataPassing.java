package DataInsertion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBUtil.DButil;
import Bean.Bean_class;

public class DataPassing
{
public static int enterdata(Bean_class bcobj)
	{
	int i=0;
	try
	{
		PreparedStatement pst = DButil.getDBConnection().prepareStatement("insert into Student values(?,?,?)");
		pst.setString(1, bcobj.getName());
		pst.setInt(2, bcobj.getRoll());
		pst.setString(3, bcobj.getDob());
		i=pst.executeUpdate();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in Passing Data");
	}
	
	if(i==1)
	{
		return 1;
	}
	else
        return 0;
	}
	public static int modifydata(int choice,int roll,String newdata){
		int a = 0;
		switch(choice){
			case 1 :
				//int a = 0;
				try
				{
					PreparedStatement pst=DButil.getDBConnection().prepareStatement("update Student set Name = ? where Roll = ?");
					pst.setString(1,newdata);
					pst.setInt(2,roll);
					a=pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Exception in Modifying Data");
				}
				break;
			case 2 :
				//int b = 0;
				try
				{
					PreparedStatement pst=DButil.getDBConnection().prepareStatement("update Student set Roll = ? where Roll = ?");
					int newroll = Integer.parseInt(newdata);
					pst.setInt(1,newroll);
					pst.setInt(2,roll);
					a = pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Exception in Modifying Data");
				}
				break;
			case 3 :
				//int c = 0;
				try
				{
					PreparedStatement pst=DButil.getDBConnection().prepareStatement("update Student set DOB = ? where Roll = ?");
					pst.setString(1,newdata);
					pst.setInt(2,roll);
					a = pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Exception in Modifying Data");
				}
				break;
		}
		if(a == 1)
			return 1;
		else
			return 0;
	}
	public static int deletedata(int c,String del){
		int a = 0;
			if (c == 1){
				try{
					PreparedStatement pst = DButil.getDBConnection().prepareStatement("delete from Student where Name = ?");
					pst.setString(1,del);
					a = pst.executeUpdate();
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in deleting data");
				}
			}
			else if(c == 2){
				try{
					PreparedStatement pst1 = DButil.getDBConnection().prepareStatement("delete from Student where DOB = ?");
					pst1.setString(1,del);
					a = pst1.executeUpdate();
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception in deleting data");
				}
			}
		if(a == 1)
			return 1;
		else
			return 0;
	}
	public static int deletedata(int roll){
		int a = 0;
		try{
			PreparedStatement pst = DButil.getDBConnection().prepareStatement("delete from Student where Roll = ?");
			pst.setInt(1,roll);
			a = pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in deleting data");
		}
		if(a == 1)
			return 1;
		else
			return 0;
	}
	public static int deletedata(){
		int a = 0;
		try{
			PreparedStatement pst = DButil.getDBConnection().prepareStatement("delete from Student");
			a = pst.executeUpdate();
			//System.out.println(a);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception in deleting data");
		}
		if(a == 1)
			return 1;
		else
			return 0;
	}
	public static void displayData(int roll){
		try{
			int x = 0;
			PreparedStatement print = DButil.getDBConnection().prepareStatement("select * from Student");
			ResultSet res = print.executeQuery();
			while(res.next()){
				String name = res.getString("Name");
				int roll1 = res.getInt("Roll");
				String dob = res.getString("DOB");
				if(roll == roll1){
					System.out.println(name+" "+roll1+" "+dob);
					x++;
					break;
				}
			}
			if(x == 0)
				System.out.println("Data not found :(");
		}
		catch(Exception e){
			System.out.println("Error fetching data lmao");
		}
		
	}
	public static void displayData(){
		try{
			PreparedStatement print = DButil.getDBConnection().prepareStatement("select * from Student");
			ResultSet res = print.executeQuery();
			while(res.next()){
				String name = res.getString("Name");
				int roll = res.getInt("Roll");
				String dob = res.getString("DOB");
				System.out.println(name+" "+roll+" "+dob);
			}
		}
		catch(Exception e){
			System.out.println("Error fetching data lmao");
		}
		
	}

}

