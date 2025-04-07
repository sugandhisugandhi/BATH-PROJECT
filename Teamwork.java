package wars; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "CS29";
        
        details[1] = "Rufai";
        details[2] = "Fawaz";
        details[3] = "22044575";

        details[4] = "Sugandhi";
        details[5] = " ";
        details[6] = "21076983";

        details[7] = "Lakshay ";
        details[8] = "Verma";
        details[9] = "20072966";


        details[10] = "Malwa";
        details[11] = "Yash";
        details[12] = "21092615";

	
	
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
