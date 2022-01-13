import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class Final_Project {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException {

        ArrayList<Plane_Crash> plane_crash_list = new ArrayList<>();
        ArrayList<Plane_Crash> updated_plane_crash_list = new ArrayList<>();

        try (FileReader fr = new FileReader("Large_Passenger_Plane_Crashes_1933_to_2009.csv");
                BufferedReader br = new BufferedReader(fr)) {
            String line = null, tokens[];
            int i = 0;

            while ((line = br.readLine()) != null) {
                i++;
                if (i == 1)
                    continue;
                tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Plane_Crash a = new Plane_Crash(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],
                        tokens[6], tokens[7], tokens[8], tokens[9], tokens[10], tokens[11], tokens[12], tokens[13],
                        tokens[14], tokens[15]);
                plane_crash_list.add(a);
            }

        } catch (Exception e) {
            System.out.println("Error in opening file!");
        }

        System.out.println(">>_Welcome to Information Center about Plane Crashes_<<");
        System.out.println("*******************************************************");
        System.out.println(
                "\t>1: to list records\n\t>2: to sort records\n\t>3: to search records\n\t>4: to print column names\n\t>5: to filter\n\tE: to exit");

        String button;

        while ((button = scan.nextLine()) != null) {
            switch (button) {
                case "1":
                    List_Records(plane_crash_list);
                    break;
                case "2":
                    Sort_Records(plane_crash_list);
                    break;
                case "3":
                    updated_plane_crash_list = Search_Records(plane_crash_list);
                    List_Records(updated_plane_crash_list);
                    break;
                case "E":
                    return;
                case "4":
                    Print_Column_Names();
                    break;
                case "5":
                    updated_plane_crash_list = Filter_Records(plane_crash_list);
                    List_Records(updated_plane_crash_list);
                    break;
                default:
                    System.out.println("Unvalid operation!");
            }

            System.out.println(">>_Welcome to Information Center about Plane Crashes_<<");
            System.out.println("*******************************************************");
            System.out.println(
                    "\t>1: to list records\n\t>2: to sort records\n\t>3: to search records\n\t>4: to print column names\n\t>5: to filter\n\tE: to exit");

        }
    }

    public static void List_Records(ArrayList<Plane_Crash> plane_crash_list) {
        System.out.println(
                "\t\t>a: to list all of recods\n\t\t>b: to list in range\n\t\t>c: to list based on any selected field");
        String sub_button = scan.nextLine();
        switch (sub_button) {
            case "a":
                for (Plane_Crash o : plane_crash_list) {
                    System.out.println(o.toString());
                }
                System.out.println("Total number of records: " + plane_crash_list.size());
                break;
            case "b":
                System.out.print("Enter lower and upper bounders respectively: ");
                int start_point = scan.nextInt();
                int end_point = scan.nextInt();
                scan.nextLine();
                for (int i = start_point; i < end_point; i++) {
                    System.out.println(plane_crash_list.get(i).toString());
                }
                System.out.println("Total number of records: " + (end_point - start_point));
                break;
            case "c":
                System.out.print("Enter the field names to list: ");
                String input_for_list = scan.nextLine();
                for (int i = 0; i < plane_crash_list.size(); i++) {
                    System.out.print("[ ");
                    if (input_for_list.contains("Date")) {
                        System.out.print("Date: " + plane_crash_list.get(i).getDate() + ", ");
                    }
                    if (input_for_list.contains("Time")) {
                        System.out.print("Time: " + plane_crash_list.get(i).getTime() + ", ");
                    }
                    if (input_for_list.contains("Location")) {
                        System.out.print("Location: " + plane_crash_list.get(i).getLocation() + ", ");
                    }
                    if (input_for_list.contains("Operator")) {
                        System.out.print("Operator: " + plane_crash_list.get(i).getOperator() + ", ");
                    }
                    if (input_for_list.contains("Flight")) {
                        System.out.print("Flight: " + plane_crash_list.get(i).getFlight() + ", ");
                    }
                    if (input_for_list.contains("Route")) {
                        System.out.print("Route: " + plane_crash_list.get(i).getRoute() + ", ");
                    }
                    if (input_for_list.contains("Type")) {
                        System.out.print("Type: " + plane_crash_list.get(i).getType() + ", ");
                    }
                    if (input_for_list.contains("Registration")) {
                        System.out.print("Registration: " + plane_crash_list.get(i).getRegistration() + ", ");
                    }
                    if (input_for_list.contains("Cn_In")) {
                        System.out.print("Cn_In: " + plane_crash_list.get(i).getCn_In() + ", ");
                    }
                    if (input_for_list.contains("Aboard")) {
                        System.out.print("Aboard: " + plane_crash_list.get(i).getAboard() + ", ");
                    }
                    if (input_for_list.contains("Fatalities")) {
                        System.out.print("Fatalities: " + plane_crash_list.get(i).getFatalities() + ", ");
                    }
                    if (input_for_list.contains("Ground")) {
                        System.out.print("Ground: " + plane_crash_list.get(i).getGround() + ", ");
                    }
                    if (input_for_list.contains("Survivors")) {
                        System.out.print("Survivors: " + plane_crash_list.get(i).getSurvivors() + ", ");
                    }
                    if (input_for_list.contains("SurvivalRate")) {
                        System.out.print("SurvivalRate: " + plane_crash_list.get(i).getSurvivalRate() + ", ");
                    }
                    if (input_for_list.contains("Summary")) {
                        System.out.print("Summary: " + plane_crash_list.get(i).getSummary() + ", ");
                    }
                    if (input_for_list.contains("ClustID")) {
                        System.out.print("ClustID: " + plane_crash_list.get(i).getClustID() + ", ");
                    }
                    System.out.println(" ]");
                }
                System.out.println("Total number of records: " + plane_crash_list.size());
                break;
            default:
                System.out.println("Invalid operation!");
        }
    }

    public static void Sort_Records(ArrayList<Plane_Crash> plane_crash_list) {
        System.out.println(
                "\t\t>a: to sort based on date\n\t\t>b: to sort based on time\n\t\t>c: to sort based on Location\n\t\t>d: to sort based on Operator\n\t\t>e: to sort based on Flight\n\t\t>f: to sort based on Route\n\t\t>h: to sort based on Type\n\t\t>g: to sort based on Registration\n\t\t>n: to sort based on cn.In\n\t\t>m: to sort based on Abroad\n\t\t>l: to sort based on Fatalities\n\t\t>y: to sort based on Ground\n\t\t>x: to sort based on Survivors\n\t\t>w: to sort based of Survival Rate\n\t\t>t: to sort based on Summary\n\t\t>u: to sort based on Clust ID\n");

        String sub_button = scan.nextLine();

        switch (sub_button) {
            case "a":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int dif_1 = a.getFirstDate() - b.getFirstDate();
                            int dif_2 = a.getSecondDate() - b.getSecondDate();
                            int dif_3 = a.getThirdDate() - b.getThirdDate();

                            if (dif_3 != 0)
                                return dif_3;
                            else if (dif_1 != 0)
                                return dif_1;
                            else
                                return dif_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int dif_1 = b.getFirstDate() - a.getFirstDate();
                            int dif_2 = b.getSecondDate() - a.getSecondDate();
                            int dif_3 = b.getThirdDate() - a.getThirdDate();

                            if (dif_3 != 0)
                                return dif_3;
                            else if (dif_1 != 0)
                                return dif_1;
                            else
                                return dif_2;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "b":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_2 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_2)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int dif_1 = a.getFirstTime() - b.getFirstTime();
                            int dif_2 = a.getSecondTime() - b.getSecondTime();

                            if (dif_1 != 0)
                                return dif_1;
                            else
                                return dif_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_2)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int dif_1 = b.getFirstTime() - a.getFirstTime();
                            int dif_2 = b.getSecondTime() - a.getSecondTime();

                            if (dif_1 != 0)
                                return dif_1;
                            else
                                return dif_2;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "c":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_3 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_3)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getLocation();
                            String str_2 = b.getLocation();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_3)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getLocation();
                            String str_2 = b.getLocation();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "d":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_4 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_4)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getOperator();
                            String str_2 = b.getOperator();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_4)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getOperator();
                            String str_2 = b.getOperator();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "e":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_5 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_5)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getFlight();
                            String str_2 = b.getFlight();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_5)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getFlight();
                            String str_2 = b.getFlight();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "f":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_6 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_6)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getRoute();
                            String str_2 = b.getRoute();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_6)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getRoute();
                            String str_2 = b.getRoute();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "h":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_7 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_7)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getType();
                            String str_2 = b.getType();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_7)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getType();
                            String str_2 = b.getType();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "g":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_8 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_8)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getRegistration();
                            String str_2 = b.getRegistration();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_8)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getRegistration();
                            String str_2 = b.getRegistration();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "n":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_9 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_9)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getCn_In();
                            String str_2 = b.getCn_In();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_9)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getCn_In();
                            String str_2 = b.getCn_In();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "m":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_10 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_10)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getAboard());
                            int x_2 = Integer.valueOf(b.getAboard());
                            return x_1 - x_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_10)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getAboard());
                            int x_2 = Integer.valueOf(b.getAboard());
                            return x_2 - x_1;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "l":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_11 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_11)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getFatalities());
                            int x_2 = Integer.valueOf(b.getFatalities());
                            return x_1 - x_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_11)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getFatalities());
                            int x_2 = Integer.valueOf(b.getFatalities());
                            return x_2 - x_1;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "y":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_12 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_12)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getGround());
                            int x_2 = Integer.valueOf(b.getGround());
                            return x_1 - x_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_12)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getGround());
                            int x_2 = Integer.valueOf(b.getGround());
                            return x_2 - x_1;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "x":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_13 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_13)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getSurvivors());
                            int x_2 = Integer.valueOf(b.getSurvivors());
                            return x_1 - x_2;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_13)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            int x_1 = Integer.valueOf(a.getSurvivors());
                            int x_2 = Integer.valueOf(b.getSurvivors());
                            return x_2 - x_1;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "w":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_14 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_14)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            double x_1 = Double.valueOf(a.getSurvivalRate());
                            double x_2 = Double.valueOf(b.getSurvivalRate());
                            if (x_1 - x_2 > 0.0)
                                return 1;
                            return -1;
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_14)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            double x_1 = Double.valueOf(a.getSurvivalRate());
                            double x_2 = Double.valueOf(b.getSurvivalRate());
                            if (x_2 - x_1 > 0.0)
                                return 1;
                            return -1;
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "t":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_15 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_15)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getSummary();
                            String str_2 = b.getSummary();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_15)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getSummary();
                            String str_2 = b.getSummary();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            case "u":
                System.out.println("Would you like to sort in DESC or ASC order?\n\t(Type as 'ASC' or 'DESC')");
                String sub_sub_button_16 = scan.nextLine();
                if ("ASC".equalsIgnoreCase(sub_sub_button_16)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getClustID();
                            String str_2 = b.getClustID();
                            return str_2.compareTo(str_1);
                        }
                    });
                } else if ("DESC".equalsIgnoreCase(sub_sub_button_16)) {
                    Collections.sort(plane_crash_list, new Comparator<Plane_Crash>() {
                        public int compare(Plane_Crash a, Plane_Crash b) {
                            String str_1 = a.getClustID();
                            String str_2 = b.getClustID();
                            return str_1.compareTo(str_2);
                        }
                    });
                } else
                    System.out.println("Invalid operation!");
                break;
            default:
                System.out.println("Invalid operation!");
        }
    }

    public static void Print_Column_Names() {
        try (FileReader fr_3 = new FileReader("Large_Passenger_Plane_Crashes_1933_to_2009.csv");
                BufferedReader br_3 = new BufferedReader(fr_3)) {
            String line = br_3.readLine();
            String[] names;
            names = line.split(",");

            System.out.println("[ " + (names[0] + ", " + names[1] + ", " + names[2] + ", " + names[3] + ", " + names[4]
                    + ", " + names[5] + ", " + names[6] + ", " + names[7] + ", " + names[8] + ", " + names[9] + ", "
                    + names[10] + ", " + names[11] + ", " + names[12] + ", " + names[13] + ", " + names[14] + ", "
                    + names[15]) + " ]");
        } catch (Exception e) {
            System.out.println("Error in opening file!");
        }
    }

    public static ArrayList<Plane_Crash> Search_Records(ArrayList<Plane_Crash> plane_crash_list) throws IOException {
        ArrayList<Plane_Crash> selected_recods = new ArrayList<>();
        System.out.print(
                "FOR STRING FIELDS -> Enter parameters WITH adding field names with contains string (Example: Operator: Military - U)\nFOR NON-STRING FIELDS Enter the exact values (Example: Time: 23:10)\n\t> ");
        String input = scan.nextLine();
        if (input.contains("Location") || input.contains("Operator") || input.contains("Flight")
                || input.contains("Route") || input.contains("Type") || input.contains("Registration")
                || input.contains("cn_In") || input.contains("Summary") || input.contains("ClustID")) {
            for (int i = 0; i < plane_crash_list.size(); i++) {
                if (plane_crash_list.get(i).toString().contains(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
            }
            if (selected_recods.size() != 0) {
                System.out.println("Would you like to store this data in 'selected_records.csv' file?");
                System.out.print("Type YES/NO: ");
                String ans = scan.nextLine();
                if (ans.equalsIgnoreCase("YES")) {
                    try (FileWriter fw = new FileWriter("selected_records.csv")) {
                        for (int i = 0; i < selected_recods.size(); i++) {
                            fw.write(selected_recods.get(i).toString() + '\n');
                        }
                        System.out.println("Successfully written!");
                    } catch (Exception e) {
                        System.out.println("Error!");
                    }
                }
            } else
                System.out.println("Unfortunately, nothing is found.");
        } else if (input.contains("Date") || input.contains("Time") || input.contains("Aboard")
                || input.contains("Fatalities") || input.contains("Ground") || input.contains("Survivors")
                || input.contains("Surviral Rate")) {
            for (int i = 0; i < plane_crash_list.size(); i++) {// aboard, fatalities, ground, survivors, survival rate
                if (input.contains("Date") && ("Date: " + plane_crash_list.get(i).getDate()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Time") && ("Time: " + plane_crash_list.get(i).getTime()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Aboard") && ("Aboard: " + plane_crash_list.get(i).getAboard()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Fatalities")
                        && ("Fatalities: " + plane_crash_list.get(i).getFatalities()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Ground") && ("Ground: " + plane_crash_list.get(i).getGround()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Survivors")
                        && ("Survivors: " + plane_crash_list.get(i).getSurvivors()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
                if (input.contains("Survival Rate")
                        && ("Survival Rate: " + plane_crash_list.get(i).getSurvivalRate()).equals(input)) {
                    selected_recods.add(plane_crash_list.get(i));
                }
            }
            if (selected_recods.size() != 0) {
                System.out.println("Would you like to store this data in 'selected_records.csv' file?");
                System.out.print("Type YES/NO: ");
                String ans = scan.nextLine();
                if (ans.equalsIgnoreCase("YES")) {
                    try (FileWriter fw = new FileWriter("selected_records.csv")) {
                        for (int i = 0; i < selected_recods.size(); i++) {
                            fw.write(selected_recods.get(i).toString() + '\n');
                        }
                        System.out.println("Successfully written!");
                    } catch (Exception e) {
                        System.out.println("Error!");
                    }
                }
            } else
                System.out.println("Unfortunately, nothing is found.");
        }

        return selected_recods;
    }

    public static ArrayList<Plane_Crash> Filter_Records(ArrayList<Plane_Crash> plane_crash_list)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        System.out.println("Based on how many fields would you like to filter?");
        int nb_of_entities = scan.nextInt();
        scan.nextLine();

        ArrayList<Plane_Crash> updated_list = new ArrayList<>(plane_crash_list);

        for (int i = 0; i < nb_of_entities; i++) {
            System.out.print("Enter field name: ");
            String filter_parameter = scan.nextLine();
            try {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);

                if (privateField.getName().equals(filter_parameter) && privateField.getName().equals("Location")
                        || privateField.getName().equals("Operator") || privateField.getName().equals("Flight")
                        || privateField.getName().equals("Route") || privateField.getName().equals("Type")
                        || privateField.getName().equals("Registration") || privateField.getName().equals("cn_In")
                        || privateField.getName().equals("Summary") || privateField.getName().equals("ClustID")) {
                    updated_list = Filter_String_Fields(updated_list, filter_parameter);
                } else if (privateField.getName().equals(filter_parameter) && privateField.getName().equals("Aboard")
                        || privateField.getName().equals("Fatalities") || privateField.getName().equals("Survivors")) {
                    updated_list = Filter_Numeric_Fields(updated_list, filter_parameter);
                } else if (privateField.getName().equals(filter_parameter) && privateField.getName().equals("Time")) {
                    updated_list = Filter_Time(updated_list, filter_parameter);
                } else if (privateField.getName().equals(filter_parameter) && privateField.getName().equals("Date")) {
                    updated_list = Filter_Date(updated_list, filter_parameter);
                } else if (privateField.getName().equals(filter_parameter)
                        && privateField.getName().equals("SurvivalRate")) {
                    updated_list = Filter_Double_Field(updated_list, filter_parameter);
                } else
                    System.out.println("Invalid Field Name is used!");
            } catch (Exception e) {
                System.out.println(
                        "There is no such field name!\nSince nothing is filtered if you store this date, the whole file will be saved");
            }
        }
        if (updated_list.size() != 0) {
            System.out.println("Would you like to store this data in 'selected_records_2.csv' file?");
            System.out.print("Type YES/NO: ");
            String ans = scan.nextLine();
            if (ans.equalsIgnoreCase("YES")) {
                try (FileWriter fw = new FileWriter("selected_records_2.csv")) {
                    for (int i = 0; i < updated_list.size(); i++) {
                        fw.write(updated_list.get(i).toString() + '\n');
                    }
                    System.out.println("Successfully written!");
                } catch (Exception e) {
                    System.out.println("Error!");
                }
            }
        } else
            System.out.println("Unfortunately, nothing is found.");

        return updated_list;
    }

    public static ArrayList<Plane_Crash> Filter_String_Fields(ArrayList<Plane_Crash> copy_list, String filter_parameter)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Plane_Crash> return_statement = new ArrayList<>();
        System.out.println(
                "\n\tType 1 to search 'starts with'\n\tType 2 to search 'ends with'\n\tType 3 to search 'contains'\n\tType 4 to search 'null'");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.println("Enter the starting of {name} structure:");
            String ending = scan.nextLine();
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.startsWith(ending)) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the ending of {name} structure:");
            String ending = scan.nextLine();
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.endsWith(ending)) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 3) {
            System.out.println("Enter the part of (contains) {name} structure:");
            String ending = scan.nextLine();
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.contains(ending)) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 4) {
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.length() == 0) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else
            System.out.println("Invalid operation");

        return return_statement;
    }

    public static ArrayList<Plane_Crash> Filter_Numeric_Fields(ArrayList<Plane_Crash> copy_list,
            String filter_parameter)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Plane_Crash> return_statement = new ArrayList<>();
        System.out.println(
                "\n\tType 1 to search 'equalTo'\n\tType 2 to search 'grater than'\n\tType 3 to search 'less than'\n\tType 4 to search 'grater and equal to'\n\tType 5 to search 'less and equal to'\n\tType 6 to search 'between the range'\n\tType 7 to search 'null'");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.println("Enter the equal value that you want to filter:");
            String ending = scan.nextLine();
            int ans = Integer.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num == ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the value that you want to filter grater than:");
            String ending = scan.nextLine();
            int ans = Integer.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num > ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 3) {
            System.out.println("Enter the value that you want to filter less than:");
            String ending = scan.nextLine();
            int ans = Integer.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num < ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 4) {
            System.out.println("Enter the value that you want to filter grater than or equal to:");
            String ending = scan.nextLine();
            int ans = Integer.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num >= ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 5) {
            System.out.println("Enter the value that you want to filter less than or equal to:");
            String ending = scan.nextLine();
            int ans = Integer.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num <= ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 6) {
            System.out.println("Enter the low boundary of the range:");
            int low_boundary = scan.nextInt();
            System.out.println("Enter the high boundary of the range:");
            int high_boundary = scan.nextInt();
            scan.nextLine();
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_num = Integer.valueOf(name);
                if (name_num < high_boundary && name_num > low_boundary) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 7) {
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.length() == 0) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else
            System.out.println("Invalid operation!");
        return return_statement;
    }

    public static ArrayList<Plane_Crash> Filter_Double_Field(ArrayList<Plane_Crash> copy_list, String filter_parameter)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Plane_Crash> return_statement = new ArrayList<>();
        System.out.println(
                "\n\tType 1 to search 'equalTo'\n\tType 2 to search 'grater than'\n\tType 3 to search 'less than'\n\tType 4 to search 'grater and equal to'\n\tType 5 to search 'less and equal to'\n\tType 6 to search 'between the range'\n\tType 7 to search 'null'");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.println("Enter the equal value that you want to filter:");
            String ending = scan.nextLine();
            double ans = Double.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num == ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the value that you want to filter grater than:");
            String ending = scan.nextLine();
            double ans = Double.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num > ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 3) {
            System.out.println("Enter the value that you want to filter less than:");
            String ending = scan.nextLine();
            double ans = Double.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num < ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 4) {
            System.out.println("Enter the value that you want to filter grater than or equal to:");
            String ending = scan.nextLine();
            double ans = Double.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num >= ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 5) {
            System.out.println("Enter the value that you want to filter less than or equal to:");
            String ending = scan.nextLine();
            double ans = Double.valueOf(ending);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num <= ans) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 6) {
            System.out.println("Enter the low boundary of the range:");
            double low_boundary = scan.nextDouble();
            System.out.println("Enter the high boundary of the range:");
            double high_boundary = scan.nextDouble();
            scan.nextLine();
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                double name_num = Double.valueOf(name);
                if (name_num < high_boundary && name_num > low_boundary) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 7) {
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.length() == 0) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else
            System.out.println("Invalid Operation!");
        return return_statement;
    }

    public static ArrayList<Plane_Crash> Filter_Time(ArrayList<Plane_Crash> copy_list, String filter_parameter)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Plane_Crash> return_statement = new ArrayList<>();
        System.out.println(
                "\n\tType 1 to search 'equalTo'\n\tType 2 to search 'grater than'\n\tType 3 to search 'less than'\n\tType 4 to search 'grater and equal to'\n\tType 5 to search 'less and equal to'\n\tType 6 to search 'between the range'\n\tType 7 to search 'null'");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.println("Enter the equal value that you want to filter:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int first_time = Integer.valueOf(arr_1[0]);
            int second_time = Integer.valueOf(arr_1[1]);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                if (name_first_time == first_time && name_second_time == second_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the time value that you want to filter GRATER THAN:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int first_time = Integer.valueOf(arr_1[0]);
            int second_time = Integer.valueOf(arr_1[1]);
            int total_time = first_time * 60 + second_time;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                int name_total_time = name_first_time * 60 + name_second_time;
                if (total_time < name_total_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 3) {
            System.out.println("Enter the time value that you want to filter LESS THAN:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int first_time = Integer.valueOf(arr_1[0]);
            int second_time = Integer.valueOf(arr_1[1]);
            int total_time = first_time * 60 + second_time;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                int name_total_time = name_first_time * 60 + name_second_time;
                if (total_time > name_total_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 4) {
            System.out
                    .println("Enter the time value that you want to filter GRATER THAN OR EQUAL TO:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int first_time = Integer.valueOf(arr_1[0]);
            int second_time = Integer.valueOf(arr_1[1]);
            int total_time = first_time * 60 + second_time;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                int name_total_time = name_first_time * 60 + name_second_time;
                if (total_time <= name_total_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 5) {
            System.out.println("Enter the time value that you want to filter LESS THAN OR EQUAL TO:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int first_time = Integer.valueOf(arr_1[0]);
            int second_time = Integer.valueOf(arr_1[1]);
            int total_time = first_time * 60 + second_time;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                int name_total_time = name_first_time * 60 + name_second_time;
                if (total_time >= name_total_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 6) {
            System.out.println("Enter the low boundary of time filter:\n(Example: 12:03)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split(":");
            int low_first_time = Integer.valueOf(arr_1[0]);
            int low_second_time = Integer.valueOf(arr_1[1]);
            int low_total_time = low_first_time * 60 + low_second_time;
            System.out.println("Enter the high boundary of time filter:\n(Example: 12:03)");
            String ending_2 = scan.nextLine();
            String[] arr_1_ = ending_2.split(":");
            int high_first_time = Integer.valueOf(arr_1_[0]);
            int high_second_time = Integer.valueOf(arr_1_[1]);
            int high_total_time = high_first_time * 60 + high_second_time;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_time;
                int name_second_time;
                if (!name.equals("")) {
                    String[] arr_2 = name.split(":");
                    name_first_time = Integer.valueOf(arr_2[0]);
                    name_second_time = Integer.valueOf(arr_2[1]);
                } else {
                    name_first_time = 0; // default value for hour
                    name_second_time = 0; // default value for minute
                }
                int name_total_time = name_first_time * 60 + name_second_time;
                if (name_total_time > low_total_time && name_total_time < high_total_time) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 7) {
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.length() == 0) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else
            System.out.println("Invalid Operation!");
        return return_statement;
    }

    public static ArrayList<Plane_Crash> Filter_Date(ArrayList<Plane_Crash> copy_list, String filter_parameter)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Plane_Crash> return_statement = new ArrayList<>();
        System.out.println(
                "\n\tType 1 to search 'equalTo'\n\tType 2 to search 'grater than'\n\tType 3 to search 'less than'\n\tType 4 to search 'grater and equal to'\n\tType 5 to search 'less and equal to'\n\tType 6 to search 'between the range'\n\tType 7 to search 'null'\n\tType 8 to search 'specific year'\n\tType 9 to search 'specific month'\n\tType 10 to search 'specific day'");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            System.out.println("Enter the equal value that you want to filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int first_date = Integer.valueOf(arr_1[0]);
            int second_date = Integer.valueOf(arr_1[1]);
            int third_date = Integer.valueOf(arr_1[2]);
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                if (name_first_date == first_date && name_second_date == second_date && name_third_date == third_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 2) {
            System.out.println("Enter the value that you want date to be GRATER THAN filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int first_date = Integer.valueOf(arr_1[0]);
            int second_date = Integer.valueOf(arr_1[1]);
            int third_date = Integer.valueOf(arr_1[2]);
            int total_date = third_date * 365 + first_date * 31 + second_date;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                int name_total_date = name_third_date * 365 + name_first_date * 31 + name_second_date;
                if (name_total_date > total_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 3) {
            System.out.println("Enter the value that you want date to be LESS THAN filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int first_date = Integer.valueOf(arr_1[0]);
            int second_date = Integer.valueOf(arr_1[1]);
            int third_date = Integer.valueOf(arr_1[2]);
            int total_date = third_date * 365 + first_date * 31 + second_date;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                int name_total_date = name_third_date * 365 + name_first_date * 31 + name_second_date;
                if (name_total_date < total_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 4) {
            System.out.println(
                    "Enter the value that you want date to be GRATER THAN OR EQUAL TO filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int first_date = Integer.valueOf(arr_1[0]);
            int second_date = Integer.valueOf(arr_1[1]);
            int third_date = Integer.valueOf(arr_1[2]);
            int total_date = third_date * 365 + first_date * 31 + second_date;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                int name_total_date = name_third_date * 365 + name_first_date * 31 + name_second_date;
                if (name_total_date >= total_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 5) {
            System.out.println(
                    "Enter the value that you want date to be LESS THAN OR EQUAL TO filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int first_date = Integer.valueOf(arr_1[0]);
            int second_date = Integer.valueOf(arr_1[1]);
            int third_date = Integer.valueOf(arr_1[2]);
            int total_date = third_date * 365 + first_date * 31 + second_date;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                int name_total_date = name_third_date * 365 + name_first_date * 31 + name_second_date;
                if (name_total_date <= total_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 6) {
            System.out.println("Enter the low date boundary to filter:\n(Example: 4/4/33)");
            String ending = scan.nextLine();
            String[] arr_1 = ending.split("/");
            int low_first_date = Integer.valueOf(arr_1[0]);
            int low_second_date = Integer.valueOf(arr_1[1]);
            int low_third_date = Integer.valueOf(arr_1[2]);
            int low_total_date = low_third_date * 365 + low_first_date * 31 + low_second_date;
            System.out.println("Enter the high date boundary to filter:\n(Example: 4/4/33)");
            String ending_ = scan.nextLine();
            String[] arr_1_ = ending_.split("/");
            int high_first_date = Integer.valueOf(arr_1_[0]);
            int high_second_date = Integer.valueOf(arr_1_[1]);
            int high_third_date = Integer.valueOf(arr_1_[2]);
            int high_total_date = high_third_date * 365 + high_first_date * 31 + high_second_date;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                int name_second_date;
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                    name_second_date = Integer.valueOf(arr_2[1]);
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_first_date = 0;
                    name_second_date = 0;
                    name_third_date = 0;
                }
                int name_total_date = name_third_date * 365 + name_first_date * 31 + name_second_date;
                if (name_total_date > low_total_date && name_total_date < high_total_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 7) {
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                if (name.length() == 0) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 8) {
            System.out.println("Enter the exact year value that you want to filter:\n(Example: 1933 OR 33)");
            String ending = scan.nextLine();
            int year = Integer.valueOf(ending);
            year %= 100;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_third_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_third_date = Integer.valueOf(arr_2[2]);
                } else {
                    name_third_date = 0;
                }
                if (year == name_third_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 9) {
            System.out.println("Enter the exact month value that you want to filter:\n(Example: 1933 OR 33)");
            String ending = scan.nextLine();
            int month = Integer.valueOf(ending);
            month %= 100;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_first_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_first_date = Integer.valueOf(arr_2[0]);
                } else {
                    name_first_date = 0;
                }
                if (month == name_first_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else if (choice == 10) {
            System.out.println("Enter the exact day value that you want to filter:\n(Example: 1933 OR 33)");
            String ending = scan.nextLine();
            int day = Integer.valueOf(ending);
            day %= 100;
            for (int j = 0; j < copy_list.size(); j++) {
                Field privateField = Plane_Crash.class.getDeclaredField(filter_parameter);
                privateField.setAccessible(true);
                String name = (String) privateField.get(copy_list.get(j));
                int name_second_date;
                if (!name.equals("")) {
                    String[] arr_2 = name.split("/");
                    name_second_date = Integer.valueOf(arr_2[1]);
                } else {
                    name_second_date = 0;
                }
                if (day == name_second_date) {
                    return_statement.add(copy_list.get(j));
                }
            }
        } else
            System.out.println("Invalid Operation!");
        return return_statement;
    }
}
