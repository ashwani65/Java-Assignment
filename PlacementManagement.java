import java.util.*;

class Candidate{
    String Name, RegNum, Branch;
    float CGPA;
    boolean Placed;
    public static Scanner obj = new Scanner(System.in);
    
    public Candidate(){
        System.out.println("Enter Candidate Name : ");
        this.Name = obj.nextLine();

        System.out.println("Enter Candidate Registration number : ");
        this.RegNum = obj.nextLine();

        System.out.println("Enter Branch : ");
        this.Branch = obj.nextLine();

        System.out.println("Enter CGPA : ");
        this.CGPA = Float.parseFloat(obj.nextLine());

        System.out.println("Is Placed (Yes/No) : ");
        String s = obj.nextLine();

        Placed = s.equals("Yes")? true : false;
    }
    public void ShowDetails(){
        System.out.println("Name : " + Name);
        System.out.println("Registration  : " + RegNum);
        System.out.println("Branch : " + Branch);
        System.out.println("CGPA : " + CGPA);
        System.out.println("Placed : " + ((Placed)? "Yes" : "No"));
    }
}

class PlacementManagement{

    static ArrayList<Candidate> candidates = new ArrayList<Candidate>();
    static int choice = 0;

    public static void main(String[] args){
        do {
            
            System.out.println("1. Add New Candidate");
            System.out.println("2. View Candidate List");
            System.out.println("3. Exit");

            choice = Integer.parseInt(Candidate.obj.nextLine());
            
            switch(choice){
                case 1: Candidate st = new Candidate();
                        candidates.add(st);
                        break;
                case 2: System.out.println("Enter Minimum CGPA");
                        float c = Float.parseFloat(Candidate.obj.nextLine());
                        System.out.println("Enter Branch ");
                        String sr = Candidate.obj.nextLine();
                        DisplayList(c, sr);
            }
        } while (choice != 3);
        Candidate.obj.close();
    }

    static void DisplayList(float CGPA, String Branch){
        
        for(Candidate candidate : candidates){
            
            if(!candidate.Placed && candidate.CGPA >=CGPA && candidate.Branch.equals(Branch))
                candidate.ShowDetails();  
            
            else{
                System.out.println("No Candidates are Eligible for this Drive ");
            }
        }
    }


}
