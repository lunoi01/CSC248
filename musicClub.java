import java.text.DecimalFormat;
public class musicClub
{
    private String name;
    private String studentID;
    private String courseCode;
    private int semester;
    private String instrument;
    private char gender;
    private double membershipFee;
    private boolean feeStatus;
    public musicClub(String n , String sID, String c, int se, String i,char g, double m,boolean f)
    {
        name = n;
        studentID = sID;
        courseCode = c;
        semester = se;
        instrument = i;
        gender = g;
        membershipFee = m;
        feeStatus = f;
    }
    public String getName() {return name;}
    public String getStudentID() {return studentID;}
    public String getCourseCode() { return courseCode;}
    public int getSemester() { return semester;}
    public String getInstrument() { return instrument;}
    public char getGender() { return gender; }
    public double getMembershipFee() {return membershipFee;}
    public boolean getFeeStatus() {return feeStatus;}
    public String toString(){
        DecimalFormat df=new DecimalFormat("0.00");
        String g = " ";
        if ( gender == 'm' )
        {
            g = "male";
        }
        
        else if ( gender == 'f')
        {
            g = "female";
        }
        return name +"\t" + studentID+ "\t" +courseCode +"\t\t "+ semester+ "\t\t" +instrument+ "\t\t " +g+ "\t\t " +"RM" +df.format(membershipFee)+ "\t " +feeStatus;
    }
}
    
    
        