/*Here are the changes made:

Fixed the import statements.
Corrected the main method's parameter declaration from public static void main(Strings[] args) to public static void main(String[] args).
Corrected the array declaration from int Associate[] ass = int Associate[5]; to Associate[] ass = new Associate[5];.
Corrected the data type for String from string in both the Associate class and the main method.
Fixed the missing semicolons in various places.
Corrected the getExp method in the Associate class from getExp(int exp) to setExp(int exp) for setting the exp field. */
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Associate[] ass = new Associate[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; ++i) {
            ass[i] = new Associate(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
        }
        String searchTech = sc.next();
        sc.close();
        Associate[] result = method1(ass, searchTech);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getId());
        }
    }

    public static Associate[] method1(Associate[] ass, String searchTech) {
        Associate[] arr1 = new Associate[0];
        for (int i = 0; i < ass.length; i++) {
            if (ass[i].getTech().equals(searchTech) && ass[i].getExp() % 5 == 0) {
                arr1 = Arrays.copyOf(arr1, arr1.length + 1);
                arr1[arr1.length - 1] = ass[i];
            }
        }
        return arr1;
    }
}

class Associate {
    private int id;
    private int exp;
    private String name;
    private String tech;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Associate(int id, String name, String tech, int exp) {
        this.id = id;
        this.name = name;
        this.tech = tech;
        this.exp = exp;
    }
}
