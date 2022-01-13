class Plane_Crash {
    private String Date;
    private String Time;
    private String Location;
    private String Operator;
    private String Flight;
    private String Route;
    private String Type;
    private String Registration;
    private String cn_In;
    private String Aboard;
    private String Fatalities;
    private String Ground;
    private String Survivors;
    private String SurvivalRate;
    private String Summary;
    private String ClustID;
    private int first_date;
    private int second_date;
    private int third_date;
    private int first_time;
    private int second_time;

    public Plane_Crash(String date, String time, String location, String operator, String flight, String route,
            String type, String registration, String cn_In, String aboard, String fatalities, String ground,
            String survivors, String survivalRate, String summary, String clustID) {
        this.Date = date;
        this.Time = time;
        this.Location = location;
        this.Operator = operator;
        this.Flight = flight;
        this.Route = route;
        this.Type = type;
        this.Registration = registration;
        this.cn_In = cn_In;
        this.Aboard = aboard;
        this.Fatalities = fatalities;
        this.Ground = ground;
        this.Survivors = survivors;
        this.SurvivalRate = survivalRate;
        this.Summary = summary;
        this.ClustID = clustID;

        String[] arr = Date.split("/");
        this.first_date = Integer.valueOf(arr[0]);
        this.second_date = Integer.valueOf(arr[1]);
        this.third_date = Integer.valueOf(arr[2]);

        if (!Time.equals("")) {
            String[] arr_2 = Time.split(":");
            this.first_time = Integer.valueOf(arr_2[0]);
            this.second_time = Integer.valueOf(arr_2[1]);
        } else {
            this.first_time = 0; // default value for hour
            this.second_time = 0; // default value for minute
        }

    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getLocation() {
        return Location;
    }

    public String getOperator() {
        return Operator;
    }

    public String getFlight() {
        return Flight;
    }

    public String getRoute() {
        return Route;
    }

    public String getType() {
        return Type;
    }

    public String getRegistration() {
        return Registration;
    }

    public String getCn_In() {
        return cn_In;
    }

    public String getAboard() {
        return Aboard;
    }

    public String getFatalities() {
        return Fatalities;
    }

    public String getGround() {
        return Ground;
    }

    public String getSurvivors() {
        return Survivors;
    }

    public String getSurvivalRate() {
        return SurvivalRate;
    }

    public String getSummary() {
        return Summary;
    }

    public String getClustID() {
        return ClustID;
    }

    public int getFirstDate() {
        return first_date;
    }

    public int getSecondDate() {
        return second_date;
    }

    public int getThirdDate() {
        return third_date;
    }

    public int getFirstTime() {
        return first_time;
    }

    public int getSecondTime() {
        return second_time;
    }

    public String toString() {
        return "[ " + "Date: " + this.Date + ", Time: " + this.Time + ", Location: " + this.Location + ", Operator: "
                + this.Operator + ", Flight: " + this.Flight + ", Route: " + this.Route + ", Type: " + this.Type
                + ", Registration: " + this.Registration + ", cn_In: " + this.cn_In + ", Aboard: " + this.Aboard
                + ", Fatalities: " + this.Fatalities + ", Ground: " + this.Ground + ", Survivors: " + this.Survivors
                + ", Survival Rate: " + this.SurvivalRate + ", Summary: " + this.Summary + ", ClustID: " + this.ClustID
                + " ]";
    }
}