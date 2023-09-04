import java.util.Scanner;
class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        AutonomousCar [] car= new AutonomousCar[4];
        for(int i=0;i<car.length;i++)
        {
           int carId = sc.nextInt();
           String brand=sc.next();
           int tests=sc.nextInt();
           int passed=sc.nextInt();
           String env=sc.next();
           car[i]=new AutonomousCar(carId,brand,tests,passed,env);
        }
        String in_env= sc.next();
        int res1= method1(car,in_env);
        if (res1==0)
        {
            System.out.println("No results found");
        }
        else{
            System.out.println(res1);
        }
        String in_brand=sc.next();
        
        AutonomousCar res2= method2(car,in_brand);

        if(res2==null)
        {
            System.out.println("No cars availabe");
        }
        else{
            System.out.println(res2.getBrand()+"::"+res2.getGrade());
        }


    }
    public static int method1(AutonomousCar [] car,String in_env){
        int sum=0;
        for(int i=0;i<car.length;i++)
        {
           if(car[i].getEnv().equals(in_env)){
              sum+=car[i].getPassed();
           }
        }
        return sum;
    }
    public static  AutonomousCar method2(AutonomousCar [] car,String in_brand){
        int rating;
        for(int i=0;i<car.length;i++)
        {
            if(in_brand.equals(car[i].getBrand())){
                rating=(car[i].getPassed()*100)/car[i].getTests();
               if(rating>=80)
               {
                   car[i].setGrade("A1");
               }
               else
               {
                   car[i].setGrade("B2");
               }
               return car[i];
            }
        }
        return null;
    }
}

class AutonomousCar{
    int carId;
    String brand;
    int tests;
    int passed;
    String env;
    String grade;
    AutonomousCar(int carId,String brand,int tests,int passed,String env){
        this.carId=carId;
        this.brand=brand;
        this.tests=tests;
        this.passed=passed;
        this.env=env;
        
    }
    int getCarId(){
        return carId;
    }
    String getBrand(){
        return brand;
    }
    int getTests(){
        return tests;
    }
    int getPassed(){
        return passed;
    }
    String getEnv(){
        return env;
    }
    void setGrade(String grade){
        this.grade=grade;
    }
    String getGrade(){
        return grade;
    }
    
    
}


/*100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez*/
