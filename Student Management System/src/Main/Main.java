import java.util.InputMismatchException;
import java.util.Scanner;
import Bean.Bean_class;
import DataInsertion.DataPassing;
class Main {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("------- STUDENT MANAGEMENT SYSTEM -------");
            System.out.println("|\t              \t\t\t|");
            System.out.println("|\t1.Import Data \t\t\t|");
            System.out.println("|\t2.Update Data \t\t\t|");
            System.out.println("|\t3.Delete Data \t\t\t|");
            System.out.println("|\t4.Display Data\t\t\t|");
            System.out.println("|\t5.Exit        \t\t\t|");
            System.out.println("|\t              \t\t\t|");
            System.out.println("-----------------------------------------");
            System.out.println();
            System.out.print("Enter your choice : ");
            int choice = 0;
            try{
                choice = s.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Please enter an integer as a choice");
                s.nextLine();
            }
            System.out.println();
            switch(choice){
                case 1 :
                    int num = 0;
                    System.out.print("Enter the number of data you wanna input : ");
                    try{
                        num = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter an integer!");
                    }
                    s.nextLine();
                    for(int i = 1;i<=num;i++){
                        System.out.println("Student "+i+" Details : ");
                        System.out.print("Name : ");
                        String name = s.nextLine();
                        System.out.print("Roll : ");
                        int roll = s.nextInt();
                        s.nextLine();
                        System.out.print("DOB : ");
                        String dob = s.nextLine();
                        Bean_class bc = new Bean_class();
                        bc.setName(name);
                        bc.setRoll(roll);
                        bc.setDob(dob);
                        int ans = DataPassing.enterdata(bc);
                        if(ans == 1)
                            System.out.println("Student "+i+" details stored successfully :)");
                        else
                            System.out.println("Error! Student "+i+" details not stored :(");
                    }
                    break;
                case 2:
                    System.out.print("Enter the roll no you wanna update : ");
                    int rollal = 0;
                    try{
                        rollal = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter an integer!");
                        s.nextLine();
                    }
                    System.out.println("What do you wanna update?\n1.Name\n2.Roll\n3.DOB");
                    System.out.print("Enter your choice : ");
                    int choice1 = 0;
                    try{
                        choice1 = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter an integer!");
                    }
                    s.nextLine();
                    switch(choice1){
                        case 1 :
                            System.out.print("Enter new name : ");
                            String newname = s.nextLine();
                            int ans1 = DataPassing.modifydata(1,rollal,newname);
                            if(ans1 == 1)
                                System.out.println("Modification successful :)");
                            else
                                System.out.println("Modification failed :(");
                            break;
                        case 2 :
                            System.out.print("Enter new roll : ");
                            String newroll = s.nextLine();
                            int ans2 = DataPassing.modifydata(2,rollal,newroll);
                            if(ans2 == 1)
                                System.out.println("Modification successful :)");
                            else
                                System.out.println("Modification failed :(");
                            break;
                        case 3 :
                            System.out.print("Enter new dob : ");
                            String newdob = s.nextLine();
                            int ans3 = DataPassing.modifydata(1,rollal,newdob);
                            if(ans3 == 1)
                                System.out.println("Modification successful :)");
                            else
                                System.out.println("Modification failed :(");
                            break;
                        default :
                            System.out.println("Invalid choice :|");
                    }
                    break;
                case 3 :
                    System.out.println("1.Delete one/few data\n2.Delete all data");
                    System.out.print("Enter your choice : ");
                    int choice2 = 0;
                    try{
                        choice2 = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter an integer!");
                        s.nextLine();
                    }
                    switch(choice2){
                        case 1:
                            System.out.println("1.Delete by name\n2.Delete by roll\n3.Delete by dob");
                            System.out.print("Enter your choice : ");
                            int choice3 = 0;
                            try{
                                choice3 = s.nextInt();
                            }
                            catch(InputMismatchException e){
                                System.out.println("Enter an integer!");
                            }
                            s.nextLine();
                            switch(choice3){
                                case 1 :
                                    System.out.print("Enter the name you wanna delete : ");
                                    String delname = s.nextLine();
                                    int ans4 = DataPassing.deletedata(1,delname);
                                    if(ans4 == 1)
                                        System.out.println("Deletion Done :)");
                                    else
                                        System.out.println("Deletion Failed :(");
                                    break;
                                case 3:
                                    System.out.print("Enter the dob you wanna delete : ");
                                    String deldob = s.nextLine();
                                    int ans5 = DataPassing.deletedata(2,deldob);
                                    if(ans5 == 1)    
                                        System.out.println("Deletion Done :)");
                                    else
                                        System.out.println("Deletion failed :(");
                                    break;
                                case 2 :
                                    System.out.print("Enter the roll you wanna delete the data : ");
                                    int rolldel = s.nextInt();
                                    int ans6 = DataPassing.deletedata(rolldel);
                                    if(ans6 == 1)
                                        System.out.println("Deletion Done :)");
                                    else
                                        System.out.println("Deletion failed :(");
                                    break;
                                default :
                                    System.out.println("Invalid Input");
                            }
                            break;
                        case 2 :
                            System.out.print("Are you sure? Y/N : ");
                            char a = s.next().charAt(0);
                            if((a == 'Y')||(a == 'y')){
                                int ans7 = DataPassing.deletedata();
                                if(ans7 == 1)
                                    System.out.println("Deletion Done :<");
                                else
                                    System.out.println("Deletion failed :(");
                            }
                            break;
                        default :
                            System.out.println("Invalid Input :|");
                    }
                    break;
                case 4:
                    System.out.println("1.Display data by roll\n2.Display all data");
                    System.out.print("Enter your choice : ");
                    int choice4 = 0;
                    try{
                        choice4 = s.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Enter an Integer bruh we spent a lotta time writing this damn code!");
                        s.nextLine();
                    }
                    switch(choice4){
                        case 1:
                            System.out.print("Enter the roll : ");
                            int rolldis = s.nextInt();
                            DataPassing.displayData(rolldis);
                            break;
                        case 2 :
                            DataPassing.displayData();
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("OK BYE");
                    return;
                default :
                    System.out.println("Invalid Input :|");
            }
        }
    }
}
