import java.util.ListIterator;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;
import java.util.Scanner;
public class testmusicClub{
    public static void main (String [] args){
        Scanner scan=new Scanner(System.in);
        
        LinkedList musiclist = new LinkedList();
        LinkedList tempL = new LinkedList();
        
        Queue musicList=new Queue();
        Queue pianoList=new Queue();
        Queue guitarList=new Queue();
        Queue drumList=new Queue();
        Queue temp=new Queue();
        Queue unpaidList=new Queue();
        
        String name, studentID, courseCode, instrument;
        int semester; char gender; double membershipFee; boolean feeStatus;
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("musicClub.txt"));
            String data = null;
            while((data = br.readLine()) != null)
            {

                StringTokenizer st = new StringTokenizer(data, ";");
                name = st.nextToken();
                studentID = st.nextToken();
                courseCode = st.nextToken();
                semester = Integer.parseInt(st.nextToken());
                instrument=st.nextToken();
                gender=st.nextToken().charAt(0);
                membershipFee=Double.parseDouble(st.nextToken());
                feeStatus=Boolean.parseBoolean(st.nextToken());
                
                musicClub datamusicclub=new musicClub(name,studentID,courseCode,semester,instrument,gender,membershipFee,feeStatus);
                musiclist.insertAtBack(datamusicclub);
            }
            br.close();
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
        {System.err.println(ex.getMessage());}
        }
        //1.count and display the number of male and female students who join music club (linkedList)
        int countm=0,countf=0;
        musicClub mC  = (musicClub) musiclist.getHead();
        while(mC!= null)
        {
            if(mC.getGender()=='M'||mC.getGender()=='m')
            {
                countm++;
            }
            else if(mC.getGender()=='F'||mC.getGender()=='f')
            {
                countf++;
            }
            mC = (musicClub)musiclist.getNext();
        }
        System.out.println("Number of male students who join Music Club:"+countm);
        System.out.println("Number of female students who join Music Club:"+countf);
        
        //2.count and display the total of students who join music club (linkedList)
        System.out.println("Total of students who join music club:"+musiclist.size());
        
        //proving
        System.out.println("\nBEFORE STUDENTS' DETAILS ARE COPIED TO pianoList,guitarList and drumList:");
        
        System.out.println("\nmusiclist");
        System.out.println("---------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        musicClub ll=(musicClub)musiclist.getHead();
        while(ll!=null)
        {
            musiclist.display(ll);
            break;
        }
        
        System.out.println("\npianoList");
        System.out.println("---------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!pianoList.isEmpty())
        {
            musicClub pianodata=(musicClub)pianoList.dequeue();
            System.out.println(pianodata.toString());
        }        
        System.out.println("\nguitarList");
        System.out.println("----------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!guitarList.isEmpty())
        {
            musicClub guitardata=(musicClub)guitarList.dequeue();
            System.out.println(guitardata.toString());
        }
        System.out.println("\ndrumList");
        System.out.println("--------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!drumList.isEmpty())
        {
            musicClub drumdata=(musicClub)drumList.dequeue();
            System.out.println(drumdata.toString());
        }
        
        //3.Copy student details from musiclist into pianoList,guitarList and drumList according to  the type of instrument (linkedList to Queue)
        System.out.println("\n\n\nAFTER STUDENTS' DETAILS ARE COPIED TO pianoList,guitarList and drumList:");
        
        System.out.println("\nmusiclist");
        System.out.println("---------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        musicClub ll2=(musicClub)musiclist.getHead();
        while(ll2!=null)
        {
            musiclist.display(ll2);
            break;
        }
        
        musicClub muC  = (musicClub) musiclist.getHead();
        while(muC!=null)
        {
            if(muC.getInstrument().equalsIgnoreCase("piano"))
            {
                pianoList.enqueue(muC);
            }
            else if(muC.getInstrument().equalsIgnoreCase("guitar"))
            {
                guitarList.enqueue(muC);
            }
            else if(muC.getInstrument().equalsIgnoreCase("drum"))
            {
                drumList.enqueue(muC);
            }
            muC = (musicClub)musiclist.getNext();
        }
        
        System.out.println("\npianoList");
        System.out.println("---------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!pianoList.isEmpty())
        {
            musicClub pianodata=(musicClub)pianoList.dequeue();
            System.out.println(pianodata.toString());
        }
        System.out.println("\nguitarList");
        System.out.println("----------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!guitarList.isEmpty())
        {
            musicClub guitardata=(musicClub)guitarList.dequeue();
            System.out.println(guitardata.toString());
        }
        System.out.println("\ndrumList");
        System.out.println("--------");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        while(!drumList.isEmpty())
        {
            musicClub drumdata=(musicClub)drumList.dequeue();
            System.out.println(drumdata.toString());
        }
        
        //4.calculate the membership fees made by all the music club students(LinkedList)
        double calculate=0.0;
        DecimalFormat df=new DecimalFormat("0.00");
        musicClub dataofmusic=(musicClub)musiclist.getHead();
        while(dataofmusic!=null)
        {
           calculate+=dataofmusic.getMembershipFee();
           dataofmusic=(musicClub)musiclist.getNext();
        }
        System.out.println("\n\nMembership fees made by all music club students:RM"+df.format(calculate));
        //5.remove all students who do not pay for the membership fee into a queue named unpaidList
        System.out.println("\nStudents who do not pay for music club membership fee:");
        System.out.println("\t\tName\t\t\tMatric Number \tCourse Code \tSemester\tInstrument\tGender\t\t  Fee\t\tFee Status");
        System.out.println(  "\t\t----\t\t\t------------- \t----------- \t--------\t----------\t------\t\t  ---\t\t----------");
        
        musicClub buang =(musicClub)musiclist.getHead();
        while(buang!= null)
        {
            if(buang.getFeeStatus()==false)
            {
                unpaidList.enqueue(buang);
                System.out.println(buang.toString());
                musicClub remove = (musicClub)musiclist.removeFromBack();
            }
            buang = (musicClub)musiclist.getNext();
        }
        
        //System.out.print("Test");
        //while(!musicList.isEmpty())
        //{
            //Object
            
        //6.prompt user to enter student matrix id and display the student's details

        musicClub data=(musicClub)musiclist.getHead();
        while(data!=null)
        {
            musicList.enqueue(data);
            data=(musicClub)musiclist.getNext();
        }
        
        System.out.println("\n\nEnter student ID for student's details on music club:");
        studentID=scan.next();
        boolean found=false; boolean notFound = true; String s = "";
        musicClub d = (musicClub) musiclist.getHead();
        Object searching=musiclist.getHead();
        while(d!=null)
        {
            musicClub search = (musicClub) searching;
            if(search.getStudentID().equalsIgnoreCase(studentID))
            {
                found=true;
                System.out.println(search.toString());
                s = "THE STUDENT IS FOUND";
                break;
            }  
            if(!search.getStudentID().equalsIgnoreCase(studentID))
            {
                s = "NOT FOUND";
            }
            d=(musicClub)musiclist.getNext();
            searching = (musicClub) musiclist.getNext();
        }
        System.out.println(s);
    }
}